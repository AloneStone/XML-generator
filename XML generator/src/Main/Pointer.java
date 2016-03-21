package Main;
import xmlGenerator.Type;



public class Pointer {
	
	private Type type;
	
	
	public Pointer()
	{
		
		this.type = Type.CAR;
		
	}
	
	public Pointer(Type veh, int siz)
	{
		
		this.type = veh;
		
	}
	public void setShape(Type veh)
	{
		this.type = veh;
	}
	
	public Type getType()
	{
		return type;
	}

}
