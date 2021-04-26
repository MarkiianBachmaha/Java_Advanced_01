package task01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	private static Cinema cinema;
	private static Movie filmOne;
	private static Movie filmTwo;
	private static Seance seanceOne;
	private static Seance falseSeance;
	private static Time timeOne;
	private static Time timeTwo;
	private static String dayOne;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};

	@BeforeClass
	public static void beforeTest() {
		cinema = new Cinema(Time.timeFromString("7:00"), Time.timeFromString("23:00"));
		filmOne = new Movie("Film1", new Time(1, 55));
		filmTwo = new Movie("Film2", new Time(1, 40));
		seanceOne = new Seance(filmOne, new Time(9, 20));
		falseSeance = new Seance(filmTwo, new Time(3, 0));
		timeOne = Time.timeFromString("14:00");
		timeTwo = Time.timeFromString("16:00");
		dayOne = "MONDAY";

	}

	@AfterClass
	public static void afterTest() {
		cinema = null;
		filmOne = null;
		filmTwo = null;
		seanceOne = null;
		falseSeance = null;
		timeOne = null;
		timeTwo = null;
		dayOne = null;

	}

	@Test
	public void checkSeanceBoundsShouldBeFalse() {
		boolean isTrue = cinema.checkSeance(falseSeance);
		Assert.assertFalse(isTrue);
	}

	@Test
	public void addMovieShouldBeTrue() {
		boolean isTrue = cinema.addMovie(filmOne, timeOne, timeTwo);
		Assert.assertTrue(isTrue);
	}

	@Test
	public void removeMovieShouldBeTrue() {
		boolean isTrue = cinema.removeMovie(filmOne);
		Assert.assertTrue(isTrue);
	}

	@Test
	public void removeMovieShouldBeFalse() {
		cinema.getMoviesLibrary().add(filmOne);
		System.out.println(cinema.getMoviesLibrary().toString());
		boolean isFalse = cinema.removeMovie(filmTwo);
		Assert.assertFalse(isFalse);
	}

	@Test
	public void removeSeanceByDayShouldBeTrue() {
		cinema.addSeance(seanceOne, dayOne);
		boolean isTrue = cinema.removeSeanceByDay(seanceOne, dayOne);
		Assert.assertTrue(isTrue);
	}

	@Test
	public void removeAllSeancesByMovieBeTrue() {
		cinema.addSeance(seanceOne, dayOne);
		boolean isTrue = cinema.removeAllSeancesByMovie("Film1");
		Assert.assertTrue(isTrue);
	}

}
