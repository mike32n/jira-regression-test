import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends PageObject{

    @FindBy(xpath = "(//a[contains(text(),'Bug')])[2]")
    private WebElement bug;
    @FindBy(xpath = "(//a[contains(text(),'Epic')])[2]")
    private WebElement epic;
    @FindBy(xpath = "(//a[contains(text(),'Story')])[2]")
    private WebElement story;
    @FindBy(xpath = "(//a[contains(text(),'Task')])[2]")
    private WebElement task;
    @FindBy(xpath = "(//a[contains(text(),'Sub-task')])[2]")
    private WebElement subTask;
    @FindBy(xpath = "//*[@id='project-config-webpanel-summary-issuetypes']/div[2]/div/p/a")
    private WebElement issueTypeScheme;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyIssueTypes() {
        Assert.assertEquals(bug.getText(), "Bug");
        Assert.assertEquals(epic.getText(), "Epic");
        Assert.assertEquals(story.getText(), "Story");
        Assert.assertEquals(subTask.getText(), "Sub-task");
        Assert.assertEquals(task.getText(), "Task");
        Assert.assertEquals(issueTypeScheme.getText(), "PP1: Scrum Issue Type Scheme");
    }
}
