package task01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	private Schedule schedule;
	private Movie filmOne;
	private Movie filmTwo;
	private Seance seanceOne;
	private Seance seanceTwo;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() {
		schedule = new Schedule();
		filmOne = new Movie("A", new Time(1, 20));
		filmTwo = new Movie("B", new Time(1, 40));
		seanceOne = new Seance(filmOne, new Time(7, 20));
		seanceTwo = new Seance(filmTwo, new Time(15, 0));

	}

	@After
	public void afterTest() {
		schedule = null;
		filmOne = null;
		filmTwo = null;
		seanceOne = null;
		seanceTwo = null;

	}

	@Test
	public void addSeanceTest() {
		boolean addSeance = schedule.addSeance(seanceOne);
		Assert.assertTrue(addSeance);
	}

	@Test
	public void removeSeanceTrueTest() {
		schedule.addSeance(seanceOne);
		boolean removeSeance = schedule.removeSeance(seanceOne);
		Assert.assertTrue(removeSeance);
	}

	@Test
	public void removeSeanceFalseTest() {
		schedule.addSeance(seanceOne);
		boolean removeSeance = schedule.removeSeance(seanceTwo);
		Assert.assertFalse(removeSeance);
	}

}