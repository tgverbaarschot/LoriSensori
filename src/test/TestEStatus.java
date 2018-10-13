/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.EStatus;

class TestEStatus {
	
	@Test
	void testEStatus_Succeed() 
	{
		EStatus status = EStatus.ACTIEF;
		System.out.println("Status is: " + status);
		assertEquals(EStatus.valueOf("ACTIEF"), status);
	}
	
	@Test
	void testEStatus_False() 
	{
		EStatus status = EStatus.NONACTIEF;
		System.out.println("Status is: " + status);
		assertNotEquals(EStatus.valueOf("ACTIEF"), status);
	}
}
