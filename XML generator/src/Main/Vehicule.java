package Main;

import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public abstract class Vehicule {

	public Integer lenth;
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



	public ArrayList<Node> getRoute() {
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
	public String toString() {
		return  "Taille : "+ width
				+ " Nombre de noeud à parcourir : " + route.size()
				+ " Driver's stress" + driver.getStressLevel();
	}
}
