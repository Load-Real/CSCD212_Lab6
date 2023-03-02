package cscd212tests.lab6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cscd212classes.lab6.*;

public class CSCD212Lab6CellTests {
	
	private LifeForm bob;
	private LifeForm fred;
	private Cell cell;
	
	@BeforeEach
	public void setup() throws Exception {
		bob = new LifeForm("Bob", 40);
		fred = new LifeForm("Fred", 40);
		cell = new Cell();
	}
	
	@Test
	void testInit() {
		assertNull(cell.getLifeForm());
	}
	
	@Test
	public void testAddLifeFormEmptyCell() {
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
	}
	
	@Test
	public void testAddLifeFormOccupiedCell() {
		cell.addLifeForm(bob);
		boolean success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}
	
	//Test when one cell is empty and one is full
	@Test
	public void testRemoveLifeFormBeforeAdding() {
		//If there is no LF, it should be null
		assertNull(cell.removeLifeForm());
	}
	
	@Test
	public void testRemoveLifeFormAfterAdding() {
		//Add bob to the Cell via addLifeForm
		cell.addLifeForm(bob);
		//Make sure the LifeForm just added is equal to bob
		assertEquals(bob, cell.removeLifeForm());
		//Make sure the LifeForm is removed
		assertNull(cell.getLifeForm());
	}
	
	@Test
	public void testGetLifeForm() {
		cell.addLifeForm(bob);
		assertEquals(cell.getLifeForm(), bob);
	}
	
	@Test
	public void testAddLifeFormReceivesNonNull() {
		cell.addLifeForm(bob);
		assertFalse(cell.addLifeForm(bob));
	}
	
	@Test
	public void testRemoveLifeFormReceivesNull() {
		LifeForm sadBob = null;
		cell.addLifeForm(sadBob);
		assertNull(cell.removeLifeForm());
	}
}
