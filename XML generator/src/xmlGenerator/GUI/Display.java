package xmlGenerator.GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Display extends JFrame {
        public Display(){
                this.setTitle("XML Generator");
                this.setSize(300, 500);
                this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
            this.setVisible(true);                
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Rentrez le noeud de départ :");
                panel.add(label);
                JTextArea text1 = new JTextArea("", 2, 10);
                panel.add(text1);        
                
            JLabel label2 = new JLabel("Rentrez le noeud d'arrivée :");
            panel.add(label2);
            JTextArea text2 = new JTextArea("", 2, 10);
                panel.add(text2);        
            
            JLabel label3 = new JLabel("Rentrez le comportement du véhicule :");
            label3.setLocation(50, 50);
            panel.add(label3);
            JTextArea text3 = new JTextArea("", 2, 10);
                panel.add(text3);        
                this.add(panel);
                JButton okButton =  new JButton("Valider");
                panel.add(okButton);
                                
        }

        public String getText(JTextArea text){
                String userText = text.getText();
                return userText;
        }
}