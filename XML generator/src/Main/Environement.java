package Main;
import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Environement {
	
	public String picture;
	public Collection<Signaling> signaling;
	
	
	
	public Environement(String picture, Collection<Signaling> signaling) {

		this.picture = picture;
		this.signaling = signaling;
	}
	
	
	public String getPicture() {
		return picture;
	}
	public Collection<Signaling> getSignaling() {
		return signaling;
	}
	

	

}
