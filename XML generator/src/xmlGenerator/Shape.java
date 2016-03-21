package xmlGenerator;
import java.awt.Color;


public class Shape extends Object
{
	/**
	 * the color of the shape
	 */
	private Color color;
	
	/**
	 * The type of shape
	 */
	private Type type;
	
	/**
	 * The constructor of the shape
	 * @param x the coordinate on the X axe
	 * @param y the coordinate on the Y axe
	 * @param point point
	 */
	public Shape(int x, int y, Pointer point)
	{
		super(new Position(x, y), point.getSize());
		
		
		this.type = point.getType();
	}
	

	
	/**
	 * Gets the type of the shape
	 * @return type type
	 */
	public Type getType() 
	{
		return this.type;
	}
	
	/**
	 * Sets a new type to the shape
	 * @param type type
	 */
	public void setType(Type type) 
	{
		this.type = type;
	}
	
	/**
	 * gets the abscissa position of the object
	 * @return getObjectPosition().getPosX()
	 */
	public int getPosX()
	{
		return this.getObjectPosition().getPosX();
	}
	
	/**
	 * gets the ordinate position of the object
	 * @return getObjectPosition().getPosY()
	 */
	public int getPosY()
	{
		return this.getObjectPosition().getPosY();
	}
	/**
	 * Gets the size of the object
	 * @return getObjectDimension()
	 */
	public int getSize()
	{
		return this.getObjectDimension();
	}
}
