package xmlGenerator.GUI;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Car;
import Main.Driver;
import Main.Node;
import Main.Position;
/**
 * 
 * @author Maxime, Antoine
 *
 */

public class Popup extends JFrame implements ActionListener {
        

	private static final long serialVersionUID = 1L;
	private String[] behaviors;
	public  String selected;
	public int stresslevel = 50;
	
	public String nodeDepart;
	public String trajet;
	public JSplitPane splitPane1 ,splitPane2,splitPane3;
	public JPanel panel1, panel2;
	 public String nodeStart;
	 public String nodes;
	 
	 public JTextArea text1;
	 public JTextArea text2;
	
	
	
		public Popup(){
			
			this.behaviors = new String[] { "normal", "Enervé", "trés Enervé" };
                this.setTitle("XML Generator");
                this.setSize(300, 500);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                Panel panel1 = new Panel();
                Panel panel2 = new Panel();
         
                this.setVisible(true); 
              
       
                splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,panel2 );
                splitPane1.setResizeWeight(0.2);
                splitPane1.setOneTouchExpandable(false);
                splitPane1.setDividerLocation(0.5);
                
              
                
                JLabel label = new JLabel("Rentrez le noeud de départ :");
                JLabel label2 = new JLabel("Rentrez le trajet :");
                JLabel label3 = new JLabel("Rentrez le comportement du véhicule :");
                label3.setLocation(50, 50);
                JComboBox<String> behaviorList = new JComboBox<>(behaviors);
                behaviorList.addActionListener(new ActionListener() {
                	 public void actionPerformed(ActionEvent e) {
                		 selected = (String)behaviorList.getSelectedItem();
        			}
        		});
                behaviorList.setSelectedIndex(0);
                JTextArea text1 = new JTextArea("", 2, 10);
                JTextArea text2 = new JTextArea("", 2, 10);
                JLabel label4 = new JLabel("Niveau de stress du conducteur :");
                label4.setLocation(100, 50);
                JSlider jSlider = new JSlider(0, 100, 50);
                jSlider.setPaintLabels(true);
        		jSlider.setMajorTickSpacing(10);
        		jSlider.setMinorTickSpacing(5);
        		jSlider.setPaintTicks(true);
        		jSlider.setValue(50);
        		jSlider.addChangeListener(new ChangeListener() {
        			@Override
    				public void stateChanged(ChangeEvent arg0) {
    				stresslevel = jSlider.getValue();}});
                JButton okButton =  new JButton("Valider");
                okButton.addActionListener(this);
                JButton fermer =  new JButton("Fermer");
                fermer.addActionListener(
                		new ActionListener() {
                			@Override
    						public void actionPerformed(ActionEvent arg0) {
    							dispose();}});
                
               
                
                panel1.add(label);
                panel1.add(text1); 
                panel1.add(label2);
                panel1.add(text2);
                
            
            
         
                panel2.add(label3);
                panel2.add(behaviorList);
                panel2.add(label4);
                panel2.add(jSlider);
          
            
                panel2.add(okButton);
                panel2.add(fermer);
               
            this.add( splitPane1);
          
          
                                
        } 

    
    
        
    	@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.print(selected);
			System.out.print("/");
			System.out.print(stresslevel);
			
			ArrayList<Node> n = new ArrayList<Node>(); 
		     Node A = new Node(1,new Position(25,25));
               Node B = new Node(2,new Position(490,25));
               Node C = new Node(3,new Position(940,25));
               
               Node D = new Node(4,new Position(25,260));
               Node E = new Node(5,new Position(490,260));
               Node F = new Node(6,new Position(940,260));
               
               Node G = new Node(7,new Position(25,500));
               Node H = new Node(8,new Position(490,260));
               Node I = new Node(9,new Position(940,260));
               
               n.add(A);
               n.add(B);
               n.add(C);
               n.add(D);
               n.add(E);
               n.add(F);
               n.add(G);
               n.add(H);
               n.add(I);
               
             nodeStart = text1.getText().toString();
            Node nodeStartUsing = null;
             switch (nodeStart){
             case "A" : 
            	 nodeStartUsing = A;
            	 
             case "B" : 
            	 nodeStartUsing = B;
             case "C" : 
            	 nodeStartUsing = C;
             case "D" : 
            	 nodeStartUsing = D;
             case "E" : 
            	 nodeStartUsing = E;
            	 
             case "F" : 
            	 nodeStartUsing = F;
            	 
             case "G" : 
            	 nodeStartUsing = G;
            	 
             case "H" : 
            	 nodeStartUsing = H;
            	 
             case "I" : 
            	 nodeStartUsing = I; 
            
             }
             
             nodes = text2.getText().toString();
             
             
             //TODOS methode pour recup les noeuds du trajet
             
              
            if (selected == "normal" ){
				  Car v1 = new Car(50, 30, nodeStartUsing ,n, new Driver(stresslevel) ,5);
				  Main.Main.vehicules.add(v1);
	            
				}
			if (selected == "Enervé" ){
				   Car v2 = new Car(100, 30, nodeStartUsing,n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v2);
		            
			}
			
			if (selected == "trés Enervé" ){
				   Car v3 = new Car(150, 30, nodeStartUsing ,n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v3);
		             
			}
			dispose();
        
    	}
}

	