/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lightsout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author alexgarza
 */
public class Menu extends JFrame {
    private static final long serialVersionUID=1L;
    
    
    public Menu(){
    super("MENU");
    setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p= new JPanel();
        JPanel j= new JPanel();
        JButton b=new JButton("Inicio");
        JButton c=new JButton("Settings");
        JButton d=new JButton("HighScore");
        JLabel e=new JLabel("LIGHTS OUT!");
        p.add(b);
        p.add(c);
        p.add(d);
        j.add(e);
        add(p,BorderLayout.SOUTH);
        add(j,BorderLayout.CENTER);
        
         
         
} 
   
    
}
