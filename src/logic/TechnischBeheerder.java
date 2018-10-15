package logic;

public class TechnischBeheerder extends FunctioneelBeheerder
{
	public TechnischBeheerder(String voornaam, String achternaam, String gebruikersnaam, String wachtwoord, String email, String telefoonnummer) 
	{
		super(voornaam, achternaam, gebruikersnaam, wachtwoord, email, telefoonnummer);
	}

	public TechnischBeheerder(){}

    public boolean aanmakenBedrijf(Bedrijf testBedrijf) {
		return true;
    }

	public boolean afmeldenBedrijf(Bedrijf testBedrijf) {
		return true;
	}

	public Bedrijf zoekBedrijf(String testBedrijf) {
		return new Bedrijf();
	}
}
