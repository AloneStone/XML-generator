package Main;

import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public abstract class Vehicule {
	
	public Integer lenth;
	public Integer maxSpeed;
	public Integer brakingDistance;
	public Node startNode;
	//public Node endNode;
	public ArrayList<Node> route;
	public Driver driver;
	public Integer width;
	//public Object getStartNode;
	
	
	
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
	public Node getStartNode(){
		return startNode;
	}
	

	public void setStartingNode(Node startNode) {
		this.startNode = startNode;
	}
	public  ArrayList<Node> getRoute() {
		return route;
	}
	public void setRoute(ArrayList<Node> route) {
		this.route = route;
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
