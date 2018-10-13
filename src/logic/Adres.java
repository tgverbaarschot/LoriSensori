// https://stackoverflow.com/questions/18643216/address-class-being-called-from-bank-class

package logic;

public class Adres 
{
	private String straatnaam, huisnummertoevoeging, postcode, plaatsnaam;
	private int adresID, huisnummer;
	private ELand LAND;
	Bedrijf bedrijf;
	
	public Adres(int AdresID, String straatnaam, int huisnummer, String huisnummertoevoeging, String postcode, String plaatsnaam, ELand LAND, int adresID)
	{
		this.adresID =adresID;
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.huisnummertoevoeging = huisnummertoevoeging;
		this.postcode = postcode;
		this.plaatsnaam = plaatsnaam;
		this.LAND = LAND;
	}

	Adres eenAdres = new Adres(adresID, huisnummertoevoeging, adresID, huisnummertoevoeging, huisnummertoevoeging, huisnummertoevoeging, LAND, adresID);
	
// getters en setters
	public int getAdresID() {
		return adresID;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public String getHuisnummertoevoeging() {
		return huisnummertoevoeging;
	}

	public void setHuisnummertoevoeging(String huisnummertoevoeging) {
		this.huisnummertoevoeging = huisnummertoevoeging;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaatsnaam() {
		return plaatsnaam;
	}

	public void setPlaatsnaam(String plaatsnaam) {
		this.plaatsnaam = plaatsnaam;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public ELand getLAND() {
		return LAND;
	}

	public void setLAND(ELand lAND) {
		LAND = lAND;
	}
}
