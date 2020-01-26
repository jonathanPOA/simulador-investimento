package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


    private Properties property;
    private FileReader fileReader = null;

    public PropertyReader(){
        this.readProperties();
    }

    private void readProperties() {
        try {
            this.property = new Properties();
            if (fileReader == null) {
                fileReader = new FileReader("./src/test/resources/dados.properties");
                property.load(fileReader);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property) {
        return this.property.getProperty(property);
    }

}
