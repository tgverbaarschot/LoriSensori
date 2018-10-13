package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.ELand;
import logic.EStatus;

class TestELand {

	@Test
	void testELand_Succeed() 
	{
		ELand status = ELand.NEDERLAND;
		System.out.println("Status is: " + status);
		assertEquals(ELand.valueOf("NEDERLAND"), status);
	}
	
	@Test
	void testELand_False() 
	{
		ELand status = ELand.BELGIE;
		System.out.println("Status is: " + status);
		assertNotEquals(ELand.valueOf("NEDERLAND"), status);
	}

}
