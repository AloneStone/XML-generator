package xmlGenerator.GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * where we create the GUI
 */
public class GUIXmlGenerator implements Runnable {
	/**
	 * The window of the application
	 */
	private JFrame window;


	/**
	 * the drawing panel
	 */
	private DrawPanel drawPanel;

	/**
	 * the MenuBar
	 */
	private MenuBar menuBar;


	/**
	 * Creates the GUI
	 */
	private void GUIxml() {
		this.window = new JFrame();
		this.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.window.setLocationRelativeTo(null);

		this.window.setTitle("XML-Generator");

		this.drawPanel = new DrawPanel();

		this.menuBar = new MenuBar(this.drawPanel);
		this.menuBar.initMenu(this.window);
		this.window.getContentPane().add(drawPanel);
		this.window.setVisible(true);
	}

	/**
	 * The method run
	 */
	@Override
	public void run() {
		this.GUIxml();
	}

}
