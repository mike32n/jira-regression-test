package pages;

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

    @FindBy(xpath = "//*[@id='usernameerror']/p")
    private WebElement errorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
