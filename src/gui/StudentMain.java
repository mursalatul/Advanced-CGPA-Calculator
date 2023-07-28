package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import javax.swing.JComboBox;

/**
 *
 * @author mursalatul
 */
public class StudentMain {

    public void studentmain(String roll) {
        JFrame frameStu = new JFrame();
        frameStu.setSize(800, 800);
        frameStu.setResizable(false);
        frameStu.setLayout(null);
        frameStu.setVisible(true);
        frameStu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // no border is visible, but it is helpfull to element visiblity
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

        // window heading
        JLabel heading = new JLabel("CGPA Calculator");
        // change the value for positioning
        int headingX = 317, headingY = 5, headingW = 165, headingH = 30;
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(headingX, headingY, headingW, headingH);
        heading.setVisible(true);
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
        int fNameLX = 150, fNameLY = 50, fNameLW = 400, fNameLH = 30;
        fNameL.setBounds(fNameLX, fNameLY, fNameLW, fNameLH);
        fNameL.setFont(new Font("Arial", Font.BOLD, 15));
        fNameL.setVisible(true);
        frameStu.add(fNameL);
        fNameL.setBorder(border);
        
        // show batch
        JLabel batchL = new JLabel();
        batchL.setText(batch);
        int batchLX = 150, batchLY = 90, batchLW = 100, batchLH = 30;
        batchL.setBounds(batchLX, batchLY, batchLW, batchLH);
        batchL.setFont(new Font("Arial", Font.BOLD, 10));
        batchL.setVisible(true);
        frameStu.add(batchL);
        batchL.setBorder(border);
        
        // show roll
        JLabel rollL = new JLabel();
        rollL.setText("Roll: "+roll);
        int rollLX = 190, rollLY = 90, rollLW = 100, rollLH = 30;
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
        int l4X = 130, l4Y = 260, l4W = 65, l4H = 30;
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
        
        // panel for fields
        JPanel fPanel = new JPanel();
        fPanel.setBounds(50, 300, 500, 291);
        frameStu.add(fPanel);
        fPanel.setBorder(border);
        
        
        // field's properties
        // field width
        int fW = 70, fH = 40;
        
        // row 1
        // field f11
        JTextField f11 = new JTextField();
//        f11.setText("f11");
        int f11X = 50, f11Y = 300;
        f11.setBounds(f11X, f11Y, fW, fH);
        f11.setFont(new Font("Arial", Font.BOLD, 14));
        f11.setVisible(true);
        frameStu.add(f11);
        f11.setBorder(border);
        
        // field f12
        JTextField f12 = new JTextField();
        f12.setText("f12");
        int f12X = 125, f12Y = f11Y;
        f12.setBounds(f12X, f12Y, fW, fH);
        f12.setFont(new Font("Arial", Font.BOLD, 14));
        f12.setVisible(true);
        frameStu.add(f12);
        f12.setBorder(border);
        
        // field f13
        JTextField f13 = new JTextField();
        f13.setText("f13");
        int f13X = 200, f13Y = f11Y;
        f13.setBounds(f13X, f13Y, fW, fH);
        f13.setFont(new Font("Arial", Font.BOLD, 14));
        f13.setVisible(true);
        frameStu.add(f13);
        f13.setBorder(border);
        
        // row 2
        // field f21
        JTextField f21 = new JTextField();
        f21.setText("f21");
        int f21X = 50, f21Y = 350;
        f21.setBounds(f21X, f21Y, fW, fH);
        f21.setFont(new Font("Arial", Font.BOLD, 14));
        f21.setVisible(true);
        frameStu.add(f21);
        f21.setBorder(border);
        
        // field f22
        JTextField f22 = new JTextField();
        f22.setText("f22");
        int f22X = 125, f22Y = f21Y;
        f22.setBounds(f22X, f22Y, fW, fH);
        f22.setFont(new Font("Arial", Font.BOLD, 14));
        f22.setVisible(true);
        frameStu.add(f22);
        f22.setBorder(border);
        
        // field f23
        JTextField f23 = new JTextField();
        f23.setText("f23");
        int f23X = 200, f23Y = f21Y;
        f23.setBounds(f23X, f23Y, fW, fH);
        f23.setFont(new Font("Arial", Font.BOLD, 14));
        f23.setVisible(true);
        frameStu.add(f23);
        f23.setBorder(border);
        
        // row 3
        // field f31
        JTextField f31 = new JTextField();
        f31.setText("f31");
        int f31X = 50, f31Y = 400;
        f31.setBounds(f31X, f31Y, fW, fH);
        f31.setFont(new Font("Arial", Font.BOLD, 14));
        f31.setVisible(true);
        frameStu.add(f31);
        f31.setBorder(border);
        
        // field f32
        JTextField f32 = new JTextField();
        f32.setText("f31");
        int f32X = 125, f32Y = f31Y;
        f32.setBounds(f32X, f32Y, fW, fH);
        f32.setFont(new Font("Arial", Font.BOLD, 14));
        f32.setVisible(true);
        frameStu.add(f32);
        f32.setBorder(border);
        
        // field f33
        JTextField f33 = new JTextField();
        f33.setText("f33");
        int f33X = 200, f33Y = f31Y;
        f33.setBounds(f33X, f33Y, fW, fH);
        f33.setFont(new Font("Arial", Font.BOLD, 14));
        f33.setVisible(true);
        frameStu.add(f33);
        f33.setBorder(border);
        
        // row 4
        // field f41
        JTextField f41 = new JTextField();
        f41.setText("f41");
        int f41X = 50, f41Y = 450;
        f41.setBounds(f41X, f41Y, fW, fH);
        f41.setFont(new Font("Arial", Font.BOLD, 14));
        f41.setVisible(true);
        frameStu.add(f41);
        f41.setBorder(border);
        
        // field f42
        JTextField f42 = new JTextField();
        f42.setText("f42");
        int f42X = 125, f42Y = f41Y;
        f42.setBounds(f42X, f42Y, fW, fH);
        f42.setFont(new Font("Arial", Font.BOLD, 14));
        f42.setVisible(true);
        frameStu.add(f42);
        f42.setBorder(border);
        
        // field f43
        JTextField f43 = new JTextField();
        f43.setText("f43");
        int f43X = 200, f43Y = f41Y;
        f43.setBounds(f43X, f43Y, fW, fH);
        f43.setFont(new Font("Arial", Font.BOLD, 14));
        f43.setVisible(true);
        frameStu.add(f43);
        f43.setBorder(border);
        
        // row 5
        // field f51
        JTextField f51 = new JTextField();
        f51.setText("f51");
        int f51X = 50, f51Y = 500;
        f51.setBounds(f51X, f51Y, fW, fH);
        f51.setFont(new Font("Arial", Font.BOLD, 14));
        f51.setVisible(true);
        frameStu.add(f51);
        f51.setBorder(border);
        
        // field f52
        JTextField f52 = new JTextField();
        f52.setText("f52");
        int f52X = 125, f52Y = f51Y;
        f52.setBounds(f52X, f52Y, fW, fH);
        f52.setFont(new Font("Arial", Font.BOLD, 14));
        f52.setVisible(true);
        frameStu.add(f52);
        f52.setBorder(border);
        
        // field f53
        JTextField f53 = new JTextField();
        f53.setText("f53");
        int f53X = 200, f53Y = f51Y;
        f53.setBounds(f53X, f53Y, fW, fH);
        f53.setFont(new Font("Arial", Font.BOLD, 14));
        f53.setVisible(true);
        frameStu.add(f53);
        f53.setBorder(border);
        
        // row 6
        // field f61
        JTextField f61 = new JTextField();
        f61.setText("f61");
        int f61X = 50, f61Y = 550;
        f61.setBounds(f61X, f61Y, fW, fH);
        f61.setFont(new Font("Arial", Font.BOLD, 14));
        f61.setVisible(true);
        frameStu.add(f61);
        f61.setBorder(border);
        
        // field f62
        JTextField f62 = new JTextField();
        f62.setText("f62");
        int f62X = 125, f62Y = f61Y;
        f62.setBounds(f62X, f62Y, fW, fH);
        f62.setFont(new Font("Arial", Font.BOLD, 14));
        f62.setVisible(true);
        frameStu.add(f62);
        f62.setBorder(border);
        
        // field f63
        JTextField f63 = new JTextField();
        f63.setText("f63");
        int f63X = 200, f63Y = f61Y;
        f63.setBounds(f63X, f63Y, fW, fH);
        f63.setFont(new Font("Arial", Font.BOLD, 14));
        f63.setVisible(true);
        frameStu.add(f63);
        f63.setBorder(border);
        
        
//        // panel for button
//        JPanel btnPanel = new JPanel();
//        btnPanel.setBounds(50, 600, 300, 100);
//        btnPanel.setBorder(border);
//        frameStu.add(btnPanel);
        
        
        // calculate & clear button
        JButton calBtn = new JButton("Calculate");
        JButton clrBtn = new JButton("Clear");
        
        int btnX = 50, btnY = 600, btnW = 70, btnH = 50;
        calBtn.setBounds(btnX, btnY, btnW, btnH);
        clrBtn.setBounds(btnX + 80, btnY, btnW, btnH);
        
        calBtn.setVisible(true);
        clrBtn.setVisible(true);
        calBtn.setBorder(border);
        clrBtn.setBorder(border);
        
        calBtn.setBackground(Color.CYAN);
        clrBtn.setBackground(Color.CYAN);   
        
        frameStu.add(calBtn);
        frameStu.add(clrBtn);
        
    }
}
