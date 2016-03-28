package Main;

import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public class Car extends Vehicule{

	public final static int CAR_LENTH = 5;
	public final static int CAR_WIDTH = 5;
	
	public Car(int maxS, int bd, Node startNode, ArrayList<Node> route, Driver d ,int width){
		this.lenth = CAR_LENTH;
		this.maxSpeed = maxS;
		this.brakingDistance = bd;
		this.startNode = startNode;
		this.route = route;
		this.driver = d;
		this.width = CAR_WIDTH;
		
	}

	

	public Car() {
		this.lenth = CAR_LENTH;
		this.maxSpeed = 50;
		this.brakingDistance = 30;
	}

	@Override
	String getType() {
		
		return "Car";
	}
}
