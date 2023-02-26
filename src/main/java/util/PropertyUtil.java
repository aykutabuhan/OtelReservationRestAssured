package util;

import java.io.*;
import java.util.Properties;

public class PropertyUtil {

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";

    public static String getProperty(String propertyName, String fileName){
        Properties properties = null;
        try {
            properties = new Properties();
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_PATH + fileName));
            properties.load(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(propertyName);
    }
    public static void setProperty (String propertyFileName, String input, String outPut) throws IOException {

        FileWriter fileWriter = new FileWriter("src/main/resources/" + propertyFileName);
        Properties properties = new Properties();
        properties.setProperty(input, outPut);
        properties.store(fileWriter, null);
    }
    public static void setProperty (String propertyFileName, String input, int outPut) throws IOException {

        FileWriter fileWriter = new FileWriter("src/main/resources/" + propertyFileName);
        Properties properties = new Properties();
        properties.setProperty(input, String.valueOf(outPut));
        properties.store(fileWriter, null);
    }
}
