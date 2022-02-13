
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ProgramOne {
    //program to post a tweet


    public static void main(String[] args) {
        try {
            Properties prop = new Properties();
            String propFileName = "application.properties";

            InputStream inputStream = ProgramOne.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            //Getting the properties from file
            String consmerKey = prop.getProperty("consumerKey");
            String consumerSecret = prop.getProperty("consumerSecret");
            String accessToken = prop.getProperty("accessToken");
            String tokenSecret = prop.getProperty("tokenSecret");

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey(consmerKey)
                    .setOAuthConsumerSecret(consumerSecret)
                    .setOAuthAccessToken(accessToken)
                    .setOAuthAccessTokenSecret(tokenSecret);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            StringBuffer s = new StringBuffer();
            for (int i = 0; i < args.length; i++) {
                s.append(args[i] + " ");
            }
            String string = s.toString();

            Status status = twitter.updateStatus(string);
            String str = status.getText();
            System.out.println(str);
        }

        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
