package mx.tec.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

@SpringBootTest
class UnderstandingAssertsApplicationTests {

	@Test
	public void whenAssertingEquality_thenEqual() {
		String expected = "Winter is coming";
		String actual = "Not today";
		
		//assertEquals(expected, actual);
		assertEquals(expected, actual, "failure - strings are not equal");
	}
	
	
	@Test
	public void whenAssertingArraysEquality_thenEqual() {
		char[] expected = {'J', 'u', 'n', 'i', 't'};
		char[] actual = "Junit".toCharArray();
		
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void givenNullArrays_whenAssertingArraysEquality_thenEqual() {
		int [] expected = null;
		int [] actual = null;
		
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void whenAssertingNull_thenTrue() {
		Object longclaw = null;
		
		assertNull(longclaw, "The longclaw should be null");
		
		//if we want to assert that an object should not be null we can use the 
		//assertNotNull assertion
		
	}
	
	
	//Reductio ad absurdum: If some Object is Not Null, it is not Null so it means that
	//when asserting null then false is correct.
	@Test
	public void whenAssertingNull_thenFalse() {
		Object longclaw = "I am not null";
		
		assertNotNull(longclaw, "The longclaw should be not null");	
		
	}
	
	
	@Test
	public void whenAssertingNotSameObject_thenDifferent() {
		Object oathkeeper = new Object();
		Object windowswall = new Object();
		
		assertNotSame(oathkeeper, windowswall);
		
		//when we want to verify that two variables refer to the same object, we can
		//use the assertSame assertion
	}
	
	
	@Test
	public void whenAssertingSameObject_thenSame() {
		Object oathkeeper = "Hello";
		Object windowswall = "Hello";
		
		assertSame(oathkeeper, windowswall);
	}
	
	
	@Test
	public void whenAssertingConditions_thenVerified() {
		assertTrue(5 > 4, "5 is greater than 4");
		assertFalse(5 > 6, "5 is not greater than 6");
	}
	
	
	@Test
	public void whenCheckingExceptionMessage_thenEqual() {
		AnyClass ac = new AnyClass();
		
		try {
			ac.methodThatShouldThrowException();
			fail("Exception not thrown");
		}
		catch(UnsupportedOperationException e) {
			assertEquals("Operation Not Supported", e.getMessage());
		}
	}
	
	
	@Test
	public void testAssertsThatHasItems() {
		assertThat(Arrays.asList("Harrenhal", "Dragonstone", "Winterfell")).contains("Winterfell");
	}

}
