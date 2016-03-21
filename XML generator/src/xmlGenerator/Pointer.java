package xmlGenerator;
import java.awt.Color;


public class Pointer
{
	
	/**
	 * the pointer's type
	 */
	private Type type;
	
	/**
	 * The pointer's size
	 */
	private int size;
	
	/**
	 * Initializes the default pointer
	 * The default pointer is black, is a circle and measures 100px
	 */
	public Pointer()
	{
		
		this.type = Type.CAR;
		this.size = 100;
	}
	
	/**
	 * Initializes the pointer with a given color, type and size
	 * @param col the given color
	 * @param shap the given type
	 * @param siz the given size
	 */
	public Pointer(Color col, Type shap, int siz)
	{
		
		this.type = shap;
		this.size = siz;
	}
	

	
	/**
	 * Sets the pointer's type with a given TypeShape
	 * @param shape shape
	 */
	public void setShape(Type shape)
	{
		this.type = shape;
	}
	
	/**
	 * Sets the pointer's size with a given size
	 * @param size size
	 */
	public void setSize(int size)
	{
		this.size = size;
	}
	

	
	/**
	 * Returns the pointer's type
	 * @return type the pointer's type
	 */
	public Type getType()
	{
		return type;
	}
	
	/**
	 * Returns the pointer's size
	 * @return size the pointer's size
	 */
	public int getSize()
	{
		return size;
	}
	
}

