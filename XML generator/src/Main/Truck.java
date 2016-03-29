package Main;

import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public class Truck extends Vehicule {

	public final static int TRUCK_LENTH = 10;
	public final static int TRUCK_WIDTH = 6;

	public Truck(int maxS, int bd, ArrayList<Node> route,
			Driver d, int width) {
		this.lenth = TRUCK_LENTH;
		this.maxSpeed = maxS;
		this.brakingDistance = bd;
		this.route = route;
		this.driver = d;
		this.width = TRUCK_LENTH;
	}

	@Override
	String getType() {
		return "Truck";
	}
}
