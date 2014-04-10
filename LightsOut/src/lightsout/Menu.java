package lightsout;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


//<<<<<<< HEAD
/**
 *
 * @author alexgarza
 */
public class Menu extends JFrame {
//=======

//>>>>>>> FETCH_HEAD
    private static final long serialVersionUID=1L;
    
    
    public Menu(){
        super("MENU");
        setSize(1000,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p= new JPanel(new GridBagLayout());
        JPanel j= new JPanel();
        JButton b=new JButton("Inicio");
        JButton c=new JButton("Instrucciones");
        JButton d=new JButton("HighScore");
        JLabel e=new JLabel("LIGHTS OUT!");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                JOptionPane.showMessageDialog(null, "Hola");
//To change body of generated methods, choose Tools | Templates.
            }
        });
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.insets=new Insets(15,15,15,15);
        gbc.gridx=0;
        gbc.gridy=0;
        
        p.add(b,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        p.add(c,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        p.add(d,gbc);
       
        
        j.add(e);
        add(p,BorderLayout.SOUTH);
        add(j,BorderLayout.CENTER);
        
         
         
    }
}
