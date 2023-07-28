package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gradecalculation.Grade;

/**
 *
 * @author mursalatul
 */
public class TeacherInputPage {

    public void teacher() {
        JFrame frameTea = new JFrame();
        frameTea.setSize(400, 460);
        frameTea.setResizable(false);
        frameTea.setLayout(null);
        frameTea.setVisible(true);
        frameTea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
        
        // teacher window heading
        JLabel heading = new JLabel("Welcome Teacher");
        // change the value for positioning
        int headingX = 107, headingY = 5, headingW = 180, headingH = 30;
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(headingX, headingY, headingW, headingH);
        heading.setVisible(true);
        frameTea.add(heading);
        heading.setBorder(border);
        
        // batch
        // batch label
        JLabel batchL = new JLabel("Batch");
        // positioning variables
        int batchLX = 50, batchLY = 50, batchLW = 50, batchLH = 20;
        batchL.setBounds(batchLX, batchLY, batchLW, batchLH);
        batchL.setFont(new Font("Arial", Font.BOLD, 15));
        batchL.setVisible(true);
        frameTea.add(batchL);
        batchL.setBorder(border);
        // batch field
        JTextField batchF = new JTextField();
        // positioning variables
        int batchFX = 195, batchFY = 50, batchFW = 150, batchFH = 20;
        batchF.setBounds(batchFX, batchFY, batchFW, batchFH);
        batchF.setVisible(true);
        frameTea.add(batchF);
        batchF.setBorder(border);
        
        // Course
        // Course label
        JLabel courseL = new JLabel("Course No");
        // positioning variables
        int courseLX = 50, courseLY = 90, courseLW = 100, courseLH = 20;
        courseL.setBounds(courseLX, courseLY, courseLW, courseLH);
        courseL.setFont(new Font("Arial", Font.BOLD, 15));
        courseL.setVisible(true);
        frameTea.add(courseL);
        courseL.setBorder(border);
        // course field
        JTextField courseF = new JTextField();
        // positioning variables
        int courseFX = 195, courseFY = 90, courseFW = 150, courseFH = 20;
        courseF.setBounds(courseFX, courseFY, courseFW, courseFH);
        courseF.setVisible(true);
        frameTea.add(courseF);
        courseF.setBorder(border);
        
        // Course Title
        // CourseT label
        JLabel courseTL = new JLabel("Course Title");
        // positioning variables
        int courseTLX = 50, courseTLY = 130, courseTLW = 100, courseTLH = 20;
        courseTL.setBounds(courseTLX, courseTLY, courseTLW, courseTLH);
        courseTL.setFont(new Font("Arial", Font.BOLD, 15));
        courseTL.setVisible(true);
        frameTea.add(courseTL);
        courseTL.setBorder(border);
        // courseT field
        JTextField courseTF = new JTextField();
        // positioning variables
        int courseTFX = 195, courseTFY = 130, courseTFW = 150, courseTFH = 20;
        courseTF.setBounds(courseTFX, courseTFY, courseTFW, courseTFH);
        courseTF.setVisible(true);
        frameTea.add(courseTF);
        courseTF.setBorder(border);
        
        // Semester
        // Semester label
        JLabel semL = new JLabel("Semester");
        // positioning variables
        int semLX = 50, semLY = 170, semLW = 100, semLH = 20;
        semL.setBounds(semLX, semLY, semLW, semLH);
        semL.setFont(new Font("Arial", Font.BOLD, 15));
        semL.setVisible(true);
        frameTea.add(semL);
        semL.setBorder(border);
        // semester field
        JTextField semF = new JTextField();
        // positioning variables
        int semFX = 195, semFY = 170, semFW = 150, semFH = 20;
        semF.setBounds(semFX, semFY, semFW, semFH);
        semF.setVisible(true);
        frameTea.add(semF);
        semF.setBorder(border);
        
        // roll
        // roll label
        JLabel rollL = new JLabel("Roll");
        // positioning variables
        int rollLX = 50, rollLY = 210, rollLW = 100, rollLH = 20;
        rollL.setBounds(rollLX, rollLY, rollLW, rollLH);
        rollL.setFont(new Font("Arial", Font.BOLD, 15));
        rollL.setVisible(true);
        frameTea.add(rollL);
        rollL.setBorder(border);
        // roll field
        JTextField rollF = new JTextField();
        // positioning variables
        int rollFX = 195, rollFY = 210, rollFW = 150, rollFH = 20;
        rollF.setBounds(rollFX, rollFY, rollFW, rollFH);
        rollF.setVisible(true);
        frameTea.add(rollF);
        rollF.setBorder(border);
        
        
        // incourse
        // incourse label
        JLabel incourseL = new JLabel("Incourse Mark");
        // positioning variables
        int incourseLX = 50, incourseLY = 250, incourseLW = 100, incourseLH = 20;
        incourseL.setBounds(incourseLX, incourseLY, incourseLW, incourseLH);
        incourseL.setFont(new Font("Arial", Font.BOLD, 15));
        incourseL.setVisible(true);
        frameTea.add(incourseL);
        incourseL.setBorder(border);
        // incourse field
        JTextField incourseF = new JTextField();
        // positioning variables
        int incourseFX = 195, incourseFY = 250, incourseFW = 150, incourseFH = 20;
        incourseF.setBounds(incourseFX, incourseFY, incourseFW, incourseFH);
        incourseF.setVisible(true);
        frameTea.add(incourseF);
        incourseF.setBorder(border);
        
        
        
        
        
        
        // final
        // final label
        JLabel finalL = new JLabel("Final Mark");
        // positioning variables
        int finalLX = 50, finalLY = 290, finalLW = 100, finalLH = 20;
        finalL.setBounds(finalLX, finalLY, finalLW, finalLH);
        finalL.setFont(new Font("Arial", Font.BOLD, 15));
        finalL.setVisible(true);
        frameTea.add(finalL);
        finalL.setBorder(border);
        // incourse field
        JTextField finalF = new JTextField();
        // positioning variables
        int finalFX = 195, finalFY = 290, finalFW = 150, finalFH = 20;
        finalF.setBounds(finalFX, finalFY, finalFW, finalFH);
        finalF.setVisible(true);
        frameTea.add(finalF);
        finalF.setBorder(border);
        
        // other
        // other label
        JLabel otherL = new JLabel("Other Mark");
        // positioning variables
        int otherLX = 50, otherLY = 330, otherLW = 100, otherLH = 20;
        otherL.setBounds(otherLX, otherLY, otherLW, otherLH);
        otherL.setFont(new Font("Arial", Font.BOLD, 15));
        otherL.setVisible(true);
        frameTea.add(otherL);
        otherL.setBorder(border);
        // other field
        JTextField otherF = new JTextField();
        // positioning variables
        int otherFX = 195, otherFY = 330, otherFW = 150, otherFH = 20;
        otherF.setBounds(otherFX, otherFY, otherFW, otherFH);
        incourseF.setVisible(true);
        frameTea.add(otherF);
        otherF.setBorder(border);
        
        // calculate button
        JButton calTea1 = new JButton("Calculate");
        int calTea1X = 50, calTea1Y = 370, calTea1W = 300, calTea1H = 30;
        calTea1.setBounds(calTea1X, calTea1Y, calTea1W, calTea1H);
        calTea1.setVisible(true);
        frameTea.add(calTea1);
        calTea1.setBorder(border);
        
        // action listener with calculate button
        calTea1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // getting data from the field
                String batch, courseNo, courseTitle, semester, roll, incourse, fina, other;
                batch = batchF.getText();
                courseNo = courseF.getText();
                courseTitle = courseTF.getText();
                semester = semF.getText();
                roll = rollF.getText();
                incourse = incourseF.getText();
                fina = finalF.getText();
                other = otherF.getText();
                
                // checking if all the fields have data
                if (isContainData(batch, courseNo, courseTitle, semester, roll, incourse, fina, other) == false) {
                    JOptionPane.showMessageDialog(frameTea, "Please Provide All Information!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // convering marks into integer
                    int incourseInt = Integer.parseInt(incourse);
                    int finaInt = Integer.parseInt(fina);
                    int otherInt = Integer.parseInt(other);
                    
                    // creating Grade object to calculate grade 
                    Grade gradeObj = new Grade();
                    // setting up the generator
                    gradeObj.setMark(incourseInt, otherInt, finaInt);
                    // getting required data
                    String gradeLetter = gradeObj.gradeLetter();
                    String gradePoint = Float.toString(gradeObj.gradePoint());
                    
                    // export data into confirmation page
                    TeacherConfirmPage teach2Obj = new TeacherConfirmPage();
                    teach2Obj.previousPageFrame(frameTea);
                    teach2Obj.teacherconfirmpage(incourse, other, fina, batch, courseNo, courseTitle, semester, roll, gradeLetter, gradePoint);
                    
                    // hiding this input field
                    frameTea.setVisible(false);
                }
                // export into Teacher Confirmation class
            }
        });
    }
    
    private boolean isContainData(String...arr) {
        boolean status = true;
        for (String s: arr) {
            if (s.compareTo("") == 0) {
                status = false;
                break;
            }
        }
        return status;
    }
}
