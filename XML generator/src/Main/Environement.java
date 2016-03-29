package Main;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Environement {
	
	public File picture;
	public Collection<Signaling> signaling;
	public ArrayList<Node> node;
	public ArrayList<Arc> arc;	
	
	
	
	public Environement(File picture, Collection<Signaling> signaling, ArrayList<Node> n, ArrayList<Arc> a) {

		this.picture = picture;
		this.signaling = signaling;
	}
	
	public Environement(File picture, ArrayList<Node> n, ArrayList<Arc> a) {

		this.picture = picture;
		this.node = n;
		this.arc = a;
	}
	
	
	
	public File getPicture() {
		return picture;
	}
	public Collection<Signaling> getSignaling() {
		return signaling;
	}
	
	@Override
	public String toString(){
		
		return "Image : "+picture.getAbsolutePath()+"Nombre de noeud : "+node.size()+"Nombre d'arcs : "+arc.size();
	}
	

	

}
