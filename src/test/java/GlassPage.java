import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlassPage extends PageObject{

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
    @FindBy(xpath = "//a[@id='aui-uid-3']")
    private WebElement schemeTab;
    @FindBy(xpath = "//div[@id='glass-general-schemes-panel']/div/table/tbody/tr/td[2]")
    private WebElement schemeType;
    @FindBy(xpath = "//li[@id='glass-workflow-nav']/a/div")
    private WebElement issueTypes;
    @FindBy(linkText = "Bug")
    private WebElement bug;
    @FindBy(linkText = "Epic")
    private WebElement epic;
    @FindBy(linkText = "Story")
    private WebElement story;
    @FindBy(linkText = "Task")
    private WebElement task;
    @FindBy(linkText = "Sub-task")
    private WebElement subTask;

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

    public void verifyScheme() {
        Assert.assertEquals("PP1: Scrum Issue Type Scheme", schemeType.getText());
    }

    public void clickOnSchemeTab() {
        clickOn(schemeTab);
    }

    public void clickOnIssueTypeDropdown() {
        clickOn(issueTypes);
    }

    public void verifyIssueTypes() {
        Assert.assertEquals(bug.getText(), "Bug");
        Assert.assertEquals(epic.getText(), "Epic");
        Assert.assertEquals(story.getText(), "Story");
        Assert.assertEquals(task.getText(), "Task");
        Assert.assertEquals(subTask.getText(), "Sub-task");
    }
}
