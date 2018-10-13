package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.EBericht;
import logic.Email;
import logic.Medewerker;
import logic.SMS;
import logic.Tank;

class TestSMS {


	@Test
	void sms_stuurBericht_GeenTelefoonnummerBekend_shouldReturnFalse() {
		@SuppressWarnings("unused")
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", null, null);
		EBericht testBericht = EBericht.SLOTOPEN;
		Tank testTank = new Tank(10, "testtank", null, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, false, false);
//		medewerker moet nog in tankbeheerders gezet worden, momenteel nog niet mogelijk.
		SMS testSms = new SMS();
		assertFalse(testSms.stuurBericht(testTank, testBericht));
	}
	
	@Test
	void sms_stuurBericht_TelefoonnummerBekend_shouldReturnTrue() {
		
		@SuppressWarnings("unused")
		Medewerker testMedewerker = new Medewerker("Henk", "De Tester", "Tester", "!Test00", null, "0612345678");
		EBericht testBericht = EBericht.SLOTOPEN;
		Tank testTank = new Tank(10, "testtank", null, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, false, false);
//		medewerker moet nog in tankbeheerders gezet worden, momenteel nog niet mogelijk.
		SMS testSms = new SMS();
		assertTrue(testSms.stuurBericht(testTank, testBericht));
	}
}
