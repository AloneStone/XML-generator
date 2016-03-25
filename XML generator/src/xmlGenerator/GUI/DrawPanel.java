package xmlGenerator.GUI;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import Main.Car;
import Main.Driver;
import Main.Position;
import Main.Vehicule;
import xmlGenerator.Pointer;
import xmlGenerator.Shape;
import xmlGenerator.Type;
public class DrawPanel extends JPanel
{
	/**
	 * The pointer used to draw on the DrawPanel
	 */
	private Pointer point;
	
	/**
	 * The image selected in the JFileChooser (null if not)
	 */
	private Image image;
	
	/**
	 * An array of Shape : represents all the Shape draw on the DrawPanel
	 */
	private ArrayList<Shape> points = new ArrayList<Shape>();

	private ArrayList<Vehicule> vehi;
	/**
	 * Initializes the DrawPanel
	 * @param img the image selected in the JFileChooser
	 */
	public DrawPanel(Image img)
	{
		this.point = new Pointer();
		this.image = img;
		this.vehi=null;
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				points.add(new Shape(e.getX() - (point.getSize() / 2), e.getY() - (point.getSize() / 2),point));
				
				
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {
				points.add(new Shape(e.getX() - (point.getSize() / 2), e.getY() - (point.getSize() / 2),point));
				
				repaint();
			}
			
			public void mouseMoved(MouseEvent e) {}
		});
		
	}
	
	/**
	 * Draws the selected image and all the PhotopShapes contain in the array
	 * @param g graphics
	 */
	public void paintComponent(Graphics g) 
	{
		
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, getX(), getY(), null);
		
		
		for(Shape shape : this.points)
		{
			//g.setColor(photopShape.getColor());
			if(shape.getType().equals(Type.CAR))
			{
				Image img = getToolkit().getImage(getClass().getResource("/xmlGenerator/GUI/car.png"));
				ImageObserver observer = null;
				g.drawImage(img , shape.getPosX(), shape.getPosY(), observer);;	
				System.out.println("vehicule créé");
				// TODO this.vehi.add(new voiture)
				//Vehicule v1 = new Car(100, 10,new Position(90,90), new Position(100,100)  , new Driver(),10);
				//vehicule.add(v1);
				//System.out.println(vehicule);
		    	new Display();
			}	
			else if(shape.getType().equals(Type.TRUCK))
			{
				Image img = getToolkit().getImage(getClass().getResource("/xmlGenerator/GUI/car.png"));
				ImageObserver observer = null;
				g.drawImage(img , shape.getPosX()-shape.getSize(), shape.getPosY()-shape.getSize(), observer);   
			}	
		}        
	}
	
	
	/**	
	 * Erases the last PhotopShape painted
	 */
	public void erase()
	{
		if(this.points.size()!=0)
		{
			this.points.remove(this.points.size()-1);
		}
		repaint();
	}
	
	/**
	 * Erases all the PhotopShapes painted
	 */
	public void eraseAll()
	{
		this.points = new ArrayList<Shape>();
		repaint();
	}
	
	
	/**
	 * Sets the pointer's type with a given type
	 * @param type type
	 */
	public void setPointerType(Type type)
	{
		this.point.setShape(type);
	
	}
	
	/**
	 * Sets the pointer's image with a given image
	 * @param image image
	 */
	public void setImage(Image image)
	{
		this.image = image;
	}
	
	/**
	 * Sets the pointer's size with a given size
	 * @param size size
	 */
	public void setPointerSize(int size)
	{
		this.point.setSize(size+this.point.getSize());
	}

	public ArrayList<Vehicule> getVehi() {
		return vehi;
	}
	
}
