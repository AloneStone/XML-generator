package Main;
import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Scenario {
	

	public Environement environement;
	public Collection<Vehicule> vehicules;
	
	public Scenario(Collection<Vehicule> v, Environement e){
		this.vehicules = v;
		this.environement = e;
	}
	
	public Environement getEnvironement() {
		return environement;
	}

	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}

}
