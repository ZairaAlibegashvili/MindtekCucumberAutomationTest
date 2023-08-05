package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static FileInputStream input;
    private static Properties properties;

    static {
        //* Path to the configurations.properties file
        String path=System.getProperty("user.dir")+ "\\src\\test\\resources\\configurations\\Configurations.properties";

        try {
            //* FileInputStream gets the file from provided path
            input= new FileInputStream(path);
            //property load data from the input file
            properties= new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties file is invalid");;
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");
        }finally {
            try {
                assert input != null;
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occurred when trying to close input object");
            }
        }
    }
    //this method gets values from configuration.properties file with using the provided key
    public static String getProperty(String key){
        return properties.getProperty(key);

    }
}

