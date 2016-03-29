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

	public Popup(int mousePositionX, int mousePositionY) {

		this.behaviors = new String[] { "normal", "Enervé", "trés Enervé" };
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

		JLabel label = new JLabel("Rentrez le noeud de départ :");
		JLabel label2 = new JLabel("Rentrez le trajet :");
		JLabel label3 = new JLabel("Rentrez le comportement du véhicule :");
		label3.setLocation(50, 50);
		JComboBox<String> behaviorList = new JComboBox<>(behaviors);
		behaviorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = (String) behaviorList.getSelectedItem();
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
				stresslevel = jSlider.getValue();
			}
		});
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

		this.add(splitPane1);

	}

	

	private void createVehicle(JTextArea NodeStart, JTextArea nodesString) {

		int maxSpeed = 0;
		int brakingDistance = 30;
		Node startNode;
		ArrayList<Node> route = new ArrayList<Node>();
		Driver driver = new Driver(stresslevel);
		int width = 5;

		if (selected.equals("normal")) {
			maxSpeed = 50;
		}
		if (selected.equals("Enervé")) {
			maxSpeed = 100;
		}
		if (selected.equals("trés Enervé")) {
			maxSpeed = 150;
		}

		startNode = Main.Main.getNodeNumber(Integer.parseInt(NodeStart
				.getText()));

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
		
		Car vehicule = new Car(maxSpeed, brakingDistance, startNode, route, driver, width);
		Main.Main.vehicules.add(vehicule);
		System.out.println("Voiture crée : " + vehicule);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
