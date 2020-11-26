import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPlan {

    public TestPlan() throws MalformedURLException {
    }

    private MutableCapabilities setOption() {
        MutableCapabilities mutableCapabilities;

        if (System.getenv("STAGE_NAME").equals("run with chrome")) {
            mutableCapabilities = new ChromeOptions();
        } else {
            mutableCapabilities = new FirefoxOptions();
        }
        return mutableCapabilities;
    }

    MutableCapabilities mutCapAsOptions = setOption();


    private final WebDriver driver = new RemoteWebDriver(new URL("https://selenium:" + PageUtils.password + "@seleniumhub.codecool.codecanvas.hu/wd/hub"), mutCapAsOptions);


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

    @Test(testName = "Issue Type Scheme")
    public void issueTypeSchemes() {
        String issueTypeScheme;
        mainPage.navigate(PageUtils.PROJECT_SETTINGS);

        issueTypeScheme = projectSettingsPage.getIssueTypeScheme();

        mainPage.navigate(PageUtils.GLASS_URL);

        glassPage.clickOnSchemeTab();
        glassPage.verifyIssueTypeScheme(issueTypeScheme);
    }

    @AfterSuite
    public void cleanUp() {
        mainPage.logout();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
