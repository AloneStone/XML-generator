package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.SwingUtilities;

import xmlGenerator.XmlGenerator;
import xmlGenerator.GUI.GUIXmlGenerator;

/**
 * 
 * @author Bastien26
 *
 */




public class Main {




	public static Node A = null;
	public static Node B = null;
	public static Node C = null;
	public static Node D = null;
	public static Node E = null;
	public static Node F = null;
	public static Node G = null;
	public static Node H = null;
	public static Node I = null;
	
	public static ArrayList<Vehicule> vehicules;
	public static ArrayList<Node> n;

	public static void main(final String[] args) {
		
		
		
			n = new ArrayList<Node>(); 
	     	A = new Node(1,new Position(25,25));
	       B = new Node(2,new Position(490,25));
	       C = new Node(3,new Position(940,25));
	      
	       D = new Node(4,new Position(25,260));
	       E = new Node(5,new Position(490,260));
	       F = new Node(6,new Position(940,260));
	      
	       G = new Node(7,new Position(25,500));
	       H = new Node(8,new Position(490,260));
	       I = new Node(9,new Position(940,260));
	      
	      n.add(A);
	      n.add(B);
	      n.add(C);
	      n.add(D);
	      n.add(E);
	      n.add(F);
	      n.add(G);
	      n.add(H);
	      n.add(I);
	      vehicules = new ArrayList<Vehicule>();
		Car test = new Car();
		vehicules.add(test);
		
    	XmlGenerator xmlgenerator = new XmlGenerator();
		GUIXmlGenerator guiXmlGenerator = new GUIXmlGenerator(xmlgenerator);	
		xmlgenerator.GUIAssociation(guiXmlGenerator);
		SwingUtilities.invokeLater(guiXmlGenerator);

    	System.out.println("lancement de l'application");
    	
    	

    	
    }
}