package jtest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      TestApplicationUnderTest.class,
      TestApplicationUnderTest2.class,
      TestBikes.class
        	})

public class TestSuite {
}