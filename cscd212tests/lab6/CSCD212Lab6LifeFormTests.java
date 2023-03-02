package cscd212tests.lab6;

//tells the compiler where to find the definition of specific JUnit classes that we need.
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cscd212classes.lab6.LifeForm;

public class CSCD212Lab6LifeFormTests
{
	private LifeForm entity;
	
	@BeforeEach
	public void setup() throws Exception {
		entity = new LifeForm("Bob", 40);
	}
	
	
	@Test
	public void testInit() {
		LifeForm entity;
		entity = new LifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
	}
	
	
	@Test
	public void testGetName()
	{
		assertEquals("Bob", entity.getName());
	}

	@Test
	public void testGetCurrentLifePoints()
	{
		assertEquals(40, entity.getCurrentLifePoints());
	}
	
	@Test
	public void testNameIsNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new LifeForm(null, 40);
		});
	}
	
	@Test
	public void testNameIsEmpty() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new LifeForm("", 40);
		});
	}
	
	@Test
	public void testCurrentLifePointsLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new LifeForm("Bob", -5);
		});
	}
	
	@Test
	public void testCurrentLifePointsEqualToZero() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new LifeForm("Bob", 0);
		});
	}
}