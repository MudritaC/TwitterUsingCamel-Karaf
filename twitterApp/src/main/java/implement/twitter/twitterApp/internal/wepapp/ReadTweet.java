package implement.twitter.twitterApp.internal.wepapp;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;




public class ReadTweet implements Processor {
	
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.copy();
		
	}
	

}
