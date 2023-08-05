import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractTest{

    private final AllElementsPage allElementsPage = new AllElementsPage(getDriver());

    @Test
    @Order(1)
    void loginTest() throws InterruptedException {
        allElementsPage.correctLogin();

        Thread.sleep(2000);
        Assertions.assertEquals(allElementsPage.getBaseUrl(), getDriver().getCurrentUrl());
        Assertions.assertDoesNotThrow(allElementsPage::getCheckUserLogin);

        allElementsPage.logout();
    }

    @Test
    @Order(2)
    void badLoginTest() throws InterruptedException {
        allElementsPage.badLogin()
                       .getError401Text();

        Thread.sleep(2000);

        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(3)
    void moreLoginOptionsBadLogin() throws InterruptedException {
        allElementsPage.simpleLogin(allElementsPage.getLogin()+"S");
        Thread.sleep(1000);
        allElementsPage.simplePswd(allElementsPage.getPassword());

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(4)
    void moreLoginOptionsBadPassword() throws InterruptedException {
        allElementsPage.simpleLogin(allElementsPage.getLogin());
        allElementsPage.simplePswd(allElementsPage.getPassword()+"S");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    // mlo - moreLoginOptions
    @Test
    @Order(5)
    void mloLoginLessThenThreeSimbols() throws InterruptedException {
        allElementsPage.simpleLogin("cc");
        allElementsPage.simplePswd("e0323a9039");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(6)
    void mloLoginMoreThen20Simbols() throws InterruptedException {
        allElementsPage.simpleLogin("manymanymanymanymanymany");
        allElementsPage.simplePswd("132586c658");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(7)
    void mloLoginRussianSimbols() throws InterruptedException {
        allElementsPage.simpleLogin("ыфвфывфв");
        allElementsPage.simplePswd("ec65620371");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(8)
    void mloEmptyLoginPassword() throws InterruptedException {
        allElementsPage.simpleLogin("");
        allElementsPage.simplePswd("");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }

    @Test
    @Order(8)
    void mloLoginSpecialSimpbols() throws InterruptedException {
        allElementsPage.simpleLogin("33©");
        allElementsPage.simplePswd("43ade729cf");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getError401Text);
        Assertions.assertEquals("401", allElementsPage.getError401Text());
    }
}