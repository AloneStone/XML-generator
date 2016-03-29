package Main;

/**
 * 
 * @author Bastien26
 *
 */
public class Driver {

	public Integer stressLevel;
	private int maxSpeed;
	private int brakingDistance;


	public Driver(int stressLevel, int maxS, int bd) {
		this.stressLevel = stressLevel;
		this.setMaxSpeed(maxS);
		this.setBrakingDistance(bd);
	}

	public String getStressLevel() {
		return stressLevel.toString();
	}

	public void moreStress() {
		this.stressLevel += 5;
	}

	public void lessStress() {
		this.stressLevel += 5;
	}

	public int getBrakingDistance() {
		return brakingDistance;
	}

	public void setBrakingDistance(int brakingDistance) {
		this.brakingDistance = brakingDistance;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
