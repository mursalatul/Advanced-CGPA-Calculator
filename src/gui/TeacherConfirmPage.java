package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.TeacherInputPage;
import database.Database;

/**
 *
 * @author mursalatul
 */
public class TeacherConfirmPage {

    private String batch, courseNo, courseTitle, semester, roll, incourse, fina, other, gradeLetter, gradePoint;
    private JFrame previousFrame;

    /**
     * store previous Frame, from where this page called, so that when we will
     * click redo button from this page, the data of previous page will not
     * erase
     *
     * @param JFrame object
     * @return none
     */
    public void previousPageFrame(JFrame xFrame) {
        previousFrame = xFrame;
    }

    public void teacherconfirmpage(String... courseInput) {
        this.incourse = courseInput[0];
        this.other = courseInput[1];
        this.fina = courseInput[2];
        this.batch = courseInput[3];
        this.courseNo = courseInput[4];
        this.courseTitle = courseInput[5];
        this.semester = courseInput[6];
        this.roll = courseInput[7];
        this.gradeLetter = courseInput[8];
        this.gradePoint = courseInput[9];

        JFrame frameTea2 = new JFrame();
        frameTea2.setSize(400, 400);
        frameTea2.setResizable(false);
        frameTea2.setLayout(null);
        frameTea2.setVisible(true);
        frameTea2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
        
        // roll
        // roll label
        JLabel rollL = new JLabel("Roll      :" + roll);
        // positioning variables
        int rollLX = 50, rollLY = 10, rollLW = 200, rollLH = 20;
        rollL.setBounds(rollLX, rollLY, rollLW, rollLH);
        rollL.setFont(new Font("Arial", Font.BOLD, 15));
        rollL.setVisible(true);
        frameTea2.add(rollL);
        rollL.setBorder(border);

        // incourse
        // incourse label
        JLabel incourseL = new JLabel("Incourse Mark:" + incourse);
        // positioning variables
        int incourseLX = 50, incourseLY = 50, incourseLW = 200, incourseLH = 20;
        incourseL.setBounds(incourseLX, incourseLY, incourseLW, incourseLH);
        incourseL.setFont(new Font("Arial", Font.BOLD, 15));
        incourseL.setVisible(true);
        frameTea2.add(incourseL);
        incourseL.setBorder(border);

        // final
        // final label
        JLabel finalL = new JLabel("Final Mark       :" + fina);
        // positioning variables
        int finalLX = 50, finalLY = 90, finalLW = incourseLW, finalLH = 20;
        finalL.setBounds(finalLX, finalLY, finalLW, finalLH);
        finalL.setFont(new Font("Arial", Font.BOLD, 15));
        finalL.setVisible(true);
        frameTea2.add(finalL);
        finalL.setBorder(border);

        // other
        // other label
        JLabel otherL = new JLabel("Other Mark     :" + other);
        // positioning variables
        int otherLX = 50, otherLY = 130, otherLW = incourseLW, otherLH = 20;
        otherL.setBounds(otherLX, otherLY, otherLW, otherLH);
        otherL.setFont(new Font("Arial", Font.BOLD, 15));
        otherL.setVisible(true);
        frameTea2.add(otherL);
        otherL.setBorder(border);

        // grade letter
        // grade letter label
        JLabel gLetterL = new JLabel("Grade Letter  :" + gradeLetter);
        // positioning variables
        int gLetterLX = 50, gLetterLY = 170, gLetterLW = incourseLW, gLetterLH = 20;
        gLetterL.setBounds(gLetterLX, gLetterLY, gLetterLW, gLetterLH);
        gLetterL.setFont(new Font("Arial", Font.BOLD, 15));
        gLetterL.setVisible(true);
        frameTea2.add(gLetterL);
        gLetterL.setBorder(border);

        // grade point
        // grade point label
        JLabel gPointL = new JLabel("Grade Point    :" + gradePoint);
        // positioning variables
        int gPointLX = 50, gPointLY = 210, gPointLW = incourseLW, gPointLH = 20;
        gPointL.setBounds(gPointLX, gPointLY, gPointLW, gPointLH);
        gPointL.setFont(new Font("Arial", Font.BOLD, 15));
        gPointL.setVisible(true);
        frameTea2.add(gPointL);
        gPointL.setBorder(border);

        // redo button
        JButton redoB = new JButton("Back");
        int redoBX = 49, redoBY = 250, redoBW = 150, redoBH = 40;
        redoB.setBounds(redoBX, redoBY, redoBW, redoBH);
        redoB.setVisible(true);
        frameTea2.add(redoB);
        redoB.setBorder(border);
        // action listener of redo button
        redoB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // going back to previous page
                frameTea2.setVisible(false);
                previousFrame.setVisible(true);
            }
        });

        // update button
        JButton updateB = new JButton("Update");
        int updateBX = 201, updateBY = 250, updateBW = 150, updateBH = 40;
        updateB.setBounds(updateBX, updateBY, updateBW, updateBH);
        updateB.setVisible(true);
        frameTea2.add(updateB);
        updateB.setBorder(border);
        // action listener of update page
        updateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // save this data in the appropriate storage
                // storage name = roll
                // courseInput is coming from TeacherInputPage
                String incourse = courseInput[0];
                String other = courseInput[1];
                String fina = courseInput[2];
                String batch = courseInput[3];
                String courseNo = courseInput[4];
                String courseTitle = courseInput[5];
                String semester = courseInput[6];
                String roll = courseInput[7];
                
                Database idb = new Database();
                idb.connect(roll);
                // formatting marks
                int incoursePlusOther = Integer.parseInt(incourse) + Integer.parseInt(other);
                int finaInt = Integer.parseInt(fina);
                // inserting data
                idb.insertData(Integer.parseInt(semester), courseNo, courseTitle, incoursePlusOther, finaInt);
                
                // success status
                JOptionPane.showMessageDialog(frameTea2,"CGPA Uploaded", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // going back to previous page
                frameTea2.setVisible(false);
                previousFrame.setVisible(true);
            }
        });
    }
}
