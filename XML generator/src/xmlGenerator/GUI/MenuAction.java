package xmlGenerator.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Main.Main;
import xmlGenerator.TypeVehicule;

public class MenuAction {

	public static ActionListener openImage(final MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileExplorer = new JFileChooser();
				int result = fileExplorer.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					Main.image = fileExplorer.getSelectedFile();
					try {
						Dimension screenSize = Toolkit.getDefaultToolkit()
								.getScreenSize();
						double screenWidth = screenSize.getWidth();
						double screenHeight = screenSize.getHeight();
						if (ImageIO.read(Main.image).getWidth() > screenWidth
								|| ImageIO.read(Main.image).getHeight() > screenHeight) {
							JOptionPane.showMessageDialog(null,
									"Image resolution is too big.");
						} else {
							menuBar.getDrawPanel().setImage(
									ImageIO.read(Main.image));
							menuBar.getDrawPanel().repaint();
							System.out.println(fileExplorer.getSelectedFile()
									.getName());
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					return;
				}
			}
		};
	}

	/**
	 * Erases the last pointer draw
	 * 
	 * @param menuBar
	 *            menuBar
	 * @return actionListener
	 */
	public static ActionListener erase(final MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.getDrawPanel().erase();
			}
		};
	}

	/**
	 * Erases all the pointers contained in the drawPanel
	 * 
	 * @param menuBar
	 *            menubar
	 * @return actionListener
	 */
	public static ActionListener eraseAll(final MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.getDrawPanel().eraseAll();
			}
		};
	}

	public static ActionListener car(final MenuBar menuBar) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuBar.getDrawPanel().setType(TypeVehicule.CAR);
			}
		};
	}

	public static ActionListener truck(MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.getDrawPanel().setType(TypeVehicule.TRUCK);
			}
		};
	}


	public static ActionListener moto(MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.getDrawPanel().setType(TypeVehicule.MOTO);
			}
		};
	}
	
	
	public static ActionListener generer(MenuBar menuBar) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.done();
			}
		};
	}
}
