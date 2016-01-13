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
    	
    	Scenario s = new Scenario(vehicule);
    	
    	XML xml = new XML();
    	xml.toXML(s);
    	
    	System.out.println("Fichier créé !");
    }
}