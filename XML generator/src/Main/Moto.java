package Main;

import java.util.ArrayList;

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
	 * @param startNode
	 * @param route
	 */
	public Moto(int maxS, int bd, Driver d, int width,
			ArrayList<Node> route) {

		this.lenth = TRUCK_LENTH;
		this.maxSpeed = maxS;
		this.brakingDistance = bd;
		this.route = route;
		this.driver = d;
		this.width = TRUCK_LENTH;
	}

	@Override
	String getType() {

		return "Moto";
	}

}
