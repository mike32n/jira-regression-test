import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends PageObject{

    @FindBy(id = "view_project_issuetypes")
    private WebElement menuIssueTypes;
    @FindBy(xpath = "//*[@id='project-config-issuetypes-table']//tr[1]/td[2]//a")
    private WebElement story;
    @FindBy(xpath = "//*[@id='project-config-webpanel-summary-issuetypes']//p/a")
    private WebElement issueTypeScheme;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuIssueTypes() {
        clickOn(menuIssueTypes);
    }

    public void verifyIssueTypes() {
        Assert.assertEquals(story.getText(), "Story");
    }

    public String getIssueTypeScheme() {
        return issueTypeScheme.getText();
    }
}
