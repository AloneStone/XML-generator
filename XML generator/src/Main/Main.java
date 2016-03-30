package Main;

import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import xmlGenerator.XmlGenerator;
import xmlGenerator.GUI.GUIXmlGenerator;

/**
 * 
 * @author Bastien26
 *
 */

public class Main {

	public static Node A;
	public static Node B;
	public static Node C;
	public static Node D;
	public static Node E;
	public static Node F;
	public static Node G;
	public static Node H;
	public static Node I;

	public static ArrayList<Vehicule> vehicules;
	public static ArrayList<Node> node;
	public static ArrayList<Arc> arcs;
	public static File image;

	public static void main(final String[] args) {

		vehicules = new ArrayList<Vehicule>();
		node = new ArrayList<Node>();
		arcs = new ArrayList<Arc>();
		mapCreationTest();

		XmlGenerator xmlgenerator = new XmlGenerator();
		GUIXmlGenerator guiXmlGenerator = new GUIXmlGenerator();
		xmlgenerator.GUIAssociation(guiXmlGenerator);
		SwingUtilities.invokeLater(guiXmlGenerator);

		System.out.println("lancement de l'application");

	}
	
	public static void done() {

		Environement environement = new Environement(image, node, arcs);
		Scenario scenar = new Scenario(vehicules, environement);
		XML.toXML(scenar);
	}
	
	public static void mapCreationTest(){

		node.add(A = new Node(0, new Position(25, 25)));
		node.add(B = new Node(1, new Position(490, 25)));
		node.add(C = new Node(2, new Position(940, 25)));
		node.add(D = new Node(3, new Position(25, 260)));
		node.add(E = new Node(4, new Position(490, 260)));
		node.add(F = new Node(5, new Position(940, 260)));
		node.add(G = new Node(6, new Position(25, 500)));
		node.add(H = new Node(7, new Position(490, 500)));
		node.add(I = new Node(8, new Position(940, 500)));

		arcs.add(new Arc(1, Node.getNodeNumber(1), Node.getNodeNumber(2), 500));
		arcs.add(new Arc(2, Node.getNodeNumber(2), Node.getNodeNumber(3), 500));
		arcs.add(new Arc(3, Node.getNodeNumber(1), Node.getNodeNumber(4), 500));
		arcs.add(new Arc(4, Node.getNodeNumber(2), Node.getNodeNumber(5), 500));
		arcs.add(new Arc(5, Node.getNodeNumber(3), Node.getNodeNumber(6), 500));
		arcs.add(new Arc(6, Node.getNodeNumber(4), Node.getNodeNumber(5), 500));
		arcs.add(new Arc(7, Node.getNodeNumber(5), Node.getNodeNumber(6), 500));
		arcs.add(new Arc(8, Node.getNodeNumber(4), Node.getNodeNumber(7), 500));
		arcs.add(new Arc(9, Node.getNodeNumber(5), Node.getNodeNumber(8), 500));
		arcs.add(new Arc(10, Node.getNodeNumber(6), Node.getNodeNumber(7), 500));
		arcs.add(new Arc(11, Node.getNodeNumber(7), Node.getNodeNumber(8), 500));
		arcs.add(new Arc(12, Node.getNodeNumber(8), Node.getNodeNumber(9), 500));
	}
}