import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    @FindBy(xpath = "//*[@id='login-form-username']")
    private WebElement fieldUsername;
    @FindBy(id = "login-form-password")
    private WebElement fieldPassword;
    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='content']//strong")
    private WebElement logoutMessage;

    @FindBy(xpath = "//*[@id='usernameerror']/p")
    private WebElement errorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        setUsername();
        setPassword();
        clickLoginButton();
    }

    public void setUsername() {
        try {
            acceptAlert();
        } catch (Exception ignore) {
        }
        waitForClickable(fieldUsername);
        fieldUsername.sendKeys(PageUtils.username);
    }

    public void setUsername(String user) {
        try {
            acceptAlert();
        } catch (Exception ignore) {
        }
        waitForClickable(fieldUsername);
        fieldUsername.sendKeys(user);
    }

    public void setPassword() {
        waitForClickable(fieldPassword);
        fieldPassword.sendKeys(PageUtils.password);
    }

    public void setPassword(String pass) {
        waitForClickable(fieldPassword);
        fieldPassword.sendKeys(pass);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }
}
