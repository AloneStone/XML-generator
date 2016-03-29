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
	public ArrayList<Node> route;
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
	
	@Override
	public String toString(){
		return "MaxSpeed : "+maxSpeed+" Taille : "+width+" Braking Distance : "+brakingDistance+" Noeud de départ : "+startNode+" Nombre de noeud à parcourir : "+route.size()+" Driver's stress"+ driver.getStressLevel();
	}
}
