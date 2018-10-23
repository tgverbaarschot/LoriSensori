package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.EBericht;
import logic.Email;
import logic.Medewerker;
import logic.Tank;

class TestEmail {

	@Test
	void email_stuurBericht_GeenEmailBekend_shouldReturnFalse() {
		@SuppressWarnings("unused")
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", null, null);
		EBericht testBericht = EBericht.TANKEN;
		Tank testTank = new Tank(10, "testtank", null, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, false, false);
//		medewerker moet nog in tankbeheerders gezet worden, momenteel nog niet mogelijk.
		Email testemail = new Email();
		assertFalse(testemail.stuurBericht(testTank, testBericht));
	}
	
	@Test
	void email_stuurBericht_EmailBekend_shouldReturnTrue() {
		@SuppressWarnings("unused")
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", "aap@staartjes.nu", null);
		EBericht testBericht = EBericht.TANKEN;
		Tank testTank = new Tank(10, "testtank", null, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, false, false);
//		medewerker moet nog in tankbeheerders gezet worden, momenteel nog niet mogelijk.
		Email testemail = new Email();
		assertTrue(testemail.stuurBericht(testTank, testBericht));
	}
	
	@Test
	void email_MedewerkerGeupdate_GeenEmailBekend_shouldReturnFalse() {
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", null, null);
		Email testemail = new Email();
		assertFalse(testemail.medewerkerGeupdate(testMedewerker));
	}

	@Test
	void email_MedewerkerGeupdate_EmailBekend_shouldReturnTrue() {
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", "aap@staartjes.nu", null);
		Email testemail = new Email();
		assertTrue(testemail.medewerkerGeupdate(testMedewerker));
	}

}
