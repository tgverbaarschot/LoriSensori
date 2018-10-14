package logic;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public abstract class Bericht implements INotificatieHandler
{
	public void stuurBericht(String[] emailTankBeheerders, EBerichtType berichtType) throws AddressException, MessagingException 
	{
		// TODO Auto-generated method stub	
	}
}


