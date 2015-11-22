package jtest;

import application.*;

import org.mockito.Mockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBikesMocking {
		
		private RoadBike spyRoadBike;
		private final static String licenceTag = "WE12345XX";
		private final static int wheelSize = 26;
		
		@Before
		public void setup() {	
			
			spyRoadBike = Mockito.spy(new RoadBike(wheelSize));
			spyRoadBike.setLicenceTag(licenceTag);
		}
		
		@Test
		public void testGetLicenceTagRoadBike() {
			Mockito.when(spyRoadBike.getLicenceTagRoadBike()).thenReturn(licenceTag.toLowerCase());
			assertEquals(licenceTag,spyRoadBike.getLicenceTagRoadBike());
		}
			
	
}