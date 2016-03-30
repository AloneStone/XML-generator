package xmlGenerator;


public class VehiculeRepresentation extends Object {

	/**
	 * The type of shape
	 */
	private TypeVehicule type;

	private String path;
	
	private Position position;

	/**
	 * The constructor of the shape
	 * 
	 * @param x
	 *            the coordinate on the X axe
	 * @param y
	 *            the coordinate on the Y axe
	 * @param point
	 *            point
	 */
	public VehiculeRepresentation(int x, int y, TypeVehicule type) {
		
		this.position = new Position(x, y);
		this.type = type;
		
		if (type == TypeVehicule.CAR)
			this.path = "/xmlGenerator/GUI/car.png";
		if (type == TypeVehicule.MOTO)
			this.path = "/xmlGenerator/GUI/moto.png";
		if (type == TypeVehicule.TRUCK)
			this.path = "/xmlGenerator/GUI/truck.png";
	}

	/**
	 * Gets the type of the shape
	 * 
	 * @return type type
	 */
	public TypeVehicule getType() {
		return this.type;
	}

	/**
	 * Sets a new type to the shape
	 * 
	 * @param type
	 *            type
	 */
	public void setType(TypeVehicule type) {
		this.type = type;
	}

	public String getPath(){
		return this.path;
	}
	/**
	 * gets the abscissa position of the object
	 * 
	 * @return getObjectPosition().getPosX()
	 */
	public int getPosX() {
		return this.position.getPosX();
	}

	/**
	 * gets the ordinate position of the object
	 * 
	 * @return getObjectPosition().getPosY()
	 */
	public int getPosY() {
		return this.position.getPosY();
	}
}
