package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList; // for storing all the grade points

import database.Database;
import gradecalculation.Grade;
import dataverification.InputVerification;

/**
 *
 * @author mursalatul
 */
public class StudentMain {

    public void studentmain(String roll, JFrame frameLogin, JPasswordField passField) {
        JFrame frameStu = new JFrame();
        frameStu.setSize(600, 850);
        frameStu.setResizable(false);
        frameStu.setLayout(null);
        frameStu.setVisible(true);
        frameStu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 0);
        // use this border to indicate that, the data of this component is invalid
        Border redHighLightBorder = BorderFactory.createLineBorder(Color.RED, 1);

        // window heading
        JLabel heading = new JLabel("<html><u>CGPA Calculator</u></html>");
        // change the value for positioning
        int headingX = 190, headingY = 5, headingW = 220, headingH = 30;
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        heading.setBounds(headingX, headingY, headingW, headingH);
        heading.setVisible(true);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        frameStu.add(heading);
        heading.setBorder(border);

        // getting name, batch, roll
        Database baseInfo = new Database();
        baseInfo.connect("student_info");
        ResultSet infoLocation = baseInfo.getData("sinfo");
        String fullName = "USER NOT AVAILABLE", batch = "USER NOT AVAILABLE", storeRoll;
        try {
            while (infoLocation.next()) {
                fullName = infoLocation.getString("Name");
                batch = infoLocation.getString("Batch");
                storeRoll = infoLocation.getString("Roll");
                if (storeRoll.compareTo(roll) == 0) {
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error(File StudentMain):" + e.getMessage());
        }

        System.out.println(fullName + " " + batch + " " + roll);

        // show full name
        JLabel fNameL = new JLabel();
        fNameL.setText(fullName);
        int fNameLX = 50, fNameLY = 50, fNameLW = 400, fNameLH = 30;
        fNameL.setBounds(fNameLX, fNameLY, fNameLW, fNameLH);
        fNameL.setFont(new Font("Arial", Font.BOLD, 15));
        fNameL.setVisible(true);
        frameStu.add(fNameL);
        fNameL.setBorder(border);

        // show batch
        JLabel batchL = new JLabel();
        batchL.setText(batch);
        int batchLX = 50, batchLY = 90, batchLW = 100, batchLH = 30;
        batchL.setBounds(batchLX, batchLY, batchLW, batchLH);
        batchL.setFont(new Font("Arial", Font.BOLD, 10));
        batchL.setVisible(true);
        frameStu.add(batchL);
        batchL.setBorder(border);

        // show roll
        JLabel rollL = new JLabel();
        rollL.setText("Roll: " + roll);
        int rollLX = 100, rollLY = 90, rollLW = 100, rollLH = 30;
        rollL.setBounds(rollLX, rollLY, rollLW, rollLH);
        rollL.setFont(new Font("Arial", Font.BOLD, 10));
        rollL.setVisible(true);
        frameStu.add(rollL);
        rollL.setBorder(border);

        // "see cgpa" text
        JLabel l1 = new JLabel();
        l1.setText("See CGPA");
        int l1X = 50, l1Y = 120, l1W = 100, l1H = 30;
        l1.setBounds(l1X, l1Y, l1W, l1H);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.setVisible(true);
        frameStu.add(l1);
        l1.setBorder(border);

        // heading of semester wise cgpa show
        // "grade letter" text(beside "See CGPA" text)
        JLabel gLHeading = new JLabel();
        gLHeading.setText("Grade Letter");
        gLHeading.setBounds(380, 120, 80, 20);
        gLHeading.setFont(new Font("Arial", Font.BOLD, 12));
        gLHeading.setVisible(true);
        frameStu.add(gLHeading);
        gLHeading.setBorder(border);

        // "grade point" text(beside "See CGPA" text)
        JLabel gPHeading = new JLabel();
        gPHeading.setText("Grade Point");
        gPHeading.setBounds(475, 120, 74, 20);
        gPHeading.setFont(new Font("Arial", Font.BOLD, 12));
        gPHeading.setVisible(true);
        frameStu.add(gPHeading);
        gPHeading.setBorder(border);

        // semester dropbox
        // drop box for selecting login as student or teacher
        String[] options = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8", "Semester 9", "Semester 10", "Semester 11", "Semester 12"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(50, 160, 150, 30);
        dropdown.setVisible(true);
        frameStu.add(dropdown);
        dropdown.setBorder(border);

        // show button
        JButton b1 = new JButton();
        b1.setText("Show");
        int b1X = 250, b1Y = 160, b1W = 100, b1H = 30;
        b1.setBounds(b1X, b1Y, b1W, b1H);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setVisible(true);
        frameStu.add(b1);
        b1.setBorder(border);

        // attribute for avg cgpa showing label
        int bW = 50, bH = 30;
        Border borderBox = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        // average grade letter
        JLabel avgGLL = new JLabel("x");
        avgGLL.setBounds(395, 160, bW, bH);
        avgGLL.setFont(new Font("Arial", Font.BOLD, 15));
        avgGLL.setVisible(true);
        frameStu.add(avgGLL);
        avgGLL.setHorizontalAlignment(SwingConstants.CENTER);
        avgGLL.setBorder(borderBox);

        // average grade point
        JLabel avgGPL = new JLabel("x");
        avgGPL.setBounds(485, 160, bW, bH);
        avgGPL.setFont(new Font("Arial", Font.BOLD, 15));
        avgGPL.setVisible(true);
        frameStu.add(avgGPL);
        avgGPL.setHorizontalAlignment(SwingConstants.CENTER);
        avgGPL.setBorder(borderBox);

        // get last avg grade letter and point from roll(Database) and semesterx table
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // connecting roll database
                Database dbObj = new Database();
                dbObj.connect(roll);

                // getting all the datas of selected semester's
                String semester = (String) dropdown.getSelectedItem();
                semester = reformatSemesterName(semester);
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
        });

        // "calculate cgpa" text
        JLabel l2 = new JLabel();
        l2.setText("Calculate CGPA");
        int l2X = 50, l2Y = 210, l2W = 150, l2H = 30;
        l2.setBounds(l2X, l2Y, l2W, l2H);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setVisible(true);
        frameStu.add(l2);
        l2.setBorder(border);

        // "course no" text
        JLabel l3 = new JLabel();
        l3.setText("Course No");
        int l3X = 55, l3Y = 260, l3W = 55, l3H = 30;
        l3.setBounds(l3X, l3Y, l3W, l3H);
        l3.setFont(new Font("Arial", Font.BOLD, 10));
        l3.setVisible(true);
        frameStu.add(l3);
        l3.setBorder(border);

        // "incourse + other" text
        JLabel l4 = new JLabel("Incourse+");
        JLabel l4_2 = new JLabel("Other");
        int l4X = 130, l4Y = 260, l4W = 65, l4H = 20;
        l4.setBounds(l4X, l4Y, l4W, l4H);
        l4_2.setBounds(l4X, l4Y + 20, l4W, l4H);
        l4.setFont(new Font("Arial", Font.BOLD, 10));
        l4_2.setFont(new Font("Arial", Font.BOLD, 10));
        l4.setVisible(true);
        l4_2.setVisible(true);
        frameStu.add(l4);
        frameStu.add(l4_2);
        l4.setBorder(border);
        l4_2.setBorder(border);

        // "Final" text
        JLabel l5 = new JLabel();
        l5.setText("Final");
        int l5X = 220, l5Y = 260, l5W = 27, l5H = 30;
        l5.setBounds(l5X, l5Y, l5W, l5H);
        l5.setFont(new Font("Arial", Font.BOLD, 10));
        l5.setVisible(true);
        frameStu.add(l5);
        l5.setBorder(border);

        // "grade letter" text
        JLabel l6 = new JLabel();
        l6.setText("Grade Letter");
        int l6X = 320, l6Y = 260, l6W = 100, l6H = 30;
        l6.setBounds(l6X, l6Y, l6W, l6H);
        l6.setFont(new Font("Arial", Font.BOLD, 14));
        l6.setVisible(true);
        frameStu.add(l6);
        l6.setBorder(border);

        // "grade point" text
        JLabel l7 = new JLabel();
        l7.setText("Grade Point");
        int l7X = 450, l7Y = 260, l7W = 100, l7H = 30;
        l7.setBounds(l7X, l7Y, l7W, l7H);
        l7.setFont(new Font("Arial", Font.BOLD, 14));
        l7.setVisible(true);
        frameStu.add(l7);
        l7.setBorder(border);

        // field's properties
        // field width
        int fW = 70, fH = 40;

        // row 1
        // field f11
        JTextField f11 = new JTextField();
        int f11X = 50, f11Y = 300;
        f11.setBounds(f11X, f11Y, fW, fH);
        f11.setFont(new Font("Arial", Font.BOLD, 14));
        f11.setVisible(true);
        frameStu.add(f11);
        f11.setBorder(border);

        // field f12
        JTextField f12 = new JTextField();
        int f12X = 125, f12Y = f11Y;
        f12.setBounds(f12X, f12Y, fW, fH);
        f12.setFont(new Font("Arial", Font.BOLD, 14));
        f12.setVisible(true);
        frameStu.add(f12);
        f12.setBorder(border);

        // field f13
        JTextField f13 = new JTextField();
        int f13X = 200, f13Y = f11Y;
        f13.setBounds(f13X, f13Y, fW, fH);
        f13.setFont(new Font("Arial", Font.BOLD, 14));
        f13.setVisible(true);
        frameStu.add(f13);
        f13.setBorder(border);

        // grade letter label 1
        JLabel gL1 = new JLabel("x");
        int gL1X = 355, gL1Y = f11Y;
        gL1.setBounds(gL1X, gL1Y, fW, fH);
        gL1.setFont(new Font("Arial", Font.BOLD, 14));
        gL1.setVisible(true);
        frameStu.add(gL1);
        gL1.setBorder(border);

        // grade point label 1
        JLabel gP1 = new JLabel("0.00");
        int gP1X = 480, gP1Y = f11Y;
        gP1.setBounds(gP1X, gP1Y, fW, fH);
        gP1.setFont(new Font("Arial", Font.BOLD, 14));
        gP1.setVisible(true);
        frameStu.add(gP1);
        gP1.setBorder(border);

        // row 2
        // field f21
        JTextField f21 = new JTextField();
        int f21X = 50, f21Y = 350;
        f21.setBounds(f21X, f21Y, fW, fH);
        f21.setFont(new Font("Arial", Font.BOLD, 14));
        f21.setVisible(true);
        frameStu.add(f21);
        f21.setBorder(border);

        // field f22
        JTextField f22 = new JTextField();
        int f22X = 125, f22Y = f21Y;
        f22.setBounds(f22X, f22Y, fW, fH);
        f22.setFont(new Font("Arial", Font.BOLD, 14));
        f22.setVisible(true);
        frameStu.add(f22);
        f22.setBorder(border);

        // field f23
        JTextField f23 = new JTextField();
        int f23X = 200, f23Y = f21Y;
        f23.setBounds(f23X, f23Y, fW, fH);
        f23.setFont(new Font("Arial", Font.BOLD, 14));
        f23.setVisible(true);
        frameStu.add(f23);
        f23.setBorder(border);

        // grade letter label 2
        JLabel gL2 = new JLabel("x");
        int gL2X = 355, gL2Y = f21Y;
        gL2.setBounds(gL2X, gL2Y, fW, fH);
        gL2.setFont(new Font("Arial", Font.BOLD, 14));
        gL2.setVisible(true);
        frameStu.add(gL2);
        gL2.setBorder(border);

        // grade point label 2
        JLabel gP2 = new JLabel("0.00");
        int gP2X = 480, gP2Y = f21Y;
        gP2.setBounds(gP2X, gP2Y, fW, fH);
        gP2.setFont(new Font("Arial", Font.BOLD, 14));
        gP2.setVisible(true);
        frameStu.add(gP2);
        gP2.setBorder(border);

        // row 3
        // field f31
        JTextField f31 = new JTextField();
        int f31X = 50, f31Y = 400;
        f31.setBounds(f31X, f31Y, fW, fH);
        f31.setFont(new Font("Arial", Font.BOLD, 14));
        f31.setVisible(true);
        frameStu.add(f31);
        f31.setBorder(border);

        // field f32
        JTextField f32 = new JTextField();
        int f32X = 125, f32Y = f31Y;
        f32.setBounds(f32X, f32Y, fW, fH);
        f32.setFont(new Font("Arial", Font.BOLD, 14));
        f32.setVisible(true);
        frameStu.add(f32);
        f32.setBorder(border);

        // field f33
        JTextField f33 = new JTextField();
        int f33X = 200, f33Y = f31Y;
        f33.setBounds(f33X, f33Y, fW, fH);
        f33.setFont(new Font("Arial", Font.BOLD, 14));
        f33.setVisible(true);
        frameStu.add(f33);
        f33.setBorder(border);

        // grade letter label 3
        JLabel gL3 = new JLabel("x");
        int gL3X = 355, gL3Y = f31Y;
        gL3.setBounds(gL3X, gL3Y, fW, fH);
        gL3.setFont(new Font("Arial", Font.BOLD, 14));
        gL3.setVisible(true);
        frameStu.add(gL3);
        gL3.setBorder(border);

        // grade point label 3
        JLabel gP3 = new JLabel("0.00");
        int gP3X = 480, gP3Y = f31Y;
        gP3.setBounds(gP3X, gP3Y, fW, fH);
        gP3.setFont(new Font("Arial", Font.BOLD, 14));
        gP3.setVisible(true);
        frameStu.add(gP3);
        gP3.setBorder(border);

        // row 4
        // field f41
        JTextField f41 = new JTextField();
        int f41X = 50, f41Y = 450;
        f41.setBounds(f41X, f41Y, fW, fH);
        f41.setFont(new Font("Arial", Font.BOLD, 14));
        f41.setVisible(true);
        frameStu.add(f41);
        f41.setBorder(border);

        // field f42
        JTextField f42 = new JTextField();
        int f42X = 125, f42Y = f41Y;
        f42.setBounds(f42X, f42Y, fW, fH);
        f42.setFont(new Font("Arial", Font.BOLD, 14));
        f42.setVisible(true);
        frameStu.add(f42);
        f42.setBorder(border);

        // field f43
        JTextField f43 = new JTextField();
        int f43X = 200, f43Y = f41Y;
        f43.setBounds(f43X, f43Y, fW, fH);
        f43.setFont(new Font("Arial", Font.BOLD, 14));
        f43.setVisible(true);
        frameStu.add(f43);
        f43.setBorder(border);

        // grade letter label 4
        JLabel gL4 = new JLabel("x");
        int gL4X = 355, gL4Y = f41Y;
        gL4.setBounds(gL4X, gL4Y, fW, fH);
        gL4.setFont(new Font("Arial", Font.BOLD, 14));
        gL4.setVisible(true);
        frameStu.add(gL4);
        gL4.setBorder(border);

        // grade point label 4
        JLabel gP4 = new JLabel("0.00");
        int gP4X = 480, gP4Y = f41Y;
        gP4.setBounds(gP4X, gP4Y, fW, fH);
        gP4.setFont(new Font("Arial", Font.BOLD, 14));
        gP4.setVisible(true);
        frameStu.add(gP4);
        gP4.setBorder(border);

        // row 5
        // field f51
        JTextField f51 = new JTextField();
        int f51X = 50, f51Y = 500;
        f51.setBounds(f51X, f51Y, fW, fH);
        f51.setFont(new Font("Arial", Font.BOLD, 14));
        f51.setVisible(true);
        frameStu.add(f51);
        f51.setBorder(border);

        // field f52
        JTextField f52 = new JTextField();
        int f52X = 125, f52Y = f51Y;
        f52.setBounds(f52X, f52Y, fW, fH);
        f52.setFont(new Font("Arial", Font.BOLD, 14));
        f52.setVisible(true);
        frameStu.add(f52);
        f52.setBorder(border);

        // field f53
        JTextField f53 = new JTextField();
        int f53X = 200, f53Y = f51Y;
        f53.setBounds(f53X, f53Y, fW, fH);
        f53.setFont(new Font("Arial", Font.BOLD, 14));
        f53.setVisible(true);
        frameStu.add(f53);
        f53.setBorder(border);

        // grade letter label 5
        JLabel gL5 = new JLabel("x");
        int gL5X = 355, gL5Y = f51Y;
        gL5.setBounds(gL5X, gL5Y, fW, fH);
        gL5.setFont(new Font("Arial", Font.BOLD, 14));
        gL5.setVisible(true);
        frameStu.add(gL5);
        gL5.setBorder(border);

        // grade point label 5
        JLabel gP5 = new JLabel("0.00");
        int gP5X = 480, gP5Y = f51Y;
        gP5.setBounds(gP5X, gP5Y, fW, fH);
        gP5.setFont(new Font("Arial", Font.BOLD, 14));
        gP5.setVisible(true);
        frameStu.add(gP5);
        gP5.setBorder(border);

        // row 6
        // field f61
        JTextField f61 = new JTextField();
        int f61X = 50, f61Y = 550;
        f61.setBounds(f61X, f61Y, fW, fH);
        f61.setFont(new Font("Arial", Font.BOLD, 14));
        f61.setVisible(true);
        frameStu.add(f61);
        f61.setBorder(border);

        // field f62
        JTextField f62 = new JTextField();
        int f62X = 125, f62Y = f61Y;
        f62.setBounds(f62X, f62Y, fW, fH);
        f62.setFont(new Font("Arial", Font.BOLD, 14));
        f62.setVisible(true);
        frameStu.add(f62);
        f62.setBorder(border);

        // field f63
        JTextField f63 = new JTextField();
        int f63X = 200, f63Y = f61Y;
        f63.setBounds(f63X, f63Y, fW, fH);
        f63.setFont(new Font("Arial", Font.BOLD, 14));
        f63.setVisible(true);
        frameStu.add(f63);
        f63.setBorder(border);

        // grade letter label 6
        JLabel gL6 = new JLabel("x");
        int gL6X = 355, gL6Y = f61Y;
        gL6.setBounds(gL6X, gL6Y, fW, fH);
        gL6.setFont(new Font("Arial", Font.BOLD, 14));
        gL6.setVisible(true);
        frameStu.add(gL6);
        gL6.setBorder(border);

        // grade point label 6
        JLabel gP6 = new JLabel("0.00");
        int gP6X = 480, gP6Y = f61Y;
        gP6.setBounds(gP6X, gP6Y, fW, fH);
        gP6.setFont(new Font("Arial", Font.BOLD, 14));
        gP6.setVisible(true);
        frameStu.add(gP6);
        gP6.setBorder(border);

        // "Average" label
        JLabel avgL = new JLabel("Average:");
        avgL.setBounds(230, 600, 70, 50);
        avgL.setVisible(true);
        avgL.setFont(new Font("Arial", Font.BOLD, 15));
        avgL.setBorder(border);
        frameStu.add(avgL);

        // grade letter label final
        JLabel gLFinal = new JLabel("x");
        int gLFinalX = 355, gLFinalY = 600;
        gLFinal.setBounds(gLFinalX, gLFinalY, fW, fH);
        gLFinal.setFont(new Font("Arial", Font.BOLD, 15));
        gLFinal.setVisible(true);
        frameStu.add(gLFinal);
        gLFinal.setBorder(border);

        // grade point label final
        JLabel gPFinal = new JLabel("0.00");
        int gPFinalX = 480, gPFinalY = 600;
        gPFinal.setBounds(gPFinalX, gPFinalY, fW, fH);
        gPFinal.setFont(new Font("Arial", Font.BOLD, 15));
        gPFinal.setVisible(true);
        frameStu.add(gPFinal);
        gPFinal.setBorder(border);

        // calculate & clear button
        JButton calBtn = new JButton("Calculate");
        JButton clrBtn = new JButton("Clear");

        calBtn.setFont(new Font("Arial", Font.BOLD, 16));
        clrBtn.setFont(new Font("Arial", Font.BOLD, 16));

        int btnX = 50, btnY = 600, btnW = 80, btnH = 50;
        calBtn.setBounds(btnX, btnY, btnW, btnH);
        clrBtn.setBounds(btnX + 90, btnY, btnW, btnH);

        calBtn.setVisible(true);
        clrBtn.setVisible(true);
        calBtn.setBorder(border);
        clrBtn.setBorder(border);

        calBtn.setBackground(Color.CYAN);
        clrBtn.setBackground(Color.CYAN);

        frameStu.add(calBtn);
        frameStu.add(clrBtn);

        // clear all the data from fields and set labels to its default state
        clrBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // clearing fields
                f11.setText("");
                f12.setText("");
                f13.setText("");
                f21.setText("");
                f22.setText("");
                f23.setText("");
                f31.setText("");
                f32.setText("");
                f33.setText("");
                f41.setText("");
                f42.setText("");
                f43.setText("");
                f51.setText("");
                f52.setText("");
                f53.setText("");
                f61.setText("");
                f62.setText("");
                f63.setText("");

                // setting label to its default state
                String defaultgL = "x";
                String defaultgP = "0.00";
                gL1.setText(defaultgL);
                gP1.setText(defaultgP);
                gL2.setText(defaultgL);
                gP2.setText(defaultgP);
                gL3.setText(defaultgL);
                gP3.setText(defaultgP);
                gL4.setText(defaultgL);
                gP4.setText(defaultgP);
                gL5.setText(defaultgL);
                gP5.setText(defaultgP);
                gL6.setText(defaultgL);
                gP6.setText(defaultgP);

                gLFinal.setText(defaultgL);
                gPFinal.setText(defaultgP);

            }
        });

        // calculate grade Letter and grade Point of each row and place them in
        // the corresponding gL gP
        /*
        f11 f12 f13 gL1 gP1
        f21 f22 f23 gL2 gp2
        f31 f32 f33 gL3 gp3
        f41 f42 f43 gL4 gp4
        f51 f52 f53 gL5 gp5
        f61 f62 f63 gL6 gp6
                    gLFinal gPFinal
        
        
         */
        calBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Grade grade = new Grade();

                // store all the points
                ArrayList<Float> allPoints = new ArrayList<>();

                // calculate row 1
                if (f11.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f12.getText();
                    String finaStr = f13.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f12.setBorder(border); // clearing red border(if any)
                    } else {
                        f12.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f13.setBorder(border); // clearing red border(if any)
                    } else {
                        f13.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL1.setText(gL);
                            gP1.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // calculate row 2
                if (f21.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f22.getText();
                    String finaStr = f23.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f22.setBorder(border); // clearing red border(if any)
                    } else {
                        f22.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f23.setBorder(border); // clearing red border(if any)
                    } else {
                        f23.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL2.setText(gL);
                            gP2.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // calculate row 3
                if (f31.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f32.getText();
                    String finaStr = f33.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f32.setBorder(border); // clearing red border(if any)
                    } else {
                        f32.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f33.setBorder(border); // clearing red border(if any)
                    } else {
                        f33.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL3.setText(gL);
                            gP3.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // calculate row 4
                if (f41.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f42.getText();
                    String finaStr = f43.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f42.setBorder(border); // clearing red border(if any)
                    } else {
                        f42.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f43.setBorder(border); // clearing red border(if any)
                    } else {
                        f43.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL4.setText(gL);
                            gP4.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // calculate row 5
                if (f51.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f52.getText();
                    String finaStr = f53.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f52.setBorder(border); // clearing red border(if any)
                    } else {
                        f52.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f53.setBorder(border); // clearing red border(if any)
                    } else {
                        f53.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL5.setText(gL);
                            gP5.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // calculate row 6
                if (f61.getText().length() > 3) {
                    // getting inputed data
                    String incourseStr = f62.getText();
                    String finaStr = f63.getText();

                    // verifying inputed data
                    // getting the data condition
                    boolean incourseMarkStatus = InputVerification.isNumber(incourseStr);
                    boolean finaMarkStatus = InputVerification.isNumber(finaStr);

                    // setting up the border
                    if (incourseMarkStatus) {
                        f62.setBorder(border); // clearing red border(if any)
                    } else {
                        f62.setBorder(redHighLightBorder); // add red border
                    }

                    if (finaMarkStatus) {
                        f63.setBorder(border); // clearing red border(if any)
                    } else {
                        f63.setBorder(redHighLightBorder); // add red border
                    }

                    if (incourseMarkStatus && finaMarkStatus) {
                        // converting the numbers into integer number
                        int incourse = Integer.parseInt(incourseStr);
                        int fina = Integer.parseInt(finaStr);

                        // check if the incourse & final marks are less or equal to 50
                        if (incourse <= 50 && fina <= 50) {
                            // calculating letter and point
                            grade.setMark(incourse, fina, 0);
                            String gL = grade.gradeLetter();
                            float p = grade.gradePoint();
                            allPoints.add(p);
                            String gP = Float.toString(p);
                            // putting result on frame
                            gL6.setText(gL);
                            gP6.setText(gP);
                        } else {
                            // show marks should be in 0-50
                            JOptionPane.showMessageDialog(frameStu, "Marks should be in 0-50", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // show error message
                        JOptionPane.showMessageDialog(frameStu, "Entered data is not a mark!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // calculate average letter and point
                float avgPoint = grade.avgGradePoint(allPoints);
                String avgLetter = grade.avgGradeLetter(allPoints);

                // if no data given by user,dont update label
                if (allPoints.size() != 0) {
                    gLFinal.setText(avgLetter);
                    gPFinal.setText(Float.toString(avgPoint));
                }
            }
        });

        // logout button
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 13));
        logoutBtn.setBounds(50, 660, 80, 20);
        logoutBtn.setVisible(true);
        logoutBtn.setBorder(border);
        logoutBtn.setBackground(Color.CYAN);
        frameStu.add(logoutBtn);
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // deleting this student frame.
                frameStu.dispose();
                // opening the login field again and clearing the password
                passField.setText("");
                frameLogin.setVisible(true);
            }
        });

        // exit application.
        JButton exitBtn = new JButton("EXIT");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 13));
        exitBtn.setBounds(50 + 90, 660, 80, 20);
        exitBtn.setVisible(true);
        exitBtn.setBorder(border);
        exitBtn.setBackground(Color.RED);
        frameStu.add(exitBtn);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    /**
     * return appropriate semester name (Semester 2 -> semester2)
     *
     * @param semester name
     * @return formatted semester name
     */
    private static String reformatSemesterName(String sName) {
        String s = "semester";
        boolean status = false;
        for (int i = 0; i < sName.length(); i++) {
            if (status) {
                s += sName.charAt(i);
            }
            if (sName.charAt(i) == ' ') {
                status = true;
            }
        }
        return s;
    }
}
