import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * 
 * @author Bastien26
 *
 */
public class XML {
	
	//public Scenario scenario;
	
	public void toXML(Scenario s){
		
		
		  /*

	     * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"

	     */

	    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    try {

	        /*

	         * Etape 2 : création d'un parseur

	         */

	        final DocumentBuilder builder = factory.newDocumentBuilder();

	                

	        /*

	         * Etape 3 : création d'un Document

	         */

	        final Document document= builder.newDocument();

	                    

	        /*

	         * Etape 4 : création de l'Element racine

	         */

	        final Element racine = document.createElement("Vehicule");
	        document.appendChild(racine);           
	        /*
	         * Etape 5 : création d'une personne
	         */

	        Collection<Vehicule> vehicule = s.getVehicules();
	        int compteurId = 1;	
	        for (Vehicule v: vehicule){
		        
	        	
		        final Comment commentaire = document.createComment("Premier vehicule");
		        racine.appendChild(commentaire);
	
		        final Element vehi = document.createElement("Vehicule");
	
		        vehi.setAttribute("id", Integer.toString(compteurId));
		        racine.appendChild(vehi);
		        /*
	
		         * Etape 6 : création du nom et du prénom
	
		         */
	
		        final Element lenth = document.createElement("lenth");
		        lenth.appendChild(document.createTextNode(v.getLenth().toString()));
	
		        final Element maxSpeed = document.createElement("maxSpeed");
		        maxSpeed.appendChild(document.createTextNode(v.getMaxSpeed().toString()));
	
		        final Element brakingDistance = document.createElement("brakingDistance");
		        brakingDistance.appendChild(document.createTextNode(v.getBrakingDistance().toString()));   
	
		        final Element startingPositionX = document.createElement("startingPositionX");
		        startingPositionX.appendChild(document.createTextNode(v.getStartingPosition().getX().toString()));   
		        
		        final Element startingPositionY = document.createElement("startingPositionY");
		        startingPositionY.appendChild(document.createTextNode(v.getStartingPosition().getY().toString()));  
		        
		        final Element endingPositionX = document.createElement("endingPositionX");
		        endingPositionX.appendChild(document.createTextNode(v.getEndingPosition().getX().toString()));  
		        
		        final Element endingPositionY = document.createElement("endingPositionY");
		        endingPositionY.appendChild(document.createTextNode(v.getEndingPosition().getX().toString()));  
		        
		        final Element driver = document.createElement("driver");
		        driver.appendChild(document.createTextNode("driver"));  
		        
		        final Element width = document.createElement("width");
		        width.appendChild(document.createTextNode(v.getWidth().toString()));  
		        
		        vehi.appendChild(lenth);
		        vehi.appendChild(maxSpeed);           
		        vehi.appendChild(brakingDistance); 
		        vehi.appendChild(startingPositionX); 
		        vehi.appendChild(startingPositionY); 
		        vehi.appendChild(endingPositionX); 
		        vehi.appendChild(endingPositionY); 
		        vehi.appendChild(driver); 
		        vehi.appendChild(width); 
		        
		        compteurId++;
	        }                       

	        /*

	         * Etape 8 : affichage

	         */

	        final TransformerFactory transformerFactory = TransformerFactory.newInstance();

	        final Transformer transformer = transformerFactory.newTransformer();

	        final DOMSource source = new DOMSource(document);

	        final StreamResult sortie = new StreamResult(new File("file.xml"));

	        //final StreamResult result = new StreamResult(System.out);

	            

	        //prologue

	        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");

	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

	        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");            

	                

	        //formatage

	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

	            

	        //sortie

	        transformer.transform(source, sortie);  

	    }

	    catch (final ParserConfigurationException e) {

	        e.printStackTrace();

	    }

	    catch (TransformerConfigurationException e) {

	        e.printStackTrace();

	    }

	    catch (TransformerException e) {

	        e.printStackTrace();

	    }           

	    }

	}


