package Main;

public class Node {
	public int id;
	public Position position;

	public Node(int i, Position position) {
		this.position = position;
		this.id = i;
	}
	
	public static Node getNodeNumber(int id) {

		for (Node node : Main.node) {
			if (node.getId() == id)
				return node;
		}
		return null;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + id;
	}
	
	@Override
	public boolean equals(Object obj) {
			if (this.hashCode() == obj.hashCode())
				return true;
			return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id*position.X*position.Y;
	}

}
