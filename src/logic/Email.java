package logic;

import java.security.spec.ECField;
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
		String[] emailAdressen = {"falcoverhagen@gmail.com", "falcoverhagen88@gmail.com"};
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

		try {
			/**
			 * Sender's credentials
			 * */
			String fromUser = "lorisensori@gmail.com";
			String fromUserEmailPassword = "groep2test";
			String emailHost = "smtp.gmail.com";
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			/**Draft the message
			 * */

			String[] toEmails = emailTankBeheerders;
			String emailSubject = "Test email LoriSensori";

			//TODO Welke email templates en waar maken???
			String emailBody = "This is an email sent by LoriSensori an awesome project " + berichtType.toString();
			MimeMessage emailMessage = new MimeMessage(mailSession);
			/**
			 * Set the mail recipients
			 * */
			for (int i = 0; i < toEmails.length; i++) {
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
