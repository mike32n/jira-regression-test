import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private final WebDriver driver = new ChromeDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver);
    private ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage(driver);
    private GlassPage projectConfigPageGlass = new GlassPage(driver);

    @BeforeSuite
    public void setup() {
        System.setProperty(PageUtils.WEBDRIVER, PageUtils.CHROME_DRIVER_LOCATION);
        loginPage.start(PageUtils.BASE_URL);
        loginPage.login();
    }

    @Test(testName = "Glass Issue Type Schemes")
    public void glassIssueTypeSchemes() {
        mainPage.navigate(PageUtils.GLASS_URL);

        projectConfigPageGlass.clickOnProjectSettingButton();
        projectSettingsPage.verifyIssueTypes();

        mainPage.navigate(PageUtils.GLASS_URL);

        projectConfigPageGlass.clickOnSchemeTab();
        projectConfigPageGlass.verifyScheme();

        projectConfigPageGlass.clickOnIssueTypeDropdown();
        projectConfigPageGlass.verifyIssueTypes();

    }

    @AfterSuite
    public void cleanUp() {
        mainPage.logout();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
