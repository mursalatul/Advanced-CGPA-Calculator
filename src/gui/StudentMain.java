package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author mursalatul
 */
public class StudentMain {
    public void studentmain() {
        JFrame frameStu = new JFrame();
        frameStu.setSize(400, 400);
        frameStu.setLayout(null);
        frameStu.setVisible(true);
        frameStu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        
        
    }
}
