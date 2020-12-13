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

    public static String getUsername() {
        return System.getProperty("USER");
    }

    public static String getPassword() {
        return System.getProperty("PASS");
    }
}
