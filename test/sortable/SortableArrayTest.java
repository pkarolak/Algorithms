package sortable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortableArrayTest {
	
	private SortableArray fixture = null;
	@Before
	public void setUp() throws Exception {
		fixture = new SortableArray(SortableArray.SIZE,SortableArray.RANGE);
	}

	@After
	public void tearDown() throws Exception {
		fixture = null;
	}

	@Test
	public void isSortedTest() {
		fixture.CountSort();
		assertTrue(fixture.IsSorted());
	}

}
