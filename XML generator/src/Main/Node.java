package Main;

public class Node {
	public int id;
	public Position position;  

	public Node(int i, Position position) {
		this.position = position;
		this.id = i;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


}
