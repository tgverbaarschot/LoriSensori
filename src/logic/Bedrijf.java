// driver
// http://www.ntu.edu.sg/home/ehchua/programming/java/j3b_oopinheritancepolymorphism.html
package logic;

public class Bedrijf 
{
	private String bedrijfsnaam, telefoonnummer, rekeningnummer, btwNummer, vatNummer, kvkNummer;
	private Adres adres;
	private Medewerker contactpersoon;
	// bedrijfstatus
  
	public Bedrijf(String bedrijfsnaam, Adres adres, String telefoonnummer, Medewerker contactpersoon, String rekeningnummer, String btwNummer, String vatNummer, String kvkNummer)

	{
		this.bedrijfsnaam = bedrijfsnaam;
		this.adres = adres; 
		this.telefoonnummer = telefoonnummer;
		this.contactpersoon = contactpersoon;
		this.rekeningnummer = rekeningnummer;
		this.btwNummer = btwNummer;
		this.vatNummer = vatNummer;
		this.kvkNummer = kvkNummer;
	}
	
	public Bedrijf() {}

	public void setAdres(String straatnaam, int huisnummer, String huisnummertoevoeging, String postcode, String plaatsnaam, ELand lAND) {
//		this.adres = adres;
		adres.setStraatnaam(straatnaam);
		adres.setHuisnummer(huisnummer);
		adres.setHuisnummertoevoeging(huisnummertoevoeging);
		adres.setPostcode(postcode);
		adres.setPlaatsnaam(plaatsnaam);
		adres.setLAND(lAND);
	}
	
// getters en setters
	public String getBedrijfsnaam() {
		return bedrijfsnaam;
	}

	public void setBedrijfsnaam(String bedrijfsnaam) {
		this.bedrijfsnaam = bedrijfsnaam;
	}
	
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	public Medewerker getContactpersoon() {
		return contactpersoon;
	}

	public void setContactpersoon(Medewerker contactpersoon) {
		this.contactpersoon = contactpersoon;
	}

	public String getRekeningnummer() {
		return rekeningnummer;
	}

	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}

	public String getBtwNummer() {
		return btwNummer;
	}

	public void setBtwNummer(String btwNummer) {
		this.btwNummer = btwNummer;
	}

	public String getVatNummer() {
		return vatNummer;
	}

	public void setVatNummer(String vatNummer) {
		this.vatNummer = vatNummer;
	}

	public String getKvkNummer() {
		return kvkNummer;
	}

	public void setKvkNummer(String kvkNummer) {
		this.kvkNummer = kvkNummer;
	}

	public String toString() {
	      return bedrijfsnaam + "(" + adres + ")";
	}


	public boolean loginverificatie(String username, String password) {
		// TODO Auto-generated method stub
		if (username == "Tester" && password == "!Test00") {
				return true;
		}
		return false;
		
	}
}
