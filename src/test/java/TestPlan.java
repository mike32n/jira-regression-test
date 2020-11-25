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
    private GlassPage glassPage = new GlassPage(driver);

    @BeforeSuite
    public void setup() {
        System.setProperty(PageUtils.WEBDRIVER, PageUtils.CHROME_DRIVER_LOCATION);
        loginPage.start(PageUtils.BASE_URL);
        loginPage.login();
    }

    @Test(testName = "Project Link Name")
    public void projectLinkName() {
        String projectName;
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        projectName = mainPage.getProjectName();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.verifyHeaderLinkName(projectName);
    }

    @Test(testName = "Project Header Name")
    public void projectHeaderName() {
        String projectName;
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        projectName = mainPage.getProjectName();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.verifyHeaderName(projectName);
    }

    @Test(testName = "Project Name In Basic Summary")
    public void projectNameInBasicSummary() {
        String projectName;
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        projectName = mainPage.getProjectName();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.verifyProjectName(projectName);
    }

    @Test(testName = "Project Name Info Box")
    public void projectNameInfoBox() {
        String projectName;
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        projectName = mainPage.getProjectName();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.verifyInfoBoxProjectName(projectName);
    }

    @Test(testName = "Issue Type Schemes")
    public void issueTypeSchemes() {
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        projectSettingsPage.clickOnMenuIssueTypes();
        projectSettingsPage.verifyIssueTypeScheme();
        projectSettingsPage.verifyIssueTypes();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.verifyIssueIcon();

        glassPage.clickOnSchemeTab();
        glassPage.verifyScheme();

        glassPage.clickOnIssueTypeDropdown();
        glassPage.verifyIssueTypes();
    }

    @AfterSuite
    public void cleanUp() {
        mainPage.logout();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
