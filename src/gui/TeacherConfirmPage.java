package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


/**
 *
 * @author mursalatul
 */
public class TeacherConfirmPage {
    public void teacherconfirmpage() {
        JFrame frameTea2 = new JFrame();
        frameTea2.setSize(400, 400);
        frameTea2.setLayout(null);
        frameTea2.setVisible(true);
        frameTea2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        
        // incourse
        // incourse label
        JLabel incourseL = new JLabel("Incourse Mark:");
        // positioning variables
        int incourseLX = 50, incourseLY = 50, incourseLW = 120, incourseLH = 20;
        incourseL.setBounds(incourseLX, incourseLY, incourseLW, incourseLH);
        incourseL.setFont(new Font("Arial", Font.BOLD, 15));
        incourseL.setVisible(true);
        frameTea2.add(incourseL);
        incourseL.setBorder(border);
        
        // final
        // final label
        JLabel finalL = new JLabel("Final Mark       :");
        // positioning variables
        int finalLX = 50, finalLY = 90, finalLW = incourseLW, finalLH = 20;
        finalL.setBounds(finalLX, finalLY, finalLW, finalLH);
        finalL.setFont(new Font("Arial", Font.BOLD, 15));
        finalL.setVisible(true);
        frameTea2.add(finalL);
        finalL.setBorder(border);
        
        // other
        // other label
        JLabel otherL = new JLabel("Other Mark     :");
        // positioning variables
        int otherLX = 50, otherLY = 130, otherLW = incourseLW, otherLH = 20;
        otherL.setBounds(otherLX, otherLY, otherLW, otherLH);
        otherL.setFont(new Font("Arial", Font.BOLD, 15));
        otherL.setVisible(true);
        frameTea2.add(otherL);
        otherL.setBorder(border);
        
        // grade letter
        // grade letter label
        JLabel gLetterL = new JLabel("Grade Letter  :");
        // positioning variables
        int gLetterLX = 50, gLetterLY = 170, gLetterLW = incourseLW, gLetterLH = 20;
        gLetterL.setBounds(gLetterLX, gLetterLY, gLetterLW, gLetterLH);
        gLetterL.setFont(new Font("Arial", Font.BOLD, 15));
        gLetterL.setVisible(true);
        frameTea2.add(gLetterL);
        gLetterL.setBorder(border);
        
        // grade point
        // grade point label
        JLabel gPointL = new JLabel("Grade Point    :");
        // positioning variables
        int gPointLX = 50, gPointLY = 210, gPointLW = incourseLW, gPointLH = 20;
        gPointL.setBounds(gPointLX, gPointLY, gPointLW, gPointLH);
        gPointL.setFont(new Font("Arial", Font.BOLD, 15));
        gPointL.setVisible(true);
        frameTea2.add(gPointL);
        gPointL.setBorder(border);
        
        // redo button
        JButton redoB = new JButton("Redo");
        int redoBX = 49, redoBY = 250, redoBW = 150, redoBH = 40;
        redoB.setBounds(redoBX, redoBY, redoBW, redoBH);
        redoB.setVisible(true);
        frameTea2.add(redoB);
        redoB.setBorder(border);
        
        // update button
        JButton updateB = new JButton("Update");
        int updateBX = 201, updateBY = 250, updateBW = 150, updateBH = 40;
        updateB.setBounds(updateBX, updateBY, updateBW, updateBH);
        updateB.setVisible(true);
        frameTea2.add(updateB);
        updateB.setBorder(border);
        
    }
}
