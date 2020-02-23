package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OtherClassTest {

	@Test
	public void testMultiply() {
		OtherClass oc = new OtherClass();
		
		assertEquals(oc.multiply(50, 10), 50*10);
	}
	
	@Test
	public void testMultiply_ExceptionIsThrown() {
		OtherClass oc = new OtherClass();
		
		try {
			oc.multiply(1000, 1000);
			fail("Exception not thrown");
		}
		catch(IllegalArgumentException e) {
			assertEquals("X should be less than 1000", e.getMessage());
		}
	}

}
