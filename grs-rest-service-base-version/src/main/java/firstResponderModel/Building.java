/*package firstResponderModel;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Building extends GeographicLocation{
	
	@Id
	@Column (name = "buildingID")
	private Long buildingID;
	
	
	public ConstructionType constructionType;

	@Column (name = "buildingAge")
	public int buildingAge;

	@Column (name = "numberOfFloors")
	public int numberOfFloors;

	@ElementCollection
	@CollectionTable(name = "buildingEntryLocation")
	public List<String> buildingEntryLocation = new ArrayList<String>();

	
	
	//getters and setters
	
	public ConstructionType getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(ConstructionType constructionType) {
		this.constructionType = constructionType;
	}

	public int getBuildingAge() {
		return buildingAge;
	}

	public void setBuildingAge(int buildingAge) {
		this.buildingAge = buildingAge;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Long getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(Long buildingID) {
		this.buildingID = buildingID;
	}

	public List<String> getBuildingEntryLocation() {
		return buildingEntryLocation;
	}

	public void setBuildingEntryLocation(List<String> buildingEntryLocation) {
		this.buildingEntryLocation = buildingEntryLocation;
	}


}

*/