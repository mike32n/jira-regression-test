import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty(PageUtils.WEBDRIVER, PageUtils.CHROME_DRIVER_LOCATION);
    }

    private LoginPage loginPage = new LoginPage(driver);

    @Test(testName = "Glass Issue Type Schemes")
    public void glassIssueTypeSchemes() {
        loginPage.start(PageUtils.BASE_URL);
        loginPage.login();

    }

    @AfterSuite
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
