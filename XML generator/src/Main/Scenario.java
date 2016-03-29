package Main;
import java.util.ArrayList;

/**
 * 
 * @author Bastien26
 *
 */
public class Scenario {
	

	public Environement environement;
	public ArrayList<Vehicule> vehicules;
	
	public Scenario(ArrayList<Vehicule> v, Environement e){
		this.vehicules = v;
		this.environement = e;
	}
	
	public Environement getEnvironement() {
		return environement;
	}

	public ArrayList<Vehicule> getVehicules() {
		return vehicules;
	}

}
