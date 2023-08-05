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
        //Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath(".//a[text()='skachok']")));
        Assertions.assertDoesNotThrow(() -> allElementsPage.getCheckUserLogin());

        allElementsPage.logout();
    }

    @Test
    @Order(2)
    void badLoginTest() throws InterruptedException {
        allElementsPage.badLogin();

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(() -> allElementsPage.getError401Text());
    }

    @Test
    @Order(3)
    void moreLoginOptionsBadLogin() throws InterruptedException {
        allElementsPage.simpleLogin(allElementsPage.getLogin()+"S");
        Thread.sleep(1000);
        allElementsPage.simplePswd(allElementsPage.getPassword());

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(() -> allElementsPage.getError401Text());
    }

    @Test
    @Order(3)
    void moreLoginOptionsBadPassword() throws InterruptedException {
        allElementsPage.simpleLogin(allElementsPage.getLogin());
        allElementsPage.simplePswd(allElementsPage.getPassword()+"S");

        Thread.sleep(2000);
        Assertions.assertDoesNotThrow(() -> allElementsPage.getError401Text());
    }
}
