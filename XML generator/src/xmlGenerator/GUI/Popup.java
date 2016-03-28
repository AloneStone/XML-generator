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
			
			System.out.print(text1.getText());
			
            nodeStart = text1.getText();
            Node nodeStartUsing = null;
             switch (nodeStart){
             case "A" : 
            	 nodeStartUsing = Main.Main.A;
            	 
             case "B" : 
            	 nodeStartUsing = Main.Main.B;
             case "C" : 
            	 nodeStartUsing = Main.Main.C;
             case "D" : 
            	 nodeStartUsing = Main.Main.D;
             case "E" : 
            	 nodeStartUsing = Main.Main.E;
            	 
             case "F" : 
            	 nodeStartUsing = Main.Main.F;
            	 
             case "G" : 
            	 nodeStartUsing = Main.Main.G;
            	 
             case "H" : 
            	 nodeStartUsing = Main.Main.H;
            	 
             case "I" : 
            	 nodeStartUsing = Main.Main.I; 
            
             }
             
             nodes = text2.getText().toString();
             
             
             //TODOS methode pour recup les noeuds du trajet
             
              
            if (selected == "normal" ){
				  Car v1 = new Car(50, 30, nodeStartUsing ,Main.Main.n, new Driver(stresslevel) ,5);
				  Main.Main.vehicules.add(v1);
	            
				}
			if (selected == "Enervé" ){
				   Car v2 = new Car(100, 30, nodeStartUsing,Main.Main.n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v2);
		            
			}
			
			if (selected == "trés Enervé" ){
				   Car v3 = new Car(150, 30, nodeStartUsing ,Main.Main.n, new Driver(stresslevel) ,5);
				   Main.Main.vehicules.add(v3);
		             
			}
			dispose();
        
    	}
}

	