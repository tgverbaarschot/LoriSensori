package logic;

import java.net.PortUnreachableException;

public class TechnischBeheerder extends FunctioneelBeheerder
{
	public TechnischBeheerder(String voornaam, String achternaam, String gebruikersnaam, String wachtwoord, String email, String telefoonnummer) 
	{
		super(voornaam, achternaam, gebruikersnaam, wachtwoord, email, telefoonnummer);
	}
	
	public TechnischBeheerder() {}

	public boolean aanmakenBedrijf(Bedrijf testBedrijf) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean afmeldenBedrijf(Bedrijf testBedrijf) {
		// TODO Auto-generated method stub
		return false;
	}

	public Bedrijf zoekBedrijf(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
