package gui;

import database.Database;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gradecalculation.Grade;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author mursalatul
 */
public class TeacherInputPage {

    public void teacher(JFrame frameLogin, JPasswordField passField) {
        JFrame frameTea = new JFrame();
        frameTea.setSize(400, 560);
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

        // positioning variables(change here and bellow elements will auto
        // change position)
        final int upperGap = 70;

        // batch
        // batch label
        JLabel batchL = new JLabel("Batch");
        // positioning variables
        int batchLX = 50, batchLY = upperGap, batchLW = 50, batchLH = 20;
        batchL.setBounds(batchLX, batchLY, batchLW, batchLH);
        batchL.setFont(new Font("Arial", Font.BOLD, 15));
        batchL.setVisible(true);
        frameTea.add(batchL);
        batchL.setBorder(border);
        // batch field
        JTextField batchF = new JTextField();
        // positioning variables
        int batchFX = 195, batchFY = batchLY, batchFW = 150, batchFH = 20;
        batchF.setBounds(batchFX, batchFY, batchFW, batchFH);
        batchF.setVisible(true);
        frameTea.add(batchF);
        batchF.setBorder(border);

        // Semester
        // Semester label
        JLabel semL = new JLabel("Semester");
        // positioning variables
        int semLX = 50, semLY = batchFY + 40, semLW = 100, semLH = 20;
        semL.setBounds(semLX, semLY, semLW, semLH);
        semL.setFont(new Font("Arial", Font.BOLD, 15));
        semL.setVisible(true);
        frameTea.add(semL);
        semL.setBorder(border);
        // semester field
        JTextField semF = new JTextField();
        // positioning variables
        int semFX = 195, semFY = semLY, semFW = 150, semFH = 20;
        semF.setBounds(semFX, semFY, semFW, semFH);
        semF.setVisible(true);
        frameTea.add(semF);
        semF.setBorder(border);

        // roll
        // roll label
        JLabel rollL = new JLabel("Roll");
        // positioning variables
        int rollLX = 50, rollLY = semLY + 40, rollLW = 100, rollLH = 20;
        rollL.setBounds(rollLX, rollLY, rollLW, rollLH);
        rollL.setFont(new Font("Arial", Font.BOLD, 15));
        rollL.setVisible(true);
        frameTea.add(rollL);
        rollL.setBorder(border);
        // roll field
        JTextField rollF = new JTextField();
        // positioning variables
        int rollFX = 195, rollFY = rollLY, rollFW = 150, rollFH = 20;
        rollF.setBounds(rollFX, rollFY, rollFW, rollFH);
        rollF.setVisible(true);
        frameTea.add(rollF);
        rollF.setBorder(border);

        // show result of the batch -> semester -> roll(start)
        //
        // 
        // show button
        JButton showResB = new JButton();
        showResB.setText("Show CGPA");
        int b1X = 50, b1Y = rollFY + 40, b1W = 100, b1H = 30;
        showResB.setBounds(b1X, b1Y, b1W, b1H);
        showResB.setFont(new Font("Arial", Font.BOLD, 15));
        showResB.setVisible(true);
        frameTea.add(showResB);
        showResB.setBorder(border);
        

        // heading of semester wise cgpa show
        // "grade letter" text(beside "See CGPA" text)
        JLabel gLHeading = new JLabel();
        gLHeading.setText("Grade Letter");
        gLHeading.setBounds(180, b1Y, 80, 20);
        gLHeading.setFont(new Font("Arial", Font.BOLD, 12));
        gLHeading.setVisible(true);
        frameTea.add(gLHeading);
        gLHeading.setBorder(border);

        // "grade point" text(beside "See CGPA" text)
        JLabel gPHeading = new JLabel();
        gPHeading.setText("Grade Point");
        gPHeading.setBounds(290, b1Y, 74, 20);
        gPHeading.setFont(new Font("Arial", Font.BOLD, 12));
        gPHeading.setVisible(true);
        frameTea.add(gPHeading);
        gPHeading.setBorder(border);

        // attribute for avg cgpa showing label
        int bW = 50, bH = 30;
        Border borderBox = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        // average grade letter
        JLabel avgGLL = new JLabel("x");
        avgGLL.setBounds(200, b1Y + 20, bW, bH);
        avgGLL.setFont(new Font("Arial", Font.BOLD, 15));
        avgGLL.setVisible(true);
        frameTea.add(avgGLL);
        avgGLL.setHorizontalAlignment(SwingConstants.CENTER);
        avgGLL.setBorder(borderBox);

        // average grade point
        JLabel avgGPL = new JLabel("x");
        avgGPL.setBounds(300, b1Y + 20, bW, bH);
        avgGPL.setFont(new Font("Arial", Font.BOLD, 15));
        avgGPL.setVisible(true);
        frameTea.add(avgGPL);
        avgGPL.setHorizontalAlignment(SwingConstants.CENTER);
        avgGPL.setBorder(borderBox);

        // action listener of showResB button
        // get last avg grade letter and point from roll(Database) and semesterx table
        showResB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // checking if batch semester and roll field in given
                if (batchF.getText().length() > 0 && semF.getText().length() > 0 && rollF.getText().length() > 0) {
                    // getting batch semester and roll
                    String batch = batchF.getText();
                    String semester = "semester"+semF.getText(); // 1 -> semester1
                    String roll = rollF.getText();
                    
                    
                    // connecting roll database
                    Database dbObj = new Database();
                    dbObj.connect(roll);
                    
                    ResultSet allData = dbObj.getData(semester);

                    // last average grade letter and point
                    String avgGL = "", avgGP = "";
                    try {
                        while (allData.next()) {
                            avgGL = allData.getString("Avg Grade Letter");
                            avgGP = allData.getString("Avg Grade Point");
                        }
                    } catch (SQLException e2) {
                        System.out.println("Error(File: StudentMain, reading roll database, semester table):" + e2.getMessage());
                    }

                    System.out.println(avgGL + " " + avgGP);

                    // print avgGL and avgGP after the button
                    avgGLL.setText(avgGL);
                    avgGPL.setText(avgGP);
                } 
                else {
                    JOptionPane.showMessageDialog(frameTea, "Must Give Batch, Semester and Roll", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        //
        //
        // show result of the batch -> semester -> roll(end)
        
        // Course
        // Course label
        JLabel courseL = new JLabel("Course No");
        // positioning variables
        int courseLX = 50, courseLY = rollFY + 120, courseLW = 100, courseLH = 20;
        courseL.setBounds(courseLX, courseLY, courseLW, courseLH);
        courseL.setFont(new Font("Arial", Font.BOLD, 15));
        courseL.setVisible(true);
        frameTea.add(courseL);
        courseL.setBorder(border);
        // course field
        JTextField courseF = new JTextField();
        // positioning variables
        int courseFX = 195, courseFY = courseLY, courseFW = 150, courseFH = 20;
        courseF.setBounds(courseFX, courseFY, courseFW, courseFH);
        courseF.setVisible(true);
        frameTea.add(courseF);
        courseF.setBorder(border);

        // Course Title
        // CourseT label
        JLabel courseTL = new JLabel("Course Title");
        // positioning variables
        int courseTLX = 50, courseTLY = courseFY + 40, courseTLW = 100, courseTLH = 20;
        courseTL.setBounds(courseTLX, courseTLY, courseTLW, courseTLH);
        courseTL.setFont(new Font("Arial", Font.BOLD, 15));
        courseTL.setVisible(true);
        frameTea.add(courseTL);
        courseTL.setBorder(border);
        // courseT field
        JTextField courseTF = new JTextField();
        // positioning variables
        int courseTFX = 195, courseTFY = courseTLY, courseTFW = 150, courseTFH = 20;
        courseTF.setBounds(courseTFX, courseTFY, courseTFW, courseTFH);
        courseTF.setVisible(true);
        frameTea.add(courseTF);
        courseTF.setBorder(border);

        // incourse
        // incourse label
        JLabel incourseL = new JLabel("Incourse Mark");
        // positioning variables
        int incourseLX = 50, incourseLY = courseTFY + 40, incourseLW = 100, incourseLH = 20;
        incourseL.setBounds(incourseLX, incourseLY, incourseLW, incourseLH);
        incourseL.setFont(new Font("Arial", Font.BOLD, 15));
        incourseL.setVisible(true);
        frameTea.add(incourseL);
        incourseL.setBorder(border);
        // incourse field
        JTextField incourseF = new JTextField();
        // positioning variables
        int incourseFX = 195, incourseFY = incourseLY, incourseFW = 150, incourseFH = 20;
        incourseF.setBounds(incourseFX, incourseFY, incourseFW, incourseFH);
        incourseF.setVisible(true);
        frameTea.add(incourseF);
        incourseF.setBorder(border);

        // final
        // final label
        JLabel finalL = new JLabel("Final Mark");
        // positioning variables
        int finalLX = 50, finalLY = incourseFY + 40, finalLW = 100, finalLH = 20;
        finalL.setBounds(finalLX, finalLY, finalLW, finalLH);
        finalL.setFont(new Font("Arial", Font.BOLD, 15));
        finalL.setVisible(true);
        frameTea.add(finalL);
        finalL.setBorder(border);
        // incourse field
        JTextField finalF = new JTextField();
        // positioning variables
        int finalFX = 195, finalFY = finalLY, finalFW = 150, finalFH = 20;
        finalF.setBounds(finalFX, finalFY, finalFW, finalFH);
        finalF.setVisible(true);
        frameTea.add(finalF);
        finalF.setBorder(border);

        // other
        // other label
        JLabel otherL = new JLabel("Other Mark");
        // positioning variables
        int otherLX = 50, otherLY = finalFY + 40, otherLW = 100, otherLH = 20;
        otherL.setBounds(otherLX, otherLY, otherLW, otherLH);
        otherL.setFont(new Font("Arial", Font.BOLD, 15));
        otherL.setVisible(true);
        frameTea.add(otherL);
        otherL.setBorder(border);
        // other field
        JTextField otherF = new JTextField();
        // positioning variables
        int otherFX = 195, otherFY = otherLY, otherFW = 150, otherFH = 20;
        otherF.setBounds(otherFX, otherFY, otherFW, otherFH);
        incourseF.setVisible(true);
        frameTea.add(otherF);
        otherF.setBorder(border);

        // calculate button
        JButton calTea1 = new JButton("Calculate");
        int calTea1X = 50, calTea1Y = otherFY + 40, calTea1W = 300, calTea1H = 30;
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
                } else {
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
        
        // logout button
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 13));
        logoutBtn.setBounds(50, 510, 80, 20);
        logoutBtn.setVisible(true);
        logoutBtn.setBorder(border);
        logoutBtn.setBackground(Color.CYAN);
        frameTea.add(logoutBtn);
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // deleting this teacher frame.
                frameTea.dispose();
                // opening the login field again and clearing the password
                passField.setText("");
                frameLogin.setVisible(true);
            }
        });
        
        // exit application.
        JButton exitBtn = new JButton("EXIT");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 13));
        exitBtn.setBounds(270, 510, 80, 20);
        exitBtn.setVisible(true);
        exitBtn.setBorder(border);
        exitBtn.setBackground(Color.RED);
        frameTea.add(exitBtn);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private boolean isContainData(String... arr) {
        boolean status = true;
        for (String s : arr) {
            if (s.compareTo("") == 0) {
                status = false;
                break;
            }
        }
        return status;
    }
}
