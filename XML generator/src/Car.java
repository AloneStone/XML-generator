/**
 * 
 * @author Bastien26
 *
 */
public class Car extends Vehicule{

	public final static int CAR_LENTH = 5;
	public final static int CAR_WIDTH = 5;
	
	public Car(int maxS, int bd,Position sPosition, Position ePosition , Driver d ,int width){
		this.lenth = CAR_LENTH;
		this.maxSpeed = maxS;
		this.brakingDistance = bd;
		this.startingPosition = sPosition;
		this.endingPosition = ePosition;
		this.driver = d;
		this.width = CAR_WIDTH;
		
	}
}
