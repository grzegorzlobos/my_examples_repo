package jtest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import application.*;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class TestApplicationUnderTest2 {

	ApplicationUnderTest appUnderTest;

	@Before
	public void setup() throws Exception {
		appUnderTest = new ApplicationUnderTest();
	}

	@After
	public void clean() throws Exception {
		appUnderTest = null;
	}
	
	
    @Test
    @FileParameters("src/jtest/inputdata.csv")
	public void testAdd(int a,int b,int result) {
		assertEquals("Not equal",result,appUnderTest.add(a,b));		
	}
}
