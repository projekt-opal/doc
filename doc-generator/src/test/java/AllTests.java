import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * All tests.
 * 
 * @see https://howtodoinjava.com/junit5/junit5-test-suites-examples/
 * @author Adrian Wilke
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({

		DeliverablesParserTest.class,

		GitHubRepositoriesTest.class

})

public class AllTests {
}