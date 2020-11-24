import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{

    @FindBy(id = "create_link")
    private WebElement createButton;

    @FindBy(xpath = "//a[@id='header-details-user-fullname']/span/span/img")
    private WebElement userIcon;

    @FindBy(xpath = "//*[@id='log_out']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id='content']//strong")
    private WebElement logoutMessage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigate(String URL) {
        waitForVisibility(userIcon);
        super.navigate(URL);
    }

    public void logout() {
        clickOn(userIcon);
        clickOn(logoutButton);
        waitForVisibility(logoutMessage);
    }
}
