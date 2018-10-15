package logic;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface INotificatieHandler 
{
	void stuurBericht(String[] dataTankBeheerders, EBerichtType berichtType);
}