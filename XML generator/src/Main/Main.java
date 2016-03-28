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


	public static ArrayList<Vehicule> vehicules;

	public static void main(final String[] args) {
		ArrayList<Vehicule> vehicules = new ArrayList<Vehicule>();
		Car test = new Car();
		vehicules.add(test);
		
    	XmlGenerator xmlgenerator = new XmlGenerator();
		GUIXmlGenerator guiXmlGenerator = new GUIXmlGenerator(xmlgenerator);	
		xmlgenerator.GUIAssociation(guiXmlGenerator);
		SwingUtilities.invokeLater(guiXmlGenerator);

    	System.out.println("lancement de l'application");
    	
    	

    	
    }
}