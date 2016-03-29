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
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Car;
import Main.Driver;
import Main.Node;
import xmlGenerator.Shape;

/**
 * 
 * @author Maxime, Antoine
 *
 */

public class Popup extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String[] behaviors;
	public String selected;
	public int stresslevel = 50;

	public String nodeDepart;
	public String trajet;
	public JSplitPane splitPane1, splitPane2, splitPane3;
	public JPanel panel1, panel2;
	public String nodeStart;
	public String nodes;
	public JTextArea text1;
	public JTextArea text2;
	public JSlider jSlider2, jSlider1, jSlider3;
	public JLabel label5; // vitesse 
	public JLabel label6; //breakingdistance 
	public int maxSpeed = 0;
	
	public int vitesse;
	public int reactionTime;

	public Popup(int mousePositionX, int mousePositionY) {

		this.behaviors = new String[] { "   ","normal", "Enervé", "trés Enervé" };
		this.setTitle("XML Generator");
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Panel panel1 = new Panel();
		Panel panel2 = new Panel();

		this.setVisible(true);

		splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
		splitPane1.setResizeWeight(0.2);
		splitPane1.setOneTouchExpandable(false);
		splitPane1.setDividerLocation(0.5);
		
JSlider jSlider1 = new JSlider(0, 100, 50);
		
		jSlider1.setPaintLabels(true);
		jSlider1.setMajorTickSpacing(10);
		jSlider1.setMinorTickSpacing(5);
		jSlider1.setPaintTicks(true);
		jSlider1.setValue(50);
		jSlider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				stresslevel = jSlider1.getValue();
			}
		});
		JSlider jSlider2 = new JSlider(0, 200, 50);
		jSlider2.setPaintLabels(true);
		jSlider2.setMajorTickSpacing(10);
		jSlider2.setMinorTickSpacing(5);
		jSlider2.setPaintTicks(true);
		jSlider2.setValue(50);
		jSlider2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				maxSpeed = jSlider2.getValue();
			}
		});
		JLabel label5 = new JLabel("Vitesse du vehicule :");
		label5.setLocation(100, 50);
		
		JSlider jSlider3 = new JSlider(0, 10, 50);
		jSlider3.setPaintLabels(true);
		jSlider3.setMajorTickSpacing(10);
		jSlider3.setMinorTickSpacing(5);
		jSlider3.setPaintTicks(true);
		jSlider3.setValue(5);
		jSlider3.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				reactionTime = jSlider3.getValue();
			}
		});

		JLabel label2 = new JLabel("Rentrez le trajet :");
		JLabel label3 = new JLabel("Rentrez le comportement du véhicule :");
		
		label3.setLocation(50, 50);
//		JComboBox<String> behaviorList = new JComboBox<>(behaviors);
//		behaviorList.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				selected = (String) behaviorList.getSelectedItem();
//				switch (selected){
//				case "   " :
//					jSlider1.setValue(50); 	//stresslevel
//					jSlider2.setValue(50);  //speed
//					jSlider2.setValue(50); // reactionTime 
//				
//				case "normal" : 
//					jSlider1.setValue(25);	
//					jSlider2.setValue(50);
//					jSlider3.setValue(1);
//				
//				case "Enervé" : 
//					jSlider1.setValue(75);	
//					jSlider2.setValue(100);
//					jSlider3.setValue(1);
//					
//				case "trés Enervé" : 
//					jSlider1.setValue(100);	
//					jSlider2.setValue(150);
//					jSlider3.setValue(1);
//				
//				
//				}
//				
//				
//				
//				
//			}
//		});
//		behaviorList.setSelectedIndex(0);
//		
		
		JTextArea text2 = new JTextArea("", 2, 10);
		JScrollPane scroll = new JScrollPane(text2);
		
		JLabel label4 = new JLabel("Niveau de stress du conducteur :");
		label4.setLocation(100, 50);
		
		JLabel label6 = new JLabel("distance de freinage :");
		label6.setLocation(100, 50);
		
		JButton okButton = new JButton("Valider");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DrawPanel.points.add(new Shape(mousePositionX
						- (DrawPanel.point.getSize() / 2), mousePositionY
						- (DrawPanel.point.getSize() / 2), DrawPanel.point));
				createVehicle(text1, text2);
				dispose();
			}

		});
		JButton fermer = new JButton("Fermer");
		fermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		panel1.add(label2);
		panel1.add(scroll);
		panel2.add(label3);
		//panel2.add(behaviorList);
		panel2.add(label4);
		panel2.add(jSlider1);
		panel2.add(label5);
		panel2.add(jSlider2);
		panel2.add(label6);
		panel2.add(jSlider3);
		panel2.add(okButton);
		panel2.add(fermer);

		this.add(splitPane1);

	}

	private void createVehicle(JTextArea NodeStart, JTextArea nodesString) {

		ArrayList<Node> route = new ArrayList<Node>();
		Driver driver = new Driver(stresslevel, maxSpeed, reactionTime) ;
		
		nodes = nodesString.getText();

		String[] NodeStringSplit = nodes.split("-");

		for (int i = 0; i < NodeStringSplit.length; i++) {

			String nodeI = NodeStringSplit[i];

			if (nodeI.equals("1")) {
				route.add(Main.Main.A);
			}

			if (nodeI.equals("2")) {
				route.add(Main.Main.B);
			}

			if (nodeI.equals("3")) {
				route.add(Main.Main.C);
			}

			if (nodeI.equals("4")) {
				route.add(Main.Main.D);

			}

			if (nodeI.equals("5")) {
				route.add(Main.Main.E);

			}

			if (nodeI.equals("6")) {
				route.add(Main.Main.F);

			}

			if (nodeI.equals("7")) {
				route.add(Main.Main.G);

			}

			if (nodeI.equals("8")) {
				route.add(Main.Main.H);

			}

			if (nodeI.equals("9")) {
				route.add(Main.Main.I);

			}
		}

		Car vehicule = new Car(route, driver);
		Main.Main.vehicules.add(vehicule);
		System.out.println("Voiture crée : " + vehicule);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
