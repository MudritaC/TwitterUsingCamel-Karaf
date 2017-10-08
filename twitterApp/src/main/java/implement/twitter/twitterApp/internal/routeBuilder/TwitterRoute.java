package implement.twitter.twitterApp.internal.routeBuilder;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.*;


public class TwitterRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {

		/* Fetching the properties from twitter the property to 
		 * set the consumerKey,consumerSecret,accessToken,accessTokenSecret
		 * to pass to Twitter API
		 */
		Properties prop = new Properties();
		String propFileName = "twitter.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}			
		String consumerKey 		= prop.getProperty("consumer.key");
		String consumerSecret = prop.getProperty("consumer.secret");
		String accessToken = prop.getProperty("access.token");
		String accessTokenSecret = prop.getProperty("access.token-secret");
		/* Calling Twitter search API to get the tweets happening with the keyword as 'SJSU'
		 * This key word can also be moved to properties
		 */
		from("twitter://search?keywords=#SanJose&type=polling&delay=6000&accessToken="
				+ accessToken
				+ "&accessTokenSecret="
				+ accessTokenSecret
				+ "&consumerKey="
				+ consumerKey
				+ "&consumerSecret="
				+ consumerSecret)
		.to("log:tweet")
		.to("websocket://localhost:9090/camel-tweet?sendToAll=true&staticResources=classpath:webapp/.");

	}

}
