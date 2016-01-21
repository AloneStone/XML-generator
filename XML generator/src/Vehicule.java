/**
 * 
 * @author Bastien26
 *
 */
public abstract class Vehicule {
	
	public Integer lenth;
	public Integer maxSpeed;
	public Integer brakingDistance;
	public Position startingPosition;
	public Position endingPosition;
	public Driver driver;
	public Integer width;
	
	
	
	abstract String getType();
	
	
	
	public Integer getLenth() {
		return lenth;
	}
	public void setLenth(Integer lenth) {
		this.lenth = lenth;
	}
	public Integer getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public Integer getBrakingDistance() {
		return brakingDistance;
	}
	public void setBrakingDistance(Integer brakingDistance) {
		this.brakingDistance = brakingDistance;
	}
	public Position getStartingPosition() {
		return startingPosition;
	}
	public void setStartingPosition(Position startingPosition) {
		this.startingPosition = startingPosition;
	}
	public Position getEndingPosition() {
		return endingPosition;
	}
	public void setEndingPosition(Position endingPosition) {
		this.endingPosition = endingPosition;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}

}
