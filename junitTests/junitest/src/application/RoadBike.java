package application;

public class RoadBike extends Bike {
	
	public int wheelSize;
	public RoadBike(int wheelSize){
		this.wheelSize = wheelSize;
	}
	
	@Override
	public void setLicenceTag(String slicenceTag){
		super.setLicenceTag(slicenceTag);
	}
	
	public String getLicenceTagRoadBike() {
	    return this.licenceTag;
	}
}