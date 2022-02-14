package com.twitter.starter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class YMLConfig {
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String tokenSecret;

    public void setValues() {
        try {
            Properties prop = new Properties();
            String propFileName = "application.yml";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            //Getting the properties from file
            consumerKey = prop.getProperty("key");
            consumerSecret = prop.getProperty("secret");
            accessToken = prop.getProperty("accessToken");
            tokenSecret = prop.getProperty("tokenSecret");
        } catch (IOException e) {
            System.out.println("Error reading properties file");

        }
    }

    public String getConsumerKey(){
        setValues();
        return this.consumerKey;
    }

    public String getConsumerSecret(){
        return this.consumerSecret;
    }

    public String getAccessToken(){
        return this.accessToken;

    }

    public String getTokenSecret(){
        return this.tokenSecret;
    }

    }
