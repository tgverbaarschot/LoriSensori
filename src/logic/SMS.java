package logic;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS extends Bericht 
{
	
	public static final String ACCOUNT_SID = "ACa4225ffac03833264f310d7a3b06b370";
	public static final String AUTH_TOKEN = "d98797ee36683f4c4a4c51a902e11b3c";
	public static final String PHONE_NUMBER = "+3197014200430";
	
	public static void main(String[]args) 
	{
	    SMS sms = new SMS();
	    String[] telefoonNummers = {"+31627858883", "+31645520760", "+31685861422", "+31652276863" };
	    EBerichtType berichtType = EBerichtType.ONGEWENSTE_NIVEAU_DALING;
	    
	    sms.stuurBericht(telefoonNummers, berichtType);
	}
	

	public void stuurBericht(String[] telefoonNrTankBeheerders, EBerichtType berichtType)
	{
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		for(String telefoonNummer : telefoonNrTankBeheerders) 
		{
			Message message = Message.creator(new PhoneNumber(telefoonNummer), new PhoneNumber(PHONE_NUMBER) , berichtType.toString() +
					" ER HEEFT EEN NIVEAUDALING BUITEN OPENINGSTIJDEN PLAATSGEVONDEN!!!").create();
			
			System.out.println(message.getSid());
		}
		
	}
}
