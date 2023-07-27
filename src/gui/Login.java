package gui;

/**
 *
 * @author mursalatul
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Login {
    public void login() {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
        
        // login window heading
        JLabel heading = new JLabel("Login");
        // change the value for positioning
        int headingX = 170, headingY = 5, headingW = 100, headingH = 30;
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(headingX, headingY, headingW, headingH);
        heading.setVisible(true);
        frame.add(heading);
        
        // drop box label
        JLabel dDLabel = new JLabel("Login as:");
        // change the value for possiting 
        int dDLabelX = 100, dDLabelY = 60, dDLabelW = 100, dDLabelH = 30;
        dDLabel.setBounds(dDLabelX, dDLabelY, dDLabelW, dDLabelH);
        dDLabel.setVisible(true);
        frame.add(dDLabel);
        dDLabel.setBorder(border);
        
        
        // drop box for selecting login as student or teacher
        String[] options = {"Student", "Teacher"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(210, 60, 100, 30);
        dropdown.setVisible(true);
        frame.add(dropdown);
        dropdown.setBorder(border);
        
        // username
        // username label
        JLabel userLabel = new JLabel("Username:");
        int userLabelX = 50, userLabelY = 150, userLabelW = 100, userLabelH = 30;
        userLabel.setBounds(userLabelX, userLabelY, userLabelW, userLabelH);
        userLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userLabel.setVisible(true);
        frame.add(userLabel);
        userLabel.setBorder(border);
        
        // username testfield
        JTextField userField = new JTextField();
        int userFieldX = 200, userFieldY = 150, userFieldW = 150, userFieldH = 30;
        userField.setBounds(userFieldX, userFieldY, userFieldW, userFieldH);
        userField.setVisible(true);
        frame.add(userField);
        userField.setBorder(border);
        
        // password
        // password label
        JLabel passLabel = new JLabel("Password:");
        int passLabelX = 50, passLabelY = 200, passLabelW = 100, passLabelH = 30;
        passLabel.setBounds(passLabelX, passLabelY, passLabelW, passLabelH);
        passLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passLabel.setVisible(true);
        frame.add(passLabel);
        passLabel.setBorder(border);
        
        // password testfield
        JPasswordField passField = new JPasswordField();
        int passFieldX = 200, passFieldY = 200, passFieldW = 150, passFieldH = 30;
        passField.setBounds(passFieldX, passFieldY, passFieldW, passFieldH);
        passField.setVisible(true);
        frame.add(passField);
        passField.setBorder(border);
        
        // loging button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(10, 300,380, 50);
        loginButton.setVisible(true);
        frame.add(loginButton);
        loginButton.setBorder(border);
        
        
    }
}
