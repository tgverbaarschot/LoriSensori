package logic;

public class FunctioneelBeheerder extends Medewerker {

//Constructors 
	public FunctioneelBeheerder(String voornaam, String achternaam, String gebruikersnaam, String wachtwoord, String email, String telefoonnummer)
	{
		super(voornaam, achternaam, gebruikersnaam, wachtwoord, email, telefoonnummer);
	}

	public FunctioneelBeheerder(){}

	public void afmeldenMedewerker(Medewerker testMedewerker) {
		// TODO Auto-generated method stub
		
	}

    public boolean updatenBedrijf(Bedrijf bedrijf) {
		return true;
    }

	public boolean toevoegenMedewerker(Medewerker medewerker) {
		return true;
	}

    public void toekennenRechten(RechtEnums rechtEnums) {
    }

    public void updatenMedewerker(Medewerker medewerker) {
    }

    public Medewerker zoekMedewerker(String testNaam) {
	    return new Medewerker();
    }
}
