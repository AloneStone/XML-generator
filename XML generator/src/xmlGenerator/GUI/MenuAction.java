package xmlGenerator.GUI; 

import java.awt.AWTException; 
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Main.Arc;
import Main.Environement;
import Main.Node;
import Main.Signaling;
import Main.Car;
import Main.Driver;
import Main.Environement;
import Main.Position;
import Main.Scenario;
import Main.Vehicule;
import Main.XML;
import xmlGenerator.Type;
 
public class MenuAction
{
	
	


	/**
	 * opens an image and display it in the drawPanel
	 * @param menuBar menubar
	 * @return actionListener
	 */
	public static ActionListener openImage(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileExplorer = new JFileChooser();
				int result = fileExplorer.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					File file = fileExplorer.getSelectedFile();
					try 
					{
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						double screenWidth = screenSize.getWidth();
						double screenHeight = screenSize.getHeight();
						if(ImageIO.read(file).getWidth() > screenWidth || ImageIO.read(file).getHeight() > screenHeight )
						{
							JOptionPane.showMessageDialog(null, "Image resolution is too big.");
						}
						else
						{
							menuBar.getDrawPanel().setImage(ImageIO.read(file));
							System.out.println(fileExplorer.getSelectedFile().getName());
						}
					} 
					catch (IOException ex) 
					{
						ex.printStackTrace();
					}
					return;
				}								
			}
		};
	}
	
	
	/**
	 * Erases the last pointer draw
	 * @param menuBar menuBar
	 * @return actionListener
	 */
	public static ActionListener erase(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuBar.getDrawPanel().erase();				
			}
		};
	}
	
	
	/**
	 * Erases all the pointers contained in the drawPanel
	 * @param menuBar menubar
	 * @return actionListener
	 */
	public static ActionListener eraseAll(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuBar.getDrawPanel().eraseAll();
			}
		};
	}
	
	
	
	/**
	 * Saves the image and all the pointers contained in the drawpanel
	 * @param menuBar menubar
	 * @return ActionListener
	 */
	public static ActionListener saveImage(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser directoryChooser = new JFileChooser();
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				if(menuBar.getImageAlreadySaved())
				{
					try
					{
						JOptionPane.showMessageDialog(null, "Saving in progress");
						menuBar.setCurrentImage(new Robot().createScreenCapture(new Rectangle(menuBar.getDrawPanel().getLocationOnScreen().x, menuBar.getDrawPanel().getLocationOnScreen().y, menuBar.getDrawPanel().getWidth(), menuBar.getDrawPanel().getHeight())));
						ImageIO.write(menuBar.getCurrentImage(), "PNG", new File(menuBar.getImagePath()+"/"+menuBar.getImageName()+".PNG"));
						JOptionPane.showMessageDialog(null, "Image "+menuBar.getImageName()+".png saved !");
					} 
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
					catch (AWTException e1)
					{
						e1.printStackTrace();
					}
					
				} 
				else
				{
					menuBar.setImageName(JOptionPane.showInputDialog(menuBar.getDrawPanel(),"Name of the image ?"));
					
					if(menuBar.getImageName() != null)
					{
						if(directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
						{
							menuBar.setImagePath(directoryChooser.getSelectedFile().getPath());
							try
							{
								try
								{
									menuBar.setCurrentImage(new Robot().createScreenCapture(new Rectangle(menuBar.getDrawPanel().getLocationOnScreen().x, menuBar.getDrawPanel().getLocationOnScreen().y, menuBar.getDrawPanel().getWidth(), menuBar.getDrawPanel().getHeight())));
									ImageIO.write(menuBar.getCurrentImage(), "PNG", new File(menuBar.getImagePath()+"/"+menuBar.getImageName()+".PNG"));
									JOptionPane.showMessageDialog(null, "Image "+menuBar.getImageName()+".png saved !");
									menuBar.setImageAlreadySaved(true);
								} 
								catch (AWTException e1)
								{
									e1.printStackTrace();
								}
							} 
							catch (IOException e1)
							{
								e1.printStackTrace();
							}
						}
					}
				}
			}
		};
	}
	
	
	/**
	 * 
	 * @param menuBar menubar
	 * @return ActionListener
	 */
	public static ActionListener saveAsImage(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser directoryChooser = new JFileChooser();
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				menuBar.setImageName(JOptionPane.showInputDialog(menuBar.getDrawPanel(),"Name of the image ?"));
				
				if(menuBar.getImageName() != null)
				{
					if(directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
					{
						menuBar.setImagePath(directoryChooser.getSelectedFile().getPath());
						try
						{
							try
							{
								menuBar.setCurrentImage(new Robot().createScreenCapture(new Rectangle(menuBar.getDrawPanel().getLocationOnScreen().x, menuBar.getDrawPanel().getLocationOnScreen().y, menuBar.getDrawPanel().getWidth(), menuBar.getDrawPanel().getHeight())));
								ImageIO.write(menuBar.getCurrentImage(), "PNG", new File(menuBar.getImagePath()+"/"+menuBar.getImageName()+".PNG"));
								JOptionPane.showMessageDialog(null, "Image "+menuBar.getImageName()+".png saved !");
								menuBar.setImageAlreadySaved(true);
							} 
							catch (AWTException e1)
							{
								e1.printStackTrace();
							}
						} 
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					}
				}
				
			}
		};
	}
	
	
	/**
	 * Creates an image with a specific height and width and display it in the drawPanel
	 * @param menuBar menubar
	 * @param window window
	 * @return ActionListener actionListener
	 */
	public static ActionListener createImage(final MenuBar menuBar, final JFrame window)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int height = Integer.parseInt(new JOptionPane().showInputDialog(null,"Which height do you want ?"));
				int width = Integer.parseInt(new JOptionPane().showInputDialog(null,"Which width do you want ?"));
				if(height <= 0 || width <= 0)
				{
					JOptionPane.showMessageDialog(null, "Invalid size");
				}
				else
				{
					menuBar.getDrawPanel().eraseAll();
					window.setSize(width, height);
					window.setResizable(false);
				}
			}
		};
	}
	
	

	public static ActionListener car(final MenuBar menuBar)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e, Vehicule v)
			{
				menuBar.getDrawPanel().setPointerType(Type.CAR);
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}


	public static ActionListener truck(MenuBar menuBar) {
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuBar.getDrawPanel().setPointerType(Type.TRUCK);				
			}
		};
	}
	

	public static ActionListener generer(MenuBar menuBar) {
		return new ActionListener()
		{
			
			//private Collection<Vehicule> vehi;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				Collection<Signaling> signaling = null;
				ArrayList<Node> n = null;
				ArrayList<Arc> a = null;
				
				Environement env = new Environement("./img/picture.png",signaling, n, a);
		    	
		    	
		    	
				//Scenario s = new Scenario(,env);
		    	
		    	XML xml = new XML();
		    //	xml.toXML(s);
				System.out.println("g�n�r�");				
			}
		};
	}
	
	

	

	}


