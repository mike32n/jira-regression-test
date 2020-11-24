import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadLoginProperties {

    public static Properties readLoginPropertiesFile(String fileName) throws IOException {
        InputStream fileStream = new FileInputStream(fileName);
        Properties properties = new Properties();
        try {
            properties.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileStream.close();
        }
        return properties;
    }

    public static String getUsername() throws IOException {
        return readLoginPropertiesFile("src/main/resources/login.properties").getProperty("username");
    }

    public static String getPassword() throws IOException {
        return readLoginPropertiesFile("src/main/resources/login.properties").getProperty("password");
    }
}
