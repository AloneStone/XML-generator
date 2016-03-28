package xmlGenerator.GUI;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar
{
	/**
	 * The menubar
	 */
	private JMenuBar menuBar;
	/**
	 * The tab file
	 */
	private JMenu file;
	/**
	 * The menu item "open image"
	 */
	private JMenuItem openImage;
	/**
	 * The menu item "create image"
	 */
	private JMenuItem createImage;
	/**
	 * The menu item "save image"
	 */
	private JMenuItem saveImage;
	/**
	 * The menu item "save as"
	 */
	private JMenuItem saveAsImage;
	/**
	 * The menu item "Quit"
	 */
	private JMenuItem quit;
	
	private JMenuItem generer;
	
	/**
	 * The tab edition
	 */
	private JMenu edition;
	/**
	 * The menu item "erase"
	 */
	private JMenuItem erase;
	/**
	 * The menu item "erase all"
	 */
	private JMenuItem eraseAll;
	
	/**
	 * The type 
	 */
	private JMenu typeVehicule;
	
	private JMenu generation;
	/**
	 * The menu item "Car"
	 */
	private JMenuItem car;
	/**
	 * The menu item "truck"
	 */
	private JMenuItem truck;
	
	/**
	 * Represents if the image is already saved or not
	 */
	private boolean imageAlreadySaved;
	/**
	 * The path of the file
	 */
	private String imagePath;
	/**
	 * the name of the image
	 */
	private String imageName;
	/**
	 * The current image
	 */
	private BufferedImage currentImage;
	
	/**
	 * The drawpanel of the application
	 */
	private DrawPanel drawPanel;
	
	/**
	 * The constructor of the menubar
	 * @param drawPanel drawPanel
	 */
	public MenuBar(DrawPanel drawPanel)
	{
		this.imageAlreadySaved = false;
		this.menuBar = new JMenuBar();
		
		this.drawPanel = drawPanel;
		
		this.file = new JMenu("File");
		this.openImage = new JMenuItem("Open image");
		this.createImage = new JMenuItem("Create image");
		this.saveImage = new JMenuItem("Save image");
		this.saveAsImage = new JMenuItem("Save as");
		this.quit = new JMenuItem("Quit");
		
		this.edition = new JMenu("Edition");
		this.erase = new JMenuItem("Erase");
		this.eraseAll = new JMenuItem("Erase all");
		
	
		
		this.generation = new JMenu("Generation XML");
		this.generer = new JMenuItem("générer");
		
		
		this.typeVehicule = new JMenu("choisir véhicule");
		this.car = new JMenuItem("Car");
		this.truck = new JMenuItem("Truck");
		
		}
	
	/**
	 * Initializes the MenuBar and adds ActionListener
	 * @param window window
	 */
	public void initMenu(final JFrame window)
	{	
		openImage.addActionListener(MenuAction.openImage(this));
		
		erase.addActionListener(MenuAction.erase(this));
		
		eraseAll.addActionListener(MenuAction.eraseAll(this));
		
		
		saveImage.addActionListener(MenuAction.saveImage(this));
		
		saveAsImage.addActionListener(MenuAction.saveAsImage(this));
		
		createImage.addActionListener(MenuAction.createImage(this,window));
		

		
		car.addActionListener(MenuAction.car(this));
		
		truck.addActionListener(MenuAction.truck(this));
		
		generer.addActionListener(MenuAction.generer(this));
		
		
		
		file.add(openImage);
		openImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		file.add(createImage);
		createImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		file.add(saveImage);
		saveImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		file.add(saveAsImage);
		file.add(erase);
		erase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		file.add(eraseAll);
		eraseAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));;
		file.addSeparator();
		file.add(quit);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		file.add(generer);

		
		
		
		
		
		
		file.add(generer);
		typeVehicule.add(truck);
		typeVehicule.add(car);
		edition.add(typeVehicule);
		
		menuBar.add(file);
		menuBar.add(edition);
		
		
		window.setJMenuBar(menuBar);
	}
	
	/**
	 * Returns the drawPanel
	 * @return drawPanel
	 */
	public DrawPanel getDrawPanel()
	{
		return this.drawPanel;
	}
	
	/**
	 * Returns the boolean imageAlreadySaved
	 * @return imageAlreadySaved
	 */
	public boolean getImageAlreadySaved()
	{
		return this.imageAlreadySaved;
	}
	
	/**
	 * Returns the imagePath
	 * @return imagePath
	 */
	public String getImagePath()
	{
		return this.imagePath;
	}
	
	/**
	 * Returns the currentImage
	 * @return currentImage
	 */
	public RenderedImage getCurrentImage()
	{
		return this.currentImage;
	}
	
	/**
	 * Returns the imageName
	 * @return imageName
	 */
	public String getImageName()
	{
		return this.imageName;
	}
	
	/**
	 * Sets the imageName with a given String
	 * @param showInputDialog showInputDialog
	 */
	public void setImageName(String showInputDialog)
	{
		this.imageName = showInputDialog;
	}
	
	/**
	 * Sets the imagePath with a given String
	 * @param path path
	 */
	public void setImagePath(String path)
	{
		this.imagePath = path;
	}
	
	/**
	 * Sets the currentImage with a given BufferedImage
	 * @param createScreenCapture createScreenCapture
	 */
	public void setCurrentImage(BufferedImage createScreenCapture)
	{
		this.currentImage = createScreenCapture;
	}
	
	/**
	 * Sets the boolean imageAlreadySaved with a given boolean
	 * @param b boolean
	 */
	public void setImageAlreadySaved(boolean b)
	{
		this.imageAlreadySaved = b;
	}
}
