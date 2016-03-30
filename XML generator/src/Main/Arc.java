package Main;

import java.util.ArrayList;

public class Arc {

	private int id;
	private Node nodestart;
	private Node nodefinish;
	private int distance;

	public Arc(int id, Node nodestart, Node nodefinish, int distance) {

		this.id = id;
		this.nodestart = nodestart;
		this.nodefinish = nodefinish;
		this.distance = distance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getNodestart() {
		return nodestart;
	}

	public void setNoDestart(Node nodestart) {
		this.nodestart = nodestart;
	}

	public Node getNodefinish() {
		return nodefinish;
	}

	public void setNodefinish(Node nodefinish) {
		this.nodefinish = nodefinish;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}