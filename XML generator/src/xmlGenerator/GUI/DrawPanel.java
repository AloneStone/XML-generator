package xmlGenerator.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import xmlGenerator.VehiculeRepresentation;
import xmlGenerator.TypeVehicule;

public class DrawPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;

	private TypeVehicule currentType;
	/**
	 * The image selected in the JFileChooser (null if not)
	 */
	private Image image;

	/**
	 * An array of Shape : represents all the Shape drew on the DrawPanel
	 */
	public static ArrayList<VehiculeRepresentation> points = new ArrayList<VehiculeRepresentation>();

	/**
	 * Initializes the DrawPanel
	 * 
	 * @param img
	 *            the image selected in the JFileChooser
	 */
	public DrawPanel() {

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON1)
		        {
					if (currentType != null) {
						addVehicle(e);
						repaint();
					}
		        }else
		        	repaint();
			}
		});
	}

	private void addVehicle(MouseEvent e) {

		new Popup(e.getX(), e.getY(), currentType);

	}

	/**
	 * Draws the selected image and all the PhotopShapes contain in the array
	 * 
	 * @param g
	 *            graphics
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, getX(), getY(), null);

		for (VehiculeRepresentation shape : DrawPanel.points) {
			g.drawImage(
					getToolkit().getImage(
							getClass().getResource(shape.getPath())),
					shape.getPosX(), shape.getPosY(), null);
		}
	}

	/**
	 * Erases the last PhotopShape painted
	 */
	public void erase() {
		if (DrawPanel.points.size() != 0) {
			DrawPanel.points.remove(DrawPanel.points.size() - 1);
			Main.Main.vehicules.remove(Main.Main.vehicules.size() - 1);
		}
		repaint();
	}

	/**
	 * Erases all the PhotopShapes painted
	 */
	public void eraseAll() {
		DrawPanel.points = new ArrayList<VehiculeRepresentation>();
		Main.Main.vehicules.clear();
		repaint();
	}

	/**
	 * Sets the pointer's type with a given type
	 * 
	 * @param type
	 *            type
	 */
	public void setType(TypeVehicule type) {
		currentType = type;
	}

	/**
	 * Sets the pointer's image with a given image
	 * 
	 * @param image
	 *            image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	


}
