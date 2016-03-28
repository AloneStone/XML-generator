package xmlGenerator.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Car;
import Main.Driver;
import Main.Node;
import Main.Position;
import Main.Vehicule;



public class Display extends JFrame implements ActionListener {
        
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] behaviors;
	public  String selected;
	public int stresslevel = 50;
	
	public String nodeDepart;
	public String trajet;
	
	
	
	
	
	//private JComboBox jComboBox;
		public Display(){
			
			this.behaviors = new String[] { "normal", "Enervé", "trés Enervé" };
                this.setTitle("XML Generator");
                this.setSize(300, 500);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);      
               
                this.setVisible(true);                
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Rentrez le noeud de départ :");
                panel.add(label);
                JTextArea text1 = new JTextArea("", 2, 10);
                panel.add(text1); 

                
            JLabel label2 = new JLabel("Rentrez le trajet :");
            panel.add(label2);
            JTextArea text2 = new JTextArea("", 2, 10);

            panel.add(text2);
  
            JLabel label3 = new JLabel("Rentrez le comportement du véhicule :");
            label3.setLocation(50, 50);
            panel.add(label3);
            // ca je comprend pas
            JComboBox<String> behaviorList = new JComboBox<>(behaviors);
            behaviorList.addActionListener(new ActionListener() {
            	 public void actionPerformed(ActionEvent e) {
            		 selected = (String)behaviorList.getSelectedItem();
    			}
    		});
            behaviorList.setSelectedIndex(0);
            panel.add(behaviorList);
            
            JLabel label4 = new JLabel("Niveau de stress du conducteur");
            label4.setLocation(100, 50);
            panel.add(label4);
            JSlider jSlider = new JSlider(0, 100, 50);
    		jSlider.setPaintLabels(true);
    		jSlider.setMajorTickSpacing(10);
    		jSlider.setMinorTickSpacing(5);
    		jSlider.setPaintTicks(true);
    		jSlider.setValue(50);
    		jSlider.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					
					stresslevel = jSlider.getValue();

					
				}
    		});
    		
           
            panel.add(jSlider);
            JButton okButton =  new JButton("Valider");
            okButton.addActionListener(this);
            panel.add(okButton);
            this.add(panel);
            
            JButton fermer =  new JButton("Fermer");
            fermer.addActionListener(
            		new ActionListener() {

        				@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
            		});
            panel.add(fermer);
            this.add(panel);
            
          
                                
        }

        public String getText(JTextArea text){
                String userText = text.getText();
                return userText;
        }
        
    	@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.print(selected);
			System.out.print("/");
			System.out.print(stresslevel);
			
			ArrayList<Node> n = new ArrayList<Node>(); 
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
               
               //System.out.println(this.nodeDepart);
               //System.out.println(this.trajet);
			if (selected == "normal" ){
				  Car v1 = new Car(50, 30, new Node(1,new Position(25,25)),n, new Driver(stresslevel) ,5);
				  Main.Main.vehicules.add(v1);
	              //System.out.print("normal");
				}
			if (selected == "Enervé" ){
				   Car v2 = new Car(100, 30, new Node(1,new Position(25,25)),n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v2);
		            
			}
			
			if (selected == "trés Enervé" ){
				   Car v3 = new Car(150, 30, new Node(1,new Position(25,25)),n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v3);
		             
			}
			dispose();
        
    	}
}

	