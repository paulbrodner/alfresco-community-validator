package ro.paulbrodner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import ro.paulbrodner.alfresco.community.SmokeTest;

/**
 * @author paul.brodner
 *
 */
public class Runner {
	/**
	 * {@link http://testng.org/doc/documentation-main.html#running-testng-programmatically}
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Start Running SmokeTests");

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { SmokeTest.class });
		testng.addListener(tla);
		testng.run();
	}
}
