package valifation_Project.validation;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {
	//This class is to send an alarm when ever a service is down. 
	final String Email = "CS585test@gmail.com";
	final String password = "verifcationandvalidation";
	String Subscriber_Email = "mahmodyar@gmail.com"; // you can put here any email address you want the alarms to arrive on. 
	
	public boolean Send(String service_name){
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Email, password);
			}
		});
		
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("CS585test@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(Subscriber_Email));
			message.setSubject("Service Down Alert");
			message.setText("This is a message to let you know that the Service "+service_name+" you are monitoring is down");
			Transport.send(message);
			return true;
		}
		catch(MessagingException e){
			throw new RuntimeException(e);
		}
	}

}
