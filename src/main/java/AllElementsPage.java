import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//input[@type='password']")
    private WebElement pswdArea;
    @FindBy(xpath = "//span[.='Login']")
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
    //12) локаторы для постов

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

    public AllElementsPage simplePswd(String pswd){
        pswdArea.clear();
        pswdArea.sendKeys(pswd);

        loginBtn.click();
        return this;
    }

    public static String getPassword() {
        return password;
    }
}