package sortable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortableArrayTest {
	
	private SortableArray fixture = null;
	private SortableArray fixture1 = null;
	@Before
	public void setUp() throws Exception { 
		int [] tablica = {1, 2,3, 4, 5, 0};
		fixture = new SortableArray(SortableArray.SIZE,SortableArray.RANGE);
		fixture1 = new SortableArray(tablica);
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
		fixture1 = null;
	}

	@Test
	public void isSortedTest() {
		fixture.CountSort();
		assertTrue(fixture.IsSorted());
	
	}
	
	@Test
	public void inputParamsTest() {
		assertTrue(fixture.getSize()== 10);
		assertTrue(fixture.getRange()== 4);
	}
	@Test
	public void isSortedTest1(){
		assertTrue(fixture1.IsSorted());
	}

}
