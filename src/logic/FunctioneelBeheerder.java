package logic;

public class FunctioneelBeheerder extends Medewerker {

//Constructors 
	public FunctioneelBeheerder(String voornaam, String achternaam, String gebruikersnaam, String wachtwoord, String email, String telefoonnummer)
	{
		super(voornaam, achternaam, gebruikersnaam, wachtwoord, email, telefoonnummer);
	}
	
	public FunctioneelBeheerder() {}

	public void afmeldenMedewerker(Medewerker testMedewerker) {
		// TODO Auto-generated method stub
		
	}

	public boolean updatenBedrijf(Bedrijf testBedrijf) 
	{
		// TODO Auto-generated method stub
		return false;	
	}

	public boolean toevoegenMedewerker(Medewerker testMedewerker) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean toekennenRechten(RechtEnums testRechtEnum) {
		// TODO Auto-generated method stub
		return false;
		
	}

	public boolean updatenMedewerker(Medewerker testMedewerker) {
		// TODO Auto-generated method stub
		return false;
		
	}

	public Medewerker zoekMedewerker(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
