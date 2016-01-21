/**
 * 
 * @author Bastien26
 *
 */
public class Moto extends Vehicule {

	public final static int TRUCK_LENTH = 10;
	public final static int TRUCK_WIDTH = 6;
	
	/**
	 * 
	 * @param maxS
	 * @param bd
	 * @param sPosition
	 * @param ePosition
	 * @param d
	 * @param width
	 */
	public Moto(int maxS, int bd,Position sPosition, Position ePosition , Driver d ,int width){
		
		this.lenth = TRUCK_LENTH;
		this.maxSpeed = maxS;
		this.brakingDistance = bd;
		this.startingPosition = sPosition;
		this.endingPosition = ePosition;
		this.driver = d;
		this.width = TRUCK_LENTH;
	}

	@Override
	String getType() {
		
		return "Moto";
	}
	
	
	
}
