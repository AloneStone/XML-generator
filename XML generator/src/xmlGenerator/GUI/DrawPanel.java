package xmlGenerator.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import xmlGenerator.Pointer;
import xmlGenerator.Shape;
import xmlGenerator.Type;

public class DrawPanel extends JPanel {

	/**
	 * The pointer used to draw on the DrawPanel
	 */
	public static Pointer point;

	/**
	 * The image selected in the JFileChooser (null if not)
	 */
	private Image image;

	/**
	 * An array of Shape : represents all the Shape drew on the DrawPanel
	 */
	public static ArrayList<Shape> points = new ArrayList<Shape>();

	/**
	 * Initializes the DrawPanel
	 * 
	 * @param img
	 *            the image selected in the JFileChooser
	 */
	public DrawPanel(Image img) {
		this.point = new Pointer();
		this.image = img;

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addVehicle(e);
				repaint();
			}
		});

	}

	private void addVehicle(MouseEvent e) {

		new Popup(e.getX(), e.getY());
	}

	/**
	 * Draws the selected image and all the PhotopShapes contain in the array
	 * 
	 * @param g
	 *            graphics
	 */
	public void paintComponent(Graphics g) {

		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, getX(), getY(), null);

		for (Shape shape : this.points) {
			g.drawImage(
					getToolkit()
							.getImage(
									getClass().getResource(
											"/xmlGenerator/GUI/car.png")),
					shape.getPosX(), shape.getPosY(), null);

		}

	}

	/**
	 * Erases the last PhotopShape painted
	 */
	public void erase() {
		if (this.points.size() != 0) {
			this.points.remove(this.points.size() - 1);
		}
		repaint();
	}

	/**
	 * Erases all the PhotopShapes painted
	 */
	public void eraseAll() {
		this.points = new ArrayList<Shape>();
		repaint();
	}

	/**
	 * Sets the pointer's type with a given type
	 * 
	 * @param type
	 *            type
	 */
	public void setPointerType(Type type) {
		this.point.setShape(type);

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

	/**
	 * Sets the pointer's size with a given size
	 * 
	 * @param size
	 *            size
	 */
	public void setPointerSize(int size) {
		this.point.setSize(size + this.point.getSize());
	}

}
