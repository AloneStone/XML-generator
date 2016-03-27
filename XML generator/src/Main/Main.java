package Main;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.SwingUtilities;

import xmlGenerator.XmlGenerator;
import xmlGenerator.GUI.CollectionVehicules;
import xmlGenerator.GUI.GUIXmlGenerator;

/**
 * 
 * @author Bastien26
 *
 */




public class Main {

    

	public static void main(final String[] args) {
		
    	XmlGenerator xmlgenerator = new XmlGenerator();
		GUIXmlGenerator guiXmlGenerator = new GUIXmlGenerator(xmlgenerator);	
		xmlgenerator.GUIAssociation(guiXmlGenerator);
		SwingUtilities.invokeLater(guiXmlGenerator);

    	System.out.println("test");
    	
    	

    	
    }
}