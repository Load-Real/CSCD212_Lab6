package cscd212tests.lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cscd212classes.lab6.LifeForm;
import cscd212classes.lab6.Cell;

import cscd212classes.lab6.*;

class CSCD212Lab6EnvironmentTests {

	private LifeForm bob;
	private Cell[][] cells;
	private Environment envObj;
	
	@BeforeEach
	void setUp() throws Exception {
		bob = new LifeForm("Bob", 40);
		cells = new Cell[2][3];
		envObj = new Environment(cells);
	}

	/*@Test
	void testInit() {
	}*/
	
	@Test
	void testCreateEnvironmentOneCell() {
		//Checks if addLifeForm properly adds bob to cells[1][0]
		assertTrue(cells[1][0].addLifeForm(bob));
		//Checks if the LF just put into cells[1][0] is equivalent to bob
		assertEquals(bob, envObj.getLifeForm(1, 0));
	}
	
	@Test
	void testAddLifeForm() {
		LifeForm fred = null;
		
		assertFalse(envObj.addLifeForm(0, 1, fred));
		
		assertTrue(envObj.addLifeForm(0, 0, bob));
		assertEquals(envObj.getLifeForm(0, 0), bob);
	}
	
	@Test
	void testRemoveLifeForm() {
		//Add the bob LF to [0][0] of our new array
		envObj.addLifeForm(0, 0, bob);
		//Check if the LF removed matches that of bob (which we just added)
		assertEquals(envObj.removeLifeForm(0, 0), bob);
		//Check if the LF was actually deleted
		assertNull(envObj.getLifeForm(0, 0));
		//Check if removeLifeForm returns null appropriately
		assertNull(envObj.removeLifeForm(0, 0));
	}
	
	@Test
	void testGetLifeFormByAddingObject() {
		envObj.addLifeForm(0, 0, bob);
		assertEquals(envObj.getLifeForm(0, 0), bob);
	}
	
	@Test
	void testGetLifeFormWhenALifeFormIsFillingTheCells() {
		LifeForm jimmy = new LifeForm("Jimmy", 40);
		
		envObj.addLifeForm(1, 2, bob);
		assertEquals(envObj.getLifeForm(1, 2), bob);
		envObj.removeLifeForm(1, 2);
		envObj.addLifeForm(1, 2, jimmy);
		assertEquals(envObj.getLifeForm(1, 2), jimmy);
	}
	
	@Test
	void testEnvironmentWhenCellsAreNull() {
		assertThrows(NullPointerException.class, ()-> {
			new Environment(null);
		});
	}
	
	@Test
	void testAddLifeFormWhenRowsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.addLifeForm(-1, 0, bob));
	}
	
	@Test
	void testAddLifeFormWhenColsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.addLifeForm(0, -1, bob));
	}
	@Test
	void testAddLifeFormWhenEntityIsNull() {
		assertFalse(envObj.addLifeForm(0, 0, null));
	}
	
	@Test
	void testGetLifeFormWhenRowsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.getLifeForm(-1, 0));
	}
	
	@Test
	void testGetLifeFormWhenColsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.getLifeForm(0, -1));
	}
	
	@Test
	void testRemoveLifeFormWhenRowsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.removeLifeForm(-1, 0));
	}
	
	@Test
	void testRemoveLifeFormWhenColsAreNegative() {
		assertThrows(IllegalArgumentException.class, ()-> 
			envObj.removeLifeForm(0, -1));
	}
	
	@Test 
	void testAddLifeFormThrowsRightMessage() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> 
			envObj.addLifeForm(-1, 0, bob));
		assertEquals("Bad Params in addLifeForm", exception.getMessage());
	}
	
	@Test 
	void testGetLifeFormThrowsRightMessage() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> 
			envObj.getLifeForm(-1, 0));
		assertEquals("Bad Params in getLifeForm", exception.getMessage());
	}
	
	@Test 
	void testRemoveLifeFormThrowsRightMessage() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> 
			envObj.removeLifeForm(-1, 0));
		assertEquals("Bad Params in removeLifeForm", exception.getMessage());
	}
	
	@Test 
	void testGetLifeFormWhenCellsIsNull() {
		cells[0][0] = null;
		assertNull(envObj.getLifeForm(0, 0));
	}
	
	@Test 
	void testRemoveLifeFormWhenCellsIsNull() {
		cells[0][0] = null;
		assertNull(envObj.removeLifeForm(0, 0));
	}
	
	@Test
	void testAddLifeFormOutOfBoundsProperMessage() {
		Throwable exception = assertThrows(ArrayIndexOutOfBoundsException.class, ()-> 
			envObj.addLifeForm(5, 0, bob));
		assertEquals("Row and Col Params OutOfBounds", exception.getMessage());
	}
}