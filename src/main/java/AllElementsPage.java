import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllElementsPage extends AbstractPage {

    private static final String login = "skachok";
    private static final String password = "ec6855b8b3";
    private static final String baseUrl = "https://test-stand.gb.ru/";

    public AllElementsPage(WebDriver driver) {
        super(driver);
    }


    //===================================================================
    //1) локаторы для логина
    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginArea;
    //a[@href='/posts/*']
    @FindBy(xpath = "//input[@type='password']")
    private WebElement pswdArea;
    //@FindBy(xpath = "//span[.='Login']")
    @FindBy(css = ".mdc-button__label")
    private WebElement loginBtn;
    @FindBy(xpath = ".//a[text()='skachok']")
    private WebElement checkUserLogin;
    @FindBy(xpath = ".//h2[text()='401']")
    private WebElement error401Text;
    @FindBy(xpath = "//h1[.='Blog']")
    private WebElement blogHeader;
    @FindBy(css = ".mdc-menu-surface--anchor")
    private WebElement userLogoutAnchor;
    @FindBy(xpath = ".//span[text()='Logout']")
    private WebElement logoutBtn;

    //===================================================================
    //2) локаторы для постов
    @FindBy(xpath = "//div[@class='content']/div[*]/a[@href]")
    private List<WebElement> posts;
    @FindBy(xpath = "//a[text()='Next Page']")
    private WebElement nextPageBth;
    @FindBy(xpath = "//a[text()='Previous Page']")
    private WebElement prevPageBth;
    @FindBy(xpath = "//p[text()='No items for your filter']")
    private WebElement noItems;
    @FindBy(xpath = "//h2[text()='new11']")
    private WebElement checkTitlePost;
    @FindBy(xpath = "//div[text()='new11']")
    private WebElement checkDescriptionPost;
    @FindBy(xpath = "//div[@class='content']/div[*]/a/img[@src]")
    private WebElement checkImgPost;
    @FindBy(xpath = "//button[@id='create-btn']")
    private WebElement createPostBtn;


    public AllElementsPage correctLogin() {
        loginArea.clear();
        loginArea.sendKeys(login);

        pswdArea.clear();
        pswdArea.sendKeys(password);

        loginBtn.click();
        return this;
    }

    public AllElementsPage logout() throws InterruptedException {
        userLogoutAnchor.click();
        Thread.sleep(1000);
        logoutBtn.click();

        return this;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public WebElement getCheckUserLogin() {
        return checkUserLogin;
    }

    public AllElementsPage badLogin() {
        loginArea.clear();
        loginArea.sendKeys(login + "S");

        pswdArea.clear();
        pswdArea.sendKeys(password);

        loginBtn.click();
        return this;
    }

    public String getError401Text() {
        return error401Text.getText();
    }

    public AllElementsPage simpleLogin(String login){
        loginArea.clear();
        loginArea.sendKeys(login);
        return this;
    }

    public static String getLogin() {
        return login;
    }

    public AllElementsPage simplePswd(String pswd) throws InterruptedException {
        pswdArea.clear();
        pswdArea.sendKeys(pswd);
        Thread.sleep(1000);
        loginBtn.click();
        return this;
    }

    public static String getPassword() {
        return password;
    }

    //===================================================================
    public List<WebElement> getPosts() {
        return posts;
    }
    public AllElementsPage nextPageBtnClick(){
        nextPageBth.click();
        return this;
    }
    public AllElementsPage prevPageBtnClick(){
        prevPageBth.click();
        return this;
    }

    public AllElementsPage sleep(int n) throws InterruptedException {
        Thread.sleep(1000*n);
        return this;
    }

    public WebElement getNextPageBth() {
        return nextPageBth;
    }

    public WebElement getPrevPageBth() {
        return prevPageBth;
    }

    public WebElement getNoItems() {
        return noItems;
    }

    public WebElement getCheckTitlePost() {
        return checkTitlePost;
    }

    public WebElement getCheckDescriptionPost() {
        return checkDescriptionPost;
    }

    public WebElement getCheckImgPost() {
        return checkImgPost;
    }

    public AllElementsPage createPost() {
        createPostBtn.click();
        return this;
    }
}