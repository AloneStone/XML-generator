import javax.swing.*;

import java.awt.event.*;

public class Display {

public Display(){
	
		JFrame f = new JFrame("XML Generator");
	    f.setSize(600,600);
	    
	    JSplitPane split1 = new JSplitPane();
	    JSplitPane split2 = new JSplitPane();
	    JSplitPane split3 = new JSplitPane();
	    split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		//JPanel pan3 = new JPanel();
	    JButton bouton1 = new JButton("fermer");
	    JButton bouton2 = new JButton("Generer");
	    JFrame fenetreJComboBox = new JFrame("Une liste de choix");
	    fenetreJComboBox.setSize(300, 100);
		JComboBox jComboBox = new JComboBox(new String[] { "Normal", "énervé", "lent" });
		pan1.add(bouton2);
		pan2.add(bouton1);
		//pan3.add(fenetreJComboBox);
	    
	    
	    bouton1.addActionListener( new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
	         System.exit(0);
	       }
	    }
	    );
	    
	    bouton2.addActionListener( new ActionListener() {
	       
	    	
	   public void actionPerformed(ActionEvent e) {
	         //Car car = new Car();
	       }  
	    }
	    );

	    split3.add(pan1);
	    split3.add(pan2);
	    split2.add(jComboBox);
	    split1.add(split2);
	    split1.add(split3);
	    f.setVisible(true);
	    f.setContentPane(split1);
	  }
}

