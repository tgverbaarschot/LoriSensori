/**
 * In deze unit test wordt de methode ... uit klasse Tank getest
 * https://stackoverflow.com/questions/21354311/junit-test-of-setters-and-getters-of-instance-variables
 * https://www.baeldung.com/junit-5-extensions
 * https://howtodoinjava.com/junit-5-tutorial/
 * https://blog.codefx.org/libraries/junit-5-basics/
 * https://www.eclipse.org/community/eclipse_newsletter/2017/october/article5.php
 * https://dzone.com/articles/setters-method-handles-and-java-11 --> getters setters
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import logic.Tank;

class TestTank {
	static Tank testTank;
			
				/**
				 * gebruiken voor database comm!
				 * @throws java.lang.Exception
				 */
				@BeforeAll
				static void setUpBeforeAll() throws Exception 
				{
					System.out.println("Before all test methods");
				}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeEach() throws Exception 
	{
		testTank = new Tank(0, null, null, 0, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, 0, false, false); // moeten hier niet alle variabelen van de tank in? "Id" "Naam" etc
		System.out.println("Before each test methods: testtank aangemaakt");
	}

	@Test
	@DisplayName("Test set openingstijden_returnTrue") 
	void testSetOpeningstijden() throws NoSuchFieldException, IllegalAccessException
	{
		// when
		//testTank.setOpeningstijd(12:00:00); // niet goed
		
		// then
		Field field = testTank.getClass().getDeclaredField("Openingstijd");
		field.setAccessible(true);
		Assertions.assertEquals("12.00", field.get(testTank), "12.00, test succeeded");
		System.out.println("Set openingstijden");
	}
	
	@Test
	@DisplayName("Test get openingstijden_returnTrue")
	void testGetOpeningstijden() throws NoSuchFieldException, IllegalAccessException
	{
		// given
		Field field = testTank.getClass().getDeclaredField("Openingstijd");
		field.setAccessible(true);
		field.set(testTank, "12.00");
		
		// when
		LocalTime result = testTank.getOpeningstijd();
		
		// then
		Assertions.assertEquals("12.00", result, "12.00, test succeeded");
		System.out.println("Second test method");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception 
	{
		System.out.println("After each test method");
	}
					
					/**
					 * Database comm
					 * @throws java.lang.Exception
					 */
					@AfterAll
					static void tearDownAfterClass() throws Exception 
					{
						System.out.println("After all test methods");
					}
}
