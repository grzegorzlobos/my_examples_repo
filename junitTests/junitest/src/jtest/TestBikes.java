package jtest;

import application.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBikes{
	
	RoadBike roadBike;
	Bike bike;
	String licenceTag;
	int wheelSize;
	
	
	@Before
	public void setup() throws Exception{
		licenceTag = "WE12345XX";
		wheelSize = 26;		
	}
	

	@Test
	public void tesTgetLicenceTagBike(){
		Bike bike = new Bike();
		bike.setLicenceTag(licenceTag);
		assertEquals("Not equal",licenceTag,bike.getLicenceTagBike());
	}
	
	@Test
	public void tesTgetLicenceTagRoadBike(){
		RoadBike roadBike = new RoadBike(wheelSize);
		roadBike.setLicenceTag(licenceTag.toLowerCase());
		assertEquals("Not equal",licenceTag.toLowerCase(),roadBike.getLicenceTagRoadBike());
	}
	
	@Test
	public void tesTwheelSize(){
		RoadBike roadBike = new RoadBike(wheelSize);
		assertEquals("Not equal",wheelSize,roadBike.wheelSize);
	}
	
}