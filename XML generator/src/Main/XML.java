package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author Bastien26
 *
 */
public class XML {

	// public Scenario scenario;

	public static void toXML(Scenario s) {

		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */

		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {

			/*
			 * Etape 2 : création d'un parseur
			 */

			final DocumentBuilder builder = factory.newDocumentBuilder();
			/*
			 * Etape 3 : création d'un Document
			 */

			final Document document = builder.newDocument();
			/*
			 * Etape 4 : création de l'Element racine
			 */

			ArrayList<Vehicule> vehicule = s.getVehicules();

			Environement e = s.getEnvironement();
			Collection<Signaling> signaling = e.getSignaling();
			/**
			 * Partie Véhicule
			 */

			final Element racine = document.createElement("Scenario");
			document.appendChild(racine);
			/*
			 * Etape 5 : création d'une personne
			 */
			int compteurId = 1;
			for (Vehicule v : vehicule) {

				final Element vehi = document.createElement("Vehicule");

				vehi.setAttribute("id", Integer.toString(compteurId));
				vehi.setAttribute("type", v.getType());
				racine.appendChild(vehi);

				final Element lenth = document.createElement("lenth");
				lenth.appendChild(document.createTextNode(v.getLenth()
						.toString()));

				final Element maxSpeed = document.createElement("maxSpeed");
				maxSpeed.appendChild(document.createTextNode(Integer.toString(v.getDriver().getMaxSpeed())));
				
				

				final Element route = document.createElement("route");
				System.out.println(s.environement.node.size());
				for (Node node : v.route) {
					final Element noeud = document.createElement("noeud");
					noeud.setAttribute("id", Integer.toString(node.getId()));
					route.appendChild(noeud);
				}
				
				

				final Element driver = document
						.createElement("driver");
				final Element brakingDistance = document
										.createElement("reactionTime");
								brakingDistance.appendChild(document.createTextNode(Integer.toString(v
										.getDriver().getBrakingDistance())));
				final Element stressLevel = document.createElement("stressLevel");
				stressLevel.appendChild(document.createTextNode(v.getDriver().getStressLevel()));
				
							
				final Element width = document.createElement("width");
				width.appendChild(document.createTextNode(v.getWidth()
						.toString()));

				vehi.appendChild(lenth);
				vehi.appendChild(maxSpeed);
				vehi.appendChild(route);
				vehi.appendChild(driver);
				driver.appendChild(brakingDistance);
				driver.appendChild(stressLevel);
				vehi.appendChild(width);

				compteurId++;
			}

			/**
			 * Partie environement
			 */

			final Element pic = document.createElement("Picture");
			racine.appendChild(pic);

			final Element picture = document.createElement("file");
			if (s.environement.picture != null){
				picture.appendChild(document.createTextNode(s.environement.picture
						.getAbsolutePath()));
				pic.appendChild(picture);
			}

			if (s.environement.signaling != null) {
				for (Signaling si : signaling) {

					final Element signa = document.createElement(si.getType());
					racine.appendChild(signa);

					final Element id = document.createElement("id");
					id.appendChild(document.createTextNode(si.getId()
							.toString()));
					signa.appendChild(id);

					final Element positionX = document
							.createElement("positionX");
					positionX.appendChild(document.createTextNode(si
							.getPosition().getX().toString()));
					signa.appendChild(positionX);

					final Element positionY = document
							.createElement("positionY");
					positionY.appendChild(document.createTextNode(si
							.getPosition().getY().toString()));
					signa.appendChild(positionY);

					final Element idSignalingPosible = document
							.createElement("idSignalingPosible");
					idSignalingPosible.appendChild(document.createTextNode(si
							.getIdSignalingPosible().toString()));
					signa.appendChild(idSignalingPosible);

					if (si.getType() == "TrafficLight") {

						final Element redDuration = document
								.createElement("redDuration");
						redDuration.appendChild(document.createTextNode(si
								.getRedDuration().toString()));
						signa.appendChild(redDuration);

						final Element greenDuration = document
								.createElement("greenDuration");
						greenDuration.appendChild(document.createTextNode(si
								.getGreenDuration().toString()));
						signa.appendChild(greenDuration);

					}

				}
			}
			/*
			 * affichage
			 */

			final TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			final Transformer transformer = transformerFactory.newTransformer();

			final DOMSource source = new DOMSource(document);

			final StreamResult sortie = new StreamResult(new File("file.xml"));

			// final StreamResult result = new StreamResult(System.out);

			// prologue

			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

			// formatage

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			// sortie

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
