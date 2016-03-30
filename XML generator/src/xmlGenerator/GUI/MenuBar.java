package xmlGenerator.GUI;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	/**
	 * The menu item "Car"
	 */
	private JMenuItem car;
	/**
	 * The menu item "truck"
	 */
	private JMenuItem truck;
	
	private JMenuItem moto;

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
	 * 
	 * @param drawPanel
	 *            drawPanel
	 */
	public MenuBar(DrawPanel drawPanel) {
		this.imageAlreadySaved = false;
		this.menuBar = new JMenuBar();

		this.drawPanel = drawPanel;

		this.file = new JMenu("File");
		this.openImage = new JMenuItem("Open image");

		this.edition = new JMenu("Edition");
		this.erase = new JMenuItem("Erase");
		this.eraseAll = new JMenuItem("Erase all");

		new JMenu("Generation XML");
		this.generer = new JMenuItem("générer");

		this.typeVehicule = new JMenu("choisir véhicule");
		this.car = new JMenuItem("Car");
		this.truck = new JMenuItem("Truck");
		this.moto = new JMenuItem("Moto");

	}

	/**
	 * Initializes the MenuBar and adds ActionListener
	 * 
	 * @param window
	 *            window
	 */
	public void initMenu(final JFrame window) {
		openImage.addActionListener(MenuAction.openImage(this));

		erase.addActionListener(MenuAction.erase(this));

		eraseAll.addActionListener(MenuAction.eraseAll(this));

		car.addActionListener(MenuAction.car(this));

		truck.addActionListener(MenuAction.truck(this));
		
		moto.addActionListener(MenuAction.moto(this));

		generer.addActionListener(MenuAction.generer(this));

		file.add(openImage);
		file.add(erase);
		file.add(eraseAll);
		file.addSeparator();
		file.add(generer);

		typeVehicule.add(truck);
		typeVehicule.add(car);
		typeVehicule.add(moto);
		edition.add(typeVehicule);

		menuBar.add(file);
		menuBar.add(edition);

		window.setJMenuBar(menuBar);
	}

	/**
	 * Returns the drawPanel
	 * 
	 * @return drawPanel
	 */
	public DrawPanel getDrawPanel() {
		return this.drawPanel;
	}

	/**
	 * Returns the boolean imageAlreadySaved
	 * 
	 * @return imageAlreadySaved
	 */
	public boolean getImageAlreadySaved() {
		return this.imageAlreadySaved;
	}

	/**
	 * Returns the imagePath
	 * 
	 * @return imagePath
	 */
	public String getImagePath() {
		return this.imagePath;
	}

	/**
	 * Returns the currentImage
	 * 
	 * @return currentImage
	 */
	public RenderedImage getCurrentImage() {
		return this.currentImage;
	}

	/**
	 * Returns the imageName
	 * 
	 * @return imageName
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * Sets the imageName with a given String
	 * 
	 * @param showInputDialog
	 *            showInputDialog
	 */
	public void setImageName(String showInputDialog) {
		this.imageName = showInputDialog;
	}

	/**
	 * Sets the imagePath with a given String
	 * 
	 * @param path
	 *            path
	 */
	public void setImagePath(String path) {
		this.imagePath = path;
	}

	/**
	 * Sets the currentImage with a given BufferedImage
	 * 
	 * @param createScreenCapture
	 *            createScreenCapture
	 */
	public void setCurrentImage(BufferedImage createScreenCapture) {
		this.currentImage = createScreenCapture;
	}

	/**
	 * Sets the boolean imageAlreadySaved with a given boolean
	 * 
	 * @param b
	 *            boolean
	 */
	public void setImageAlreadySaved(boolean b) {
		this.imageAlreadySaved = b;
	}
}
