package Main;

import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public class Car extends Vehicule {

	public final static int CAR_LENTH = 5;
	public final static int CAR_WIDTH = 5;

	public Car(ArrayList<Node> route, Driver d) {
	
	
		this.route = route;
		this.driver = d;
		this.width = CAR_WIDTH;
		this.lenth = CAR_LENTH;
	}

	

	@Override
	String getType() {

		return "Car";
	}
}
