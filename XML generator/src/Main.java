import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Bastien26
 *
 */
public class Main {

    public static void main(final String[] args) {
    	
    	Car v = new Car(100, 10,new Position(90,90),new Position(100,100)  , new Driver(),10);
    	Moto m1 = new Moto(645, 12,new Position(50,50),new Position(60,60)  , new Driver(),6);
    	Collection<Vehicule> vehicule = new ArrayList<Vehicule>();
    	vehicule.add(v);
    	vehicule.add(m1);
    	
    	Collection<Integer> idSignalingPosible1 = new ArrayList<Integer>();
    	idSignalingPosible1.add(2);
    	idSignalingPosible1.add(3);
    	
    	Collection<Integer> idSignalingPosible2 = new ArrayList<Integer>();
    	idSignalingPosible2.add(1);
    	idSignalingPosible2.add(3);
    	
    	Collection<Integer> idSignalingPosible3 = new ArrayList<Integer>();
    	idSignalingPosible3.add(1);
    	idSignalingPosible3.add(2);
    	
    	Collection<Signaling> signaling = new ArrayList<Signaling>();

    	signaling.add(new TrafficLight(1, new Position(1,1),idSignalingPosible1 ,10,5));
    	signaling.add(new Sign(1, new Position(10,2),idSignalingPosible2 ));
    	signaling.add(new Crossroad(1, new Position(16,5),idSignalingPosible3 ));
    	
    	
		Environement e = new Environement("./img/picture.png",signaling);
    	
    	Scenario s = new Scenario(vehicule,e);
    	
    	XML xml = new XML();
    	xml.toXML(s);
    	
    	System.out.println("Fichier créé !");
    }
}