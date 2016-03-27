package xmlGenerator.GUI;

import java.util.ArrayList;
import java.util.Collection;

import Main.Car;
import Main.Vehicule;

public class CollectionVehicules {

		
		public  ArrayList<Vehicule> vehi1 = new ArrayList<Vehicule>();
		private ArrayList<Vehicule> vehi;

		
		public CollectionVehicules(){
			this.vehi = vehi1;
		}
		

		public void add(Car car) {
			this.getVehi().add(car);
			
		}

		public Collection<Vehicule> getVehi() {
			return vehi;
		}

}
