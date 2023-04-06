package com.example.application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class MyPropertiesWrapper {
    Properties properties = new Properties();
    File f = Paths.get("C:\\eCom\\projekte\\eclernen0822\\eclernen0822\\JavaGame\\src\\main\\resources\\application.properties").toFile();

    File test = Paths.get("C:\\eCom\\projekte\\eclernen0822\\eclernen0822\\JavaGame\\src\\main\\resources\\test-application.properties").toFile();

    FileReader fileOfProperties = new FileReader(f);
    FileReader fileOfTestProperties = new FileReader(test);

    public MyPropertiesWrapper(String mode) throws IOException {
        if (Objects.equals(mode, "test")){
            properties.load(fileOfTestProperties);
        }
        else {
            properties.load(fileOfProperties);
        }
    }

    public String getDBUrl() {
        return properties.getProperty("spring.datasource.url");
    }
    public String getUser() {
        return properties.getProperty("spring.datasource.username");
    }
    public String getPass() {
        return properties.getProperty("spring.datasource.password");
    }

    public void closeFileReader() throws IOException {
        fileOfProperties.close();
    }
}
