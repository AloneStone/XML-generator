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

	public Truck(ArrayList<Node> route,
			Driver d) {
		this.lenth = TRUCK_LENTH;
		this.route = route;
		this.driver = d;
		this.width = TRUCK_LENTH;
	}

	@Override
	String getType() {
		return "Truck";
	}
}
