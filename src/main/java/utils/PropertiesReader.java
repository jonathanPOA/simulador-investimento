package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static Properties props = new Properties();
    private static String propertiesFile;

    public PropertiesReader(String propsFile) {
        propertiesFile = propsFile;
    }

    public Properties readProps() {
        try {
            FileReader reader = new FileReader(propertiesFile);
            props.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
