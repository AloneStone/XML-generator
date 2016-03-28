package Main;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Bastien26
 *
 */
public class Environement {
	
	public String picture;
	public Collection<Signaling> signaling;
	public ArrayList<Node> node;
	public ArrayList<Arc> arc;	
	
	
	
	public Environement(String picture, Collection<Signaling> signaling,ArrayList<Node> n,ArrayList<Arc> a) {

		this.picture = picture;
		this.signaling = signaling;
		
		 Node n1 = new Node(1,new Position(25,25));
         Node n2 = new Node(2,new Position(490,25));
         Node n3 = new Node(3,new Position(940,25));
         
         Node n4 = new Node(4,new Position(25,260));
         Node n5 = new Node(5,new Position(490,260));
         Node n6 = new Node(6,new Position(940,260));
         
         Node n7 = new Node(7,new Position(25,500));
         Node n8 = new Node(8,new Position(490,260));
         Node n9 = new Node(9,new Position(940,260));
         
         n.add(n1);
         n.add(n2);
         n.add(n3);
         n.add(n4);
         n.add(n5);
         n.add(n6);
         n.add(n7);
         n.add(n8);
         n.add(n9);
         

         a.add(new Arc(1, n1, n2, 50));
         a.add(new Arc(2, n2, n3, 50));
         
         a.add(new Arc(3, n1, n4, 50));
         a.add(new Arc(4, n2, n5, 50));
         a.add(new Arc(5, n3, n6, 50));
         
         
         a.add(new Arc(6, n4, n5, 50));
         a.add(new Arc(7, n5, n6, 50));
         
         a.add(new Arc(8, n4, n7, 50));
         a.add(new Arc(9, n5, n8, 50));
         a.add(new Arc(10, n6, n7, 50));

         a.add(new Arc(11, n7, n8, 50));
         a.add(new Arc(12, n8, n9, 50));
	}
	
	
	public String getPicture() {
		return picture;
	}
	public Collection<Signaling> getSignaling() {
		return signaling;
	}
	

	

}
