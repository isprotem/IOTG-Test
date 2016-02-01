package firstResponderModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Mine {
	
	@Id
	@Column (name = "mineID")
	private Long mineID;
	
	@Column (name = "mineDepth")
	private int mineDepth;
	
	@Column (name = "mineDepthUnits")
	private String mineDepthUnits;
	
	@Column (name = "mineNumberOfLevels")
	private int mineNumberOfLevels;
	
	/*@Column (name = "mineType")
	private MineType mineType;*/
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "geographicLocation_ID")
	private GeographicLocation isLocatedAt;

	

	//getters and setters
	
	
	public Long getMineID() {
		return mineID;
	}

	public void setMineID(Long mineID) {
		this.mineID = mineID;
	}

	public int getMineDepth() {
		return mineDepth;
	}

	public void setMineDepth(int mineDepth) {
		this.mineDepth = mineDepth;
	}

	public String getMineDepthUnits() {
		return mineDepthUnits;
	}

	public void setMineDepthUnits(String mineDepthUnits) {
		this.mineDepthUnits = mineDepthUnits;
	}

	public int getMineNumberOfLevels() {
		return mineNumberOfLevels;
	}

	public void setMineNumberOfLevels(int mineNumberOfLevels) {
		this.mineNumberOfLevels = mineNumberOfLevels;
	}
/*
	public MineType getMineType() {
		return mineType;
	}

	public void setMineType(MineType mineType) {
		this.mineType = mineType;
	}*/

	public GeographicLocation getIsLocatedAt() {
		return isLocatedAt;
	}

	public void setIsLocatedAt(GeographicLocation isLocatedAt) {
		this.isLocatedAt = isLocatedAt;
	}
	
	

}
