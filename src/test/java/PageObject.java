import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void start(String url) {
        deleteCookies();
        maximizeWindow();
        navigate(url);
    }

    protected void clickOn(WebElement webElement) {
        waitForClickable(webElement);
        webElement.click();
    }

    protected void scrollToView(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void waitForClickable(WebElement webElement) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForVisibility(WebElement webElement) throws Error {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void acceptAlert() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
