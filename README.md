Dropbox account user name : CS585test@gmail.com
Dropbox password : verifcationandvalidation

Gmail account : CS585test@gmail.com
Gmail password : verifcationandvalidation


Important notes before running the prototype:


1- You have to logon to Dropbox account for the api to run, After the api runs, it will provide you with a link. Copy and paste that link to the browser and Allow the app. After allowing the app you'll get a link that you should post in the console. 

2- Set the Email Address where you want the Alarms to arrive in the SendEmail.java file. 

	Ideally it should be put in an infinite loop each test in it's own thread and let it run, however, the problem is that each API has different set of restrictions. For instance, Twitter API's allow certain amount of requests then a pause for 15 mins or so and then another number of requests. And so other services. 
	
	
	First, the Twitter API test, the test will performs on two different API calls, one is for the retrieval of the Timeline, to check if the retrieval API works well or not, if it works then a message will appear saying it passed the test and nothing is wrong with the api. The other test is for the Retrial of the settings, to test the settings API. If it works then a message will appear. If not it sends an email saying Twitter API has something wrong with it. 
	
	Second, the Dropbox API test, it has two tests as well, one info retrieval , the other API is remaining size in the account retrieval to test if they both works or not. If they both works then messages will appear, if either fail. Then an email will be sent and a message will appear. There is a special procedure to do before the start of the test, Check #1 top of this page.
	
	
	
	
	
	
	FiTwitterAPI.Java