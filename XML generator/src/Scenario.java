import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Scenario {
	

	public Environement environement;
	public Collection<Vehicule> vehicules;
	
	public Scenario(Collection<Vehicule> v){
		this.vehicules = v;
	}
	
	public Environement getEnvironement() {
		return environement;
	}

	public Collection<Vehicule> getVehicules() {
		return vehicules;
	}

}
