package gui;

/**
 *
 * @author mursalatul
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import database.LoginDB;

public class Login {
    public void login() {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setResizable(false);
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
        // action listener
        loginButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // getting role
               String role = (String)dropdown.getSelectedItem();
               // lowwer casing the role case it is showing in the capital form but in the other parts of the program it is used in lower case
               role = role.toLowerCase();
                // getting username from username field
               String username = userField.getText();
               // getting password from password field
               char[] passChars = passField.getPassword();
               String password = new String(passChars);
               // creating LoginDB object to access login creadentials
               LoginDB loginDBObj = new LoginDB();
               if (loginDBObj.isPresent(role, username, password) == true) {
                   JOptionPane.showMessageDialog(frame,"Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                   
                   // hiding login fram
                   frame.setVisible(false);
                   // call student
                   if (role.compareTo("student") == 0) {
                       // extractiong roll from password
                       String roll = extractRoll(password);
                       StudentMain studentGUIObj = new StudentMain();
                       studentGUIObj.studentmain(roll, frame, passField);
                   }
                   // call teacher
                   else {
                       TeacherInputPage teach1Obj = new TeacherInputPage();
                       teach1Obj.teacher(frame, passField);
                   }
                   /*
                       roll: for target spacific student
                       frame: for logout and come back to this frame
                       passField: for clearing the passField before coming back here
                   */
               }
               else {
                   JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
               }
           } 
        });
        
        
    }
    /**
     * extract the hidden roll comes with the password 
     * every password has 2 part. Pallob@19 -> Password = Pallob, roll = 19
     * @param password
     * @return roll
     */
    private String extractRoll(String pass) {
        String roll = "";
        boolean start = false;
        for (int i = 0; i < pass.length(); i++) {
            if (start == true) {
                roll += pass.charAt(i);
            }
            if (pass.charAt(i) == '@') {
                start = true;
            }
        }
        return roll;
    }
}
