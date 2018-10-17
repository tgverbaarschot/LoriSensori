package logic;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email extends Bericht{
	
	Session mailSession;
	 
	public static void main(String args[]) throws AddressException, MessagingException
	{
		String[] emailAdressen = {""};//enter the email addresses you want to send the notification to here
	    EBerichtType berichtType = EBerichtType.ONGEWENSTE_NIVEAU_DALING;
	    Email javaEmail = new Email();
	    javaEmail.stuurBericht(emailAdressen, berichtType);    
	}
	 
	public void stuurBericht(String[] emailTankBeheerders, EBerichtType berichtType) 
	{
		
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.socketFactory.port", "465");
		emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.port", "465");
		
		mailSession = Session.getDefaultInstance(emailProperties, null);
		
		try 
		{
			/**
		     * Sender's credentials
		     * */
		   String fromUser = "lorisensori@gmail.com";//you can change this to any gmail account
		   String fromUserEmailPassword = "********";//Falco has the password for this gmail account
		   String emailHost = "smtp.gmail.com";
		   Transport transport = mailSession.getTransport("smtp");
		   transport.connect(emailHost, fromUser, fromUserEmailPassword);
		   /**Draft the message
		    * */
		   String[] toEmails = emailTankBeheerders;
		   String emailSubject = "Test email LoriSensori";
		        
		   //TODO Welke email templates en waar maken???
		   String emailBody = "This email is sent by LoriSensori because a " + berichtType.toString() + " has occured!!" + " HALLOOOOOO";
		   MimeMessage emailMessage = new MimeMessage(mailSession);
		   /**
		   * Set the mail recipients 
		   * */    
		   for (int i = 0; i < toEmails.length; i++)
		   {
			   emailMessage.setFrom(new InternetAddress(toEmails[i]));
		       emailMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmails[i]));    
		   }
		   emailMessage.setSubject(emailSubject);
		   /**
		   * If sending HTML mail)
		   * */
		   emailMessage.setContent(emailBody, "text/html");
		   /**
		   * If sending only text mail
		   * */
		   //emailMessage.setText(emailBody);// for a text email
		   /**
		   * Send the mail
		   * */
		   transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		   transport.close();
		   System.out.println("Email sent successfully."); 
		}
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
}
