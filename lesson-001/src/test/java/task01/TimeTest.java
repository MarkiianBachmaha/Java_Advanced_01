package task01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {
	private static Time time;
	private static Time plusTime1;;
	private static Time sumTime1;

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

		time = new Time(15, 25);
		plusTime1 = new Time(1, 25);
		sumTime1 = new Time(16, 50);
	}

	@AfterClass
	public static void afterTest() {
		time = null;
		plusTime1 = null;
		sumTime1 = null;
	}

	@Test
	public void plusTimeTest() {
		Time sumTime = time.plusTime(time, plusTime1);
		System.out.println("result " + sumTime.toString());
		System.out.println("expected " + sumTime1.toString());
		Assert.assertEquals(sumTime1, sumTime);
	}

}