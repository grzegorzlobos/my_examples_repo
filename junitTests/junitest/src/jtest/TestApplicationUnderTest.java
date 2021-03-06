package jtest;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import application.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;



@RunWith(Parameterized.class)
public class TestApplicationUnderTest {

	ApplicationUnderTest appUnderTest;
	private int input_a;
	private int input_b;
	private int result;
	
	public TestApplicationUnderTest(int input_a,int input_b, int result ){
		this.input_a = input_a;
		this.input_b = input_b;
		this.result = result;
	}
	
	@Before
	public void setup() throws Exception {
		appUnderTest = new ApplicationUnderTest();
	}

	@After
	public void clean() throws Exception {
		appUnderTest = null;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
	      return Arrays.asList(new Object[][] {
	         { 1,1,2},
	         { 1,2,3},
	         { 2,3,4},
	         { 4,5,9},
	         { 3,3,6}
	      });
	   }
	
	@Test
	public void testAdd() {
		assertEquals("Not equal",result,appUnderTest.add(input_a,input_b));		
	}
}
