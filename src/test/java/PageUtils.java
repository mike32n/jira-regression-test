import java.io.IOException;

public class PageUtils {

    final static String BASE_URL = "https://jira.codecool.codecanvas.hu/";
    final static String WEBDRIVER = "webdriver.chrome.driver";
    final static String CHROME_DRIVER_LOCATION = "/usr/bin/chromedriver";
    final static String PROFILE_PAGE = "https://jira.codecool.codecanvas.hu/secure/ViewProfile.jspa";
    final static String PROJECT_SETTINGS = "https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP1/summary";
    final static String GLASS_URL = "https://jira.codecool.codecanvas.hu/projects/PP1?selectedItem=com.codecanvas.glass:glass";
    static String username;
    static String password;

    static {
        username = ReadLoginProperties.getUsername();
    }

    static {
        password = ReadLoginProperties.getPassword();
    }
}
