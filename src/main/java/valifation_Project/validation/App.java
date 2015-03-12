package valifation_Project.validation;

import java.io.IOException;

import twitter4j.TwitterException;

import com.dropbox.core.DbxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, DbxException, TwitterException
    {
    	// Call Twitter test class
    	TwitterAPI t = new TwitterAPI();
    	// If twitter pass tests it will return TRUE, Else return FALSE
    	boolean check = t.checkTwitterAPI();
    	//If Twitter Check return False then there is something wrong with the API, and it will trigger an Alarm , which will send an email to a specific account 
    	if(check == false)
    	{
    		System.out.println("There is something wrong with TWITTER API");
    		//Call send email class
    		SendEmail s = new SendEmail();
    		//Send the Service name that has a problem to be included in the email
    		s.Send("Twitter");
    	}
    	else
    	{
    		System.out.println("Twitter API's are working nomrally");
    	}
    	
    	// Call Dropbox API test class
    	DropBoxAPI dropbox = new DropBoxAPI();
    	//If Check Dropbox returned false, there it's not working 
    	boolean dcheck = dropbox.CheckDropboxAPI();
    	// If the returned value is false then send an email 
    	if(dcheck == false)
    	{
    		SendEmail ss = new SendEmail();
    		ss.Send("Dropbox");
    	}
    	else
    	{
    		System.out.println("DropBox API's are running normally ");
    	}
    }
}
