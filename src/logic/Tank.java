package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Tank 
{
	private int tanknummer, inhoudInLiters, bouwjaar, diameter, lengte, gpsBreedtegraad, gpsLengtegraad;
	private String naam, type;
	private double gewicht, dieselniveau, accuniveau, vermogenZonnepaneel;
	private EStatus STATUS;
	private boolean slotStatus, meldingTanken;
	private LocalTime openingstijd, sluitingstijd;
	
	private ArrayList<Medewerker> tankbeheerders;

	public Tank(int tanknummer, String naam, String type, int inhoudInLiters, int bouwjaar, int diameter, int lengte, double gewicht, EStatus STATUS, 
			LocalTime openingstijd, LocalTime sluitingstijd, int gpsBreedtegraad, int gpsLengtegraad, double dieselniveau, double accuniveau, double vermogenZonnepaneel, 
			boolean slotStatus, boolean meldingTanken)
	{
		this.tanknummer = tanknummer;
		this.naam = naam;
		this.type = type;
		this.inhoudInLiters = inhoudInLiters;
		this.bouwjaar = bouwjaar;
		this.diameter = diameter;
		this.lengte = lengte;
		this.gewicht = gewicht;
		this.STATUS = STATUS;
		this.openingstijd = openingstijd;
		this.sluitingstijd = sluitingstijd;
		this.gpsBreedtegraad = gpsBreedtegraad;
		this.gpsLengtegraad = gpsLengtegraad;
		this.dieselniveau = dieselniveau;
		this.accuniveau = accuniveau;
		this.vermogenZonnepaneel = vermogenZonnepaneel;
		this.slotStatus = slotStatus;
		this.meldingTanken = meldingTanken;		
	}

	public Tank(){}

	public static void main(String[] args) throws ParseException {
	    // user input: openingstijd --> nog exceptions erbij, moet nu met HH:mm:ss
		Scanner in = new Scanner(System.in);
	    System.out.println("Voer een openingstijd in: ");
	    String input = in.nextLine();
	    
		// time formatten
//		Date date = new Date();
	    String strDateFormat = "HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//	    System.out.println(sdf.format(date));  

//    	String input = "15:00:00";
	    Date ingesteldeOpeningstijd = sdf.parse(input);
	    System.out.print("De ingestelde openingstijd is: " + sdf.format(ingesteldeOpeningstijd));
	    
		/*
		String time = "15:35:42";
		LocalTime now = LocalTime.now();
				
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = sdf.parse(time);
	//	Date currentTime = sdf.parse(now);

		System.out.println("Time: " + sdf.format(date));
		System.out.println(sdf.format(now)); */
	}
	

	
	// getters en setters	
	public int getTanknummer() {
		return tanknummer;
	}

	public void setTanknummer(int tanknummer) {
		this.tanknummer = tanknummer;
	}

	public int getInhoudInLiters() {
		return inhoudInLiters;
	}

	public void setInhoudInLiters(int inhoudInLiters) {
		this.inhoudInLiters = inhoudInLiters;
	}

	public int getBouwjaar() {
		return bouwjaar;
	}

	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getLengte() {
		return lengte;
	}

	public void setLengte(int lengte) {
		this.lengte = lengte;
	}

	public int getGpsBreedtegraad() {
		return gpsBreedtegraad;
	}

	public void setGpsBreedtegraad(int gpsBreedtegraad) {
		this.gpsBreedtegraad = gpsBreedtegraad;
	}

	public int getGpsLengtegraad() {
		return gpsLengtegraad;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public double getDieselniveau() {
		return dieselniveau;
	}

	public void setDieselniveau(double dieselniveau) {
		this.dieselniveau = dieselniveau;
	}

	public double getAccuniveau() {
		return accuniveau;
	}

	public void setAccuniveau(double accuniveau) {
		this.accuniveau = accuniveau;
	}

	public double getVermogenZonnepaneel() {
		return vermogenZonnepaneel;
	}

	public void setVermogenZonnepaneel(double vermogenZonnepaneel) {
		this.vermogenZonnepaneel = vermogenZonnepaneel;
	}

	public EStatus getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(EStatus sTATUS) {
		STATUS = sTATUS;
	}

	public boolean isSlotStatus() {
		return slotStatus;
	}

	public void setSlotStatus(boolean slotStatus) {
		this.slotStatus = slotStatus;
	}

	public boolean isMeldingTanken() {
		return meldingTanken;
	}

	public void setMeldingTanken(boolean meldingTanken) {
		this.meldingTanken = meldingTanken;
	}

	public LocalTime getOpeningstijd() {
		return openingstijd;
	}

	public void setOpeningstijd(LocalTime openingstijd) {
		this.openingstijd = openingstijd;
	}

	public LocalTime getSluitingstijd() {
		return sluitingstijd;
	}

	public void setSluitingstijd(LocalTime sluitingstijd) {
		this.sluitingstijd = sluitingstijd;
	}
	
	// toString
	@Override
	public String toString() {
		return "Tank [tanknummer=" + tanknummer + ", inhoudInLiters=" + inhoudInLiters + ", bouwjaar=" + bouwjaar
				+ ", diameter=" + diameter + ", lengte=" + lengte + ", gpsBreedtegraad=" + gpsBreedtegraad
				+ ", gpsLengtegraad=" + gpsLengtegraad + ", naam=" + naam + ", type=" + type + ", gewicht=" + gewicht
				+ ", dieselniveau=" + dieselniveau + ", accuniveau=" + accuniveau + ", vermogenZonnepaneel="
				+ vermogenZonnepaneel + ", STATUS=" + STATUS + ", slotStatus=" + slotStatus + ", meldingTanken="
				+ meldingTanken + ", openingstijd=" + openingstijd + ", sluitingstijd=" + sluitingstijd
				+ ", tankbeheerders=" + tankbeheerders + "]";
	}
}
