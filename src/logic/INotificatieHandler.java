package logic;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface INotificatieHandler 
{
	void stuurBericht(String[] emailTankBeheerders, EBerichtType berichtType) throws AddressException, MessagingException;
}