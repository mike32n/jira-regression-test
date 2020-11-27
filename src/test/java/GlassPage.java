import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlassPage extends PageObject{

    @FindBy(xpath = "//ol/li/a")
    private WebElement headerLink;
    @FindBy(xpath = "//*[@id='sidebar-page-container']//h1")
    private WebElement projectTitle;
    @FindBy(xpath = "//*[@id='glass-general-panel']/div[1]//tr[1]/td[2]")
    private WebElement summaryProjectName;
    @FindBy(xpath = "//*[@id='glass-general-panel']//p[4]/b")
    private WebElement infoBoxProjectName;
    @FindBy(xpath = "//*[@id='content']//nav/div/div[2]/ul/li[3]/a")
    private WebElement sideBarShipIcon;
    @FindBy(xpath = "//*[@id='aui-uid-2']")
    private WebElement versionsTab;
    @FindBy(linkText = "Test PP1")
    private WebElement versionName;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[1]/nav/div/div[2]/ul/li[6]/a/span[1]")
    private WebElement sideBarComponentIcon;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[2]/a[1]")
    private WebElement projectSettingButton;
    @FindBy(xpath = "//*[@id='glass-general-panel']/div[2]//li[3]")
    private WebElement schemeTab;
    @FindBy(xpath = "//div[@id='glass-general-schemes-panel']/div/table/tbody/tr/td[2]")
    private WebElement schemeType;
    @FindBy(xpath = "//*[@id='glass-workflow-nav']/a")
    private WebElement issueTypesDropList;
    @FindBy(linkText = "Story")
    private WebElement story;
    @FindBy(xpath = "//*[@id='glass-general-panel']//span[3]")
    private WebElement storyIcon;
    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//tr[1]/td[2]")
    private WebElement issueTypeScheme;

    public GlassPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnsideBarShipIcon() {
        clickOn(sideBarShipIcon);
    }

    public void clickOnVersions() {
        clickOn(versionsTab);
    }

    public void clickOnSideBarComponentIcon() {
        clickOn(sideBarComponentIcon);
    }

    public void verifyNewVersionName(String name) {
        waitForClickable(versionName);
        Assert.assertEquals(name, versionName.getText());
    }

    public void verifyNewGlassComponent() {
        Assert.assertEquals("glass test", driver.findElement(By.xpath("//td[contains(.,'glass test')]")).getText());
    }

    public void clickOnProjectSettingButton() {
        clickOn(projectSettingButton);
    }

    public void clickOnSchemeTab() {
        clickOn(schemeTab);
    }

    public void clickOnIssueTypeDropdown() {
        clickOn(issueTypesDropList);
    }

    public void verifyIssueTypes() {
        Assert.assertEquals(story.getText(), "Story");
    }

    public void verifyIssueIcon() {
        Assert.assertEquals(storyIcon.getAttribute("title"), "Story");
    }

    public void verifyHeaderLinkName(String projectName) {
        waitForVisibility(headerLink);
        String text = headerLink.getAttribute("name");
        Assert.assertEquals(projectName, text);
    }

    public void verifyHeaderName(String projectName) {
        waitForVisibility(projectTitle);
        Assert.assertTrue(projectTitle.getText().startsWith(projectName));
    }

    public void verifyProjectName(String projectName) {
        waitForVisibility(summaryProjectName);
        Assert.assertEquals(summaryProjectName.getText(), projectName);
    }

    public void verifyInfoBoxProjectName(String projectName) {
        waitForVisibility(infoBoxProjectName);
        String text = infoBoxProjectName.getAttribute("innerText");
        Assert.assertEquals(projectName, text);
    }

    public void verifyIssueTypeScheme(String issueTypeScheme) {
        Assert.assertEquals(this.issueTypeScheme.getText(), issueTypeScheme);
    }
}