package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Adres;
import logic.Bedrijf;

class TestBedrijf {

	static Bedrijf tester;
	static Adres testadres;
	
	@BeforeEach
	void setUpBeforeEach() throws Exception 
	{
        testadres = new Adres(100, "teststraat", 1, null, "1234AB", "teststad", null, 0);
    	tester = new Bedrijf("test", testadres, "0612345678", "henk", "NL66INGB0123456789", null, null, null); // Bedrijf is tested
	}

    @Test
    public void bedrijf_loginverificiatie_onbekendegebruiker_ShouldReturnFalse() {

        // assert statements
        String username = "Henk";
        String password = "test";
        assertFalse(tester.loginverificatie(username, password), "gebruikersnaam onbekend");
    }

    @Test
    public void bedrijf_loginverificiatie_verkeerdwachtwoord_ShouldReturnFalse() {

        // assert statements
        String username = "Tester";
        String password = "henk";
        assertFalse(tester.loginverificatie(username, password), "verkeerd wachtwoord");
    }

    @Test
    public void bedrijf_loginverificiatie_kleineletter_ShouldReturnFalse() {

        // assert statements
        String username = "Tester";
        String password = "!test00";
        assertFalse(tester.loginverificatie(username, password), "kleine letter t ipv grote letter");
    }

    @Test
    public void bedrijf_loginverificiatie_juistegegevens_ShouldReturnTrue() {
    	//assert statements
    	String username = "Tester";
    	String password = "!Test00";
    	assertTrue(tester.loginverificatie(username,password), "juiste gebruikersnaam wachtwoord combinatie");
    }
}
