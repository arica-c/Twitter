
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ProgramTwo {
    public static void main(String[] args){
        try{
            Properties prop = new Properties();
            String propFileName = "application.properties";

            InputStream inputStream = ProgramOne.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
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

                List<String> list = twitter.getHomeTimeline().stream()
                        .map(item -> item.getText())
                        .collect(Collectors.toList());


                for (String s : list) {
                    System.out.println(s);
                }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
