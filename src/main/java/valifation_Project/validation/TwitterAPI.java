package valifation_Project.validation;

import twitter4j.AccountSettings;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;


public class TwitterAPI {
	Twitter twitter = new TwitterFactory().getInstance();
	ResponseList<Status> timeline;
	AccountSettings setting;
	public TwitterAPI(){
		twitter.setOAuthConsumer("GtEt38OCcSPvPscg25s8QEnY1", "5khQeJ0nlYtRQBJR9Vp4SRB9B05KSPkWWiOug8TrLhFZ5tFloX");
		twitter.setOAuthAccessToken(new AccessToken("2246793824-JiTzCOhwTjZfl7uYf3QY5Blqc2V5z92Qs4hcvST", "TkJBVp3EN0YDEeobLBjWE84pmtkifPcs072jQH2rYgnGh"));
	}
	public boolean checkTwitterAPI() throws TwitterException{
		
		try
		{
			timeline = twitter.getUserTimeline(new Paging(1,5));
			
		}
		catch(Exception e) {
			
		}
		if(timeline == null || timeline.isEmpty())
		{
			System.out.println("Retrieving Data API is down");
			return false;
		}
		else
		{
			System.out.println("Content retrieving API is working fine");
			boolean check = CheckSearchAPI();
			if(check == false)
			{
				return false;
			}
			else
			return true;
		}
			
		
	}
	// This method is to test and prove the concept of testing parts of the API's , to know where the problem is exactly if it's not in the whole API's server
	public boolean CheckSearchAPI() throws TwitterException{
		 setting = twitter.getAccountSettings();
		 if(setting == null)
		 {
			System.out.println("Settings  API is not working"); 
			 return false; 
		 }
		 else
		 {
			 System.out.println("Settings API is working fine");
			 return true;
		 }
	}
}
