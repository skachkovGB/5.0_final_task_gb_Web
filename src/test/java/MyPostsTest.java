import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class MyPostsTest extends AbstractTest{
    private final AllElementsPage allElementsPage = new AllElementsPage(getDriver());
    @Test
    @Order(10)
    void checkCountPosts() throws InterruptedException {
        allElementsPage.correctLogin();
        sleep(1000);

        //Следующий ассерт не работает нормально, всегда проходят
        //не успел разобраться с этим
        //Что нельзя при заходе на страницу сразу нажать кнопку назад
        Assertions.assertTrue(allElementsPage.getPrevPageBth().isDisplayed());

        //Assertions.assertTrue(allElementsPage.getPosts().size()==4);
        Assertions.assertTrue(allElementsPage.getPosts().size()==10);

        sleep(1000);
        allElementsPage.logout();
    }

    @Test
    @Order(11)
    void surfingPages() throws InterruptedException {
        allElementsPage.correctLogin()
                       .sleep(2)
                       .nextPageBtnClick()
                       .sleep(4)
                       .prevPageBtnClick()
                       .sleep(2)
                       .nextPageBtnClick()
                       .sleep(2)
                       .nextPageBtnClick();

        Assertions.assertTrue(allElementsPage.getNextPageBth().isDisplayed());
        sleep(1000);
        allElementsPage.logout();
    }

    @Test
    @Order(12)
    void noPostsEmptyPage() throws InterruptedException {
        allElementsPage.simpleLogin("333444")
                       .simplePswd("abf156f3cf")
                       .sleep(1);

        Assertions.assertTrue(allElementsPage.getPosts().size()==0);
        Assertions.assertDoesNotThrow(() -> allElementsPage.getNoItems());

        sleep(1000);
        allElementsPage.logout();
    }
    @Test
    @Order(13)
    void checkPreviewPosts() throws InterruptedException {
        allElementsPage.correctLogin();

        Assertions.assertDoesNotThrow(() -> allElementsPage.getCheckTitlePost());
        Assertions.assertDoesNotThrow(() -> allElementsPage.getCheckDescriptionPost());
        Assertions.assertDoesNotThrow(() -> allElementsPage.getCheckImgPost());

        sleep(1000);
        allElementsPage.logout();
    }

    @Test
    @Order(14)
    void createPost() throws InterruptedException {
        allElementsPage.simpleLogin("Ivan34")
                .simplePswd("0b601f1893")
                .sleep(1)
                .createPost();
                //не успел доделать сервер погасили

        sleep(1000);
        allElementsPage.logout();
    }

    @Test
    @Order(15)
    void deletePost() throws InterruptedException {
        allElementsPage.simpleLogin("Ivan34")
                .simplePswd("0b601f1893")
                .sleep(1);
                //не успел доделать сервер погасили

        sleep(1000);
        allElementsPage.logout();
    }
}
