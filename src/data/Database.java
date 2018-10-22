package data;

import java.sql.*;

import java.util.*;
import java.util.Date;

import logic.Adres;
import logic.Bedrijf;
import logic.ELand;
import logic.FunctioneelBeheerder;
import logic.Medewerker;
import logic.Tank;

public class Database {

	private Connection connect() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String user = "loriexplori"; //username
		String pwd = "wokkeltje"; //password
		String host = "jdbc:mysql://www.rickhendriks.com:3306/loriexplori"; //protocol + host url + port + database name
		Connection conn = DriverManager.getConnection(host, user, pwd);
		System.out.println("connected");
		return conn;
		}
		catch(SQLException sqlExc) {
            System.out.println(sqlExc.getMessage());
        }
		return null;
		
	}
	
	private void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	public List<String> getAlleBedrijven() throws SQLException {
		List<String> bedrijven = new ArrayList<String>();
		Connection conn = connect();
		String query = "Select bedrijfsnaam from Bedrijf";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String bedrijfsnaam = rs.getString("bedrijfsnaam");
			bedrijven.add(bedrijfsnaam);
		}
		close(conn);
		return bedrijven;
	}

	public List<String> getMedewerkersVanBedrijf(String bedrijfsnaam) throws SQLException {
		List<String> medewerkers = new ArrayList<String>();
		Connection conn = connect();
		String query = "Select Medewerker_Bedrijf.gebruikersnaam FROM Medewerker_Bedrijf JOIN Medewerker on Medewerker_Bedrijf.gebruikersnaam = Medewerker.gebruikersnaam Where Medewerker.statuscode = 1 AND Medewerker_Bedrijf.bedrijfsnaam = ?"; //statuscode om te controleren of medewerker nog wel actief is.
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String medewerker = rs.getString("gebruikersnaam");
			medewerkers.add(medewerker);
		}
		close(conn);
		return medewerkers;
		
	}
	
	public String getAdresBedrijf(String bedrijfsnaam) throws SQLException {
		Connection conn = connect();
		String query = "select CONCAT_WS(' ', Adres.straatnaam, Adres.huisnummer, Adres.huisnummertoevoeging) as adres from Adres_Bedrijf "
				+ "JOIN Adres on Adres_Bedrijf.adrescode = Adres.adrescode" + 
				"where Adres_Bedrijf.bedrijfsnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		String adres = rs.getString("adres");
		close(conn);
		return adres;
	}

	public List<Integer> getTanksVanBedrijf(String bedrijfsnaam) throws SQLException {
		List<Integer> tanks = new ArrayList<Integer>();
		Connection conn = connect();
		String query = "Select tanknummer FROM Tank Where bedrijfsnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,  bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int tanknummer = rs.getInt("tanknummer");
			tanks.add(tanknummer);
		}
		close(conn);
		return tanks;
		
	}
	
	public List<String> getFunctioneelBeheerdersVanBedrijf(String bedrijfsnaam) throws SQLException {
		List<String> functioneelBeheerders = new ArrayList<String>();
		Connection conn = connect();
		String query = "select Medewerker_Rechten.gebruikersnaam FROM Medewerker_Rechten JOIN Medewerker on Medewerker_Rechten.gebruikersnaam = Medewerker.gebruikersnaam JOIN Medewerker_Bedrijf ON Medewerker_Bedrijf.gebruikersnaam = Medewerker.gebruikersnaam WHERE Medewerker_Rechten.rechtencode = 8 AND Medewerker_Bedrijf.bedrijfsnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String gebruikersnaam = rs.getString("gebruikersnaam");
			functioneelBeheerders.add(gebruikersnaam);
		}
		close(conn);
		return functioneelBeheerders;
	}
	
	public Medewerker getMedewerkerObject(String gebruikersnaam) throws SQLException {
		Connection conn = connect();
		String query = "select * from Medewerker "
				+ "WHERE gebruikersnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, gebruikersnaam);
		ResultSet rs = ps.executeQuery();
		gebruikersnaam = rs.getString("gebruikersnaam");
		String voornaam = rs.getString("voornaam");
		String achternaam = rs.getString("achternaam");
		Date geboortedatum = rs.getDate("geboortedatum");
		String wachtwoord = rs.getString("wachtwoord");
		String email = rs.getString("email");
		String telefoonnummer = rs.getString("telefoonnummer");		
		Medewerker medewerker = new Medewerker(voornaam, achternaam, geboortedatum, gebruikersnaam, wachtwoord, email, telefoonnummer);
		close(conn);
		return medewerker;
	}
	
	public Adres getAdresObject(String bedrijfsnaam) throws SQLException {
		Connection conn = connect();
		String query = "select * from Adres"
				+ " JOIN Adres_Bedrijf on Adres.adrescode = Adres_Bedrijf.adrescode "
				+ "JOIN Land on Land.landcode = Adres.landcode "
				+ "WHERE Adres_Bedrijf.bedrijfsnaam = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		String straatnaam = rs.getString("straatnaam");
		int huisnummer = rs.getInt("huisnummer");
		String huisnummertoevoeging = rs.getString("huisnummertoevoeging");
		String postcode = rs.getString("postcode");
		String plaatsnaam = rs.getString("plaatsnaam");
		ELand land =  ELand.valueOf(rs.getString("land"));
		int adresID = rs.getInt("adrescode");
		Adres adres = new Adres(straatnaam, huisnummer, huisnummertoevoeging, postcode, plaatsnaam, land, adresID);
		return adres;
	}
	
	public Bedrijf getBedrijfObject(String bedrijfsnaam) throws SQLException {
		Connection conn = connect();
		String query = "select * from Bedrijf where bedrijfsnaam = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijfsnaam);
		ResultSet rs = ps.executeQuery();
		bedrijfsnaam = rs.getString("bedrijfsnaam");
		String telefoonnummer = rs.getString("telefoonnummer");
		String contactgebruikersnaam = rs.getString("contactpersoon");
		String rekeningnummer = rs.getString("rekeningnummer");
		String btwNummer = rs.getString("btwNummer");
		String vatNummer = rs.getString("vatNummer");
		String kvkNummer = rs.getString("kvkNummer");
		Medewerker contactpersoon = getMedewerkerObject(contactgebruikersnaam);
		Adres adres = getAdresObject(bedrijfsnaam);
		Bedrijf bedrijf = new Bedrijf(bedrijfsnaam, adres, telefoonnummer, contactpersoon, rekeningnummer, btwNummer, vatNummer, kvkNummer);
		close(conn);
		return bedrijf;
		
	}
		
	public void updateAdres(Adres adres) throws SQLException {
		Connection conn = connect();
		String query = "UPDATE Adres SET straatnaam = ?, huisnummer = ?, huisnummertoevoeging = ?, postcode = ?, plaatsnaam = ? WHERE adrescode = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, adres.getStraatnaam());
		ps.setInt(2, adres.getHuisnummer());
		ps.setString(3, adres.getHuisnummertoevoeging());
		ps.setString(4, adres.getPostcode());
		ps.setString(5, adres.getPlaatsnaam());
		ps.setString(6, adres.getPlaatsnaam());
		ps.setInt(7, adres.getAdresID());
		ps.executeQuery();
		conn.close();
	}
	
	public void updateMedewerker(Medewerker medewerker) throws SQLException {
		Connection conn = connect();
		String query = "UPDATE Medewerker SET voornaam = ?, achternaam = ?, geboortedatum = ?, wachtwoord = ?, email = ?, telefoonnummer = ?, statuscode = ?, landcode = ? WHERE gebruikersnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, medewerker.getVoornaam());
		ps.setString(2, medewerker.getAchternaam());
		ps.setDate(3, (java.sql.Date) medewerker.getGeboortedatum()); // moest hier casten voor het voorkomen van errors, niet zeker waarom -Rick
		ps.setString(4, medewerker.getWachtwoord());
		ps.setString(5, medewerker.getEmail());
		ps.setString(6, medewerker.getTelefoonnummer());
		ps.setInt(7, 1); //TODO Even kijken hoe de statuscode er in verwerkt moet worden
		ps.setInt(8, 31); //TODO moet nog kijken of t mogelijk is om landen aan medewerker toe te voegen.
		ps.setString(9, medewerker.getGebruikersnaam());
		
	}
	
	public void updateBedrijf(Bedrijf bedrijf) throws SQLException {
		Connection conn = connect();
		String query = "UPDATE Bedrijf SET bedrijfsnaam = ?, telefoonnummer = ?, rekeningnummer = ?, kvknummer = ?, statuscode = ?, vatnummer = ? btwnummer = ?, contactpersoon = ? WHERE bedrijfsnaam = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bedrijf.getBedrijfsnaam());
		ps.setString(2, bedrijf.getTelefoonnummer());
		ps.setString(3, bedrijf.getRekeningnummer());
		ps.setString(4, bedrijf.getKvkNummer());
		ps.setInt(5, 1); //TODO Even kijken hoe de statuscode er in verwerkt moet worden
		ps.setString(6, bedrijf.getVatNummer());
		ps.setString(7, bedrijf.getBtwNummer());
		ps.setString(8, bedrijf.getContactpersoon().getGebruikersnaam());
		ps.setString(9, bedrijf.getBedrijfsnaam());
		ps.executeQuery();
		conn.close();
	}



}
		
	