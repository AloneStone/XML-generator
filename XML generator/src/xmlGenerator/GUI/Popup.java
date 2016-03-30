package xmlGenerator.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Arc;
import Main.Car;
import Main.Moto;
import Main.Truck;
import Main.Vehicule;
import Main.Driver;
import Main.Node;
import xmlGenerator.VehiculeRepresentation;
import xmlGenerator.TypeVehicule;

/**
 *
 * @author Maxime, Antoine
 *
 */

public class Popup extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public String selected;

	public int stresslevel = 50;

	public String nodeDepart;

	public JSplitPane splitPanePopUp;

	public JPanel panelTop, panelBot;

	public JLabel labelPath, labelProfile, labelStressLevel;

	public String nodeStart;

	public String nodes;

	public JTextArea JTextAreaPathOfvehicle;

	public JSlider jSliderStressLevel, jSliderMaxSpeed, jSliderReactionTime;

	public JLabel labelForSpeed;

	public JLabel labelReactionTime;

	public JLabel introduction;

	public JScrollPane scrollOfJTextAreaPathOfvehicle;

	public int maxSpeed = 0;

	public int vitesse;

	public int reactionTime;

	public JButton fermer;

	public JButton okButton;

	public JRadioButton normalBehaviour;

	public JRadioButton angryBehaviour;

	public JRadioButton veryAngryBehaviour;

	public ButtonGroup behaviour;

	public Popup(int mousePositionX, int mousePositionY, TypeVehicule type) {

		this.setTitle("XML Generator");

		this.setSize(300, 500);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.panelTop = new JPanel();

		this.panelBot = new JPanel();

		this.normalBehaviour = new JRadioButton(" nomal ");

		this.angryBehaviour = new JRadioButton(" énervé ");

		this.veryAngryBehaviour = new JRadioButton(" très énervé ");

		this.behaviour = new ButtonGroup();

		this.behaviour.add(normalBehaviour);

		this.behaviour.add(angryBehaviour);

		this.behaviour.add(veryAngryBehaviour);

		this.setVisible(true);

		this.splitPanePopUp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				panelTop, panelBot);

		this.splitPanePopUp.setResizeWeight(0.2);

		this.splitPanePopUp.setOneTouchExpandable(false);

		this.splitPanePopUp.setDividerLocation(0.5);

		this.jSliderStressLevel = new JSlider(0, 100, 50);

		this.jSliderStressLevel.setPaintLabels(true);

		this.jSliderStressLevel.setMajorTickSpacing(10);

		this.jSliderStressLevel.setMinorTickSpacing(5);

		this.jSliderStressLevel.setPaintTicks(true);

		this.jSliderStressLevel.setValue(50);

		this.jSliderStressLevel.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				stresslevel = jSliderStressLevel.getValue();
			}

		});

		this.jSliderMaxSpeed = new JSlider(0, 200, 50);

		this.jSliderMaxSpeed.setPaintLabels(true);

		this.jSliderMaxSpeed.setMajorTickSpacing(25);

		this.jSliderMaxSpeed.setMinorTickSpacing(10);

		this.jSliderMaxSpeed.setPaintTicks(true);

		this.jSliderMaxSpeed.setValue(50);

		this.jSliderMaxSpeed.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				maxSpeed = jSliderMaxSpeed.getValue();
			}
		});

		this.labelForSpeed = new JLabel("Vitesse du vehicule :");

		this.labelForSpeed.setLocation(100, 50);

		Font f = new Font("Serif", Font.PLAIN, 18);

		this.introduction = new JLabel(
				"<html><body><b />Rentrez les paramètres du Véhicule</body></html>");

		this.introduction.setFont(f);

		this.introduction.setLocation(100, 50);

		this.jSliderReactionTime = new JSlider(0, 100, 50);

		this.jSliderReactionTime.setPaintLabels(true);

		this.jSliderReactionTime.setMajorTickSpacing(10);

		this.jSliderReactionTime.setMinorTickSpacing(5);

		this.jSliderReactionTime.setPaintTicks(true);

		this.jSliderReactionTime.setValue(5);

		this.jSliderReactionTime.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				reactionTime = jSliderReactionTime.getValue();
			}
		});

		this.labelPath = new JLabel("Rentrez le trajet :");

		this.labelProfile = new JLabel(
				"      Rentrez le profil du conducteur :     ");

		this.labelProfile.setLocation(50, 50);

		this.JTextAreaPathOfvehicle = new JTextArea("", 2, 10);

		this.scrollOfJTextAreaPathOfvehicle = new JScrollPane(
				JTextAreaPathOfvehicle);

		this.labelStressLevel = new JLabel("Niveau de stress du conducteur :");

		this.labelStressLevel.setLocation(100, 50);

		this.labelReactionTime = new JLabel("    temps de réaction :    ");

		this.labelReactionTime.setLocation(100, 50);

		this.okButton = new JButton("Valider");

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createVehicle(JTextAreaPathOfvehicle, type);
				GUIXmlGenerator.drawPanel.repaint();
				dispose();
			}

		});
		this.fermer = new JButton("Fermer");
		this.fermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		this.jSliderStressLevel.setValue(50); // stresslevel
		this.jSliderMaxSpeed.setValue(50); // speed
		this.jSliderReactionTime.setValue(50); // reactionTime

		normalBehaviour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (normalBehaviour.isSelected()) {
					jSliderStressLevel.setValue(25);
					jSliderMaxSpeed.setValue(50);
					jSliderReactionTime.setValue(1);
				}

			}

		});

		angryBehaviour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (angryBehaviour.isSelected()) {
					jSliderStressLevel.setValue(75);
					jSliderMaxSpeed.setValue(100);
					jSliderReactionTime.setValue(5);
				}

			}
		});

		veryAngryBehaviour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (veryAngryBehaviour.isSelected()) {
					jSliderStressLevel.setValue(100);
					jSliderMaxSpeed.setValue(150);
					jSliderReactionTime.setValue(10);
				}

			}
		});

		this.panelTop.add(introduction);

		this.panelTop.add(labelPath);

		this.panelTop.add(scrollOfJTextAreaPathOfvehicle);

		this.panelBot.add(labelProfile);

		this.panelBot.add(normalBehaviour);

		this.panelBot.add(angryBehaviour);

		this.panelBot.add(veryAngryBehaviour);

		this.panelBot.add(labelStressLevel);

		this.panelBot.add(jSliderStressLevel);

		this.panelBot.add(labelForSpeed);

		this.panelBot.add(jSliderMaxSpeed);

		this.panelBot.add(labelReactionTime);

		this.panelBot.add(jSliderReactionTime);

		this.panelBot.add(okButton);

		this.panelBot.add(fermer);

		this.add(splitPanePopUp);
	}

	private void createVehicle(JTextArea nodesString, TypeVehicule type) {

		ArrayList<Node> route = new ArrayList<Node>();
		Driver driver = new Driver(stresslevel, maxSpeed, reactionTime);

		nodes = nodesString.getText();

		if (nodes.length() != 0) {
			
			String[] NodeStringSplit = nodes.split("-");
			Node firstNode = Node.getNodeNumber(Integer
					.parseInt(NodeStringSplit[0]));
			for (int i = 0; i < NodeStringSplit.length; i++) {
				String nodeI = NodeStringSplit[i];
				if (!(Integer.parseInt(nodeI) < Main.Main.node.size()))
					return;
				route.add(Node.getNodeNumber(Integer.parseInt(nodeI)));
			}

			Vehicule vehicule = null;

			if (type == TypeVehicule.CAR)
				vehicule = new Car(route, driver);
			if (type == TypeVehicule.MOTO)
				vehicule = new Moto(route, driver);
			if (type == TypeVehicule.TRUCK)
				vehicule = new Truck(route, driver);

			Main.Main.vehicules.add(vehicule);
			System.out.println("Vehicule crée : " + vehicule);

			DrawPanel.points
					.add(new VehiculeRepresentation(firstNode.getPosition()
							.getX(), firstNode.getPosition().getY(), type));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}