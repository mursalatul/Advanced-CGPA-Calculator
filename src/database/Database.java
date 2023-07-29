package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;

import java.util.ArrayList;

import gradecalculation.Grade;
/**
 *
 * @author mursalatul
 */
public class Database {

    private Connection connection;
    protected Statement statement;
    private String database;

    /**
     * connect the database and initialize the statement
     * 
     * @param database name
     * @return none
    */
    public void connect(String database) {
        // Database credentials
        this.database = database;
        String url = "jdbc:mysql://localhost:3306/" + database;
        String user = "root";
        String password = "root";

        // Establish a connection
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            System.out.println("Connected to the database!");

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    /**
     * generate table name from semester number
     * 
     * @param semester number
     * @return sql table name
     */
    protected String tableName(int semester_no) {
        return "semester" + Integer.toString(semester_no);
    }

    /**
     * execute a mysql command
     * 
     * @param string (command)
     * @return Successful / error message
     */
    protected String execute(String command) {
        String status;
        //        executing the command with this.statement
        try {
            this.statement.execute(command);
            status = "Successful";
        } catch (SQLException e) {
            status = e.getMessage();
        }
        return status;
    }

    /**
     * create table with appropriate columns(No, Course No, Course Title,
     * Incourse, Final, Grade Letter, Grade Point, Avg Grade Letter, Avg Grade
     * Point)
     *
     * @param semester number
     * @return Successful / error message
     */
    public String createTable(int semester_no) {
        String status;
        // setting up table name. table name will be "semester"+number of semester
        String tableName = tableName(semester_no);

        // creating mysql command
        String createTableCommand = "CREATE TABLE `"+this.database+"`." + tableName + " (`No` INT(1) NOT NULL AUTO_INCREMENT , `Course No` TEXT NOT NULL , `Course Title` TEXT NOT NULL , `Incourse` INT NOT NULL , `Final` INT NOT NULL , `Grade Letter` TEXT NOT NULL , `Grade Point` FLOAT NOT NULL , `Avg Grade Letter` TEXT NOT NULL , `Avg Grade Point` FLOAT NOT NULL , PRIMARY KEY (`No`)) ENGINE = InnoDB";

        // executing the command with this.statement
        try {
            this.statement.execute(createTableCommand);
            status = "Successful";
        } catch (SQLException e) {
            status = e.getMessage();
        }
        return status;
    }

    /**
     * delete full table
     *
     * @param semester numberr
     * @return true / error message
     */
    public String deleteTable(int semester_no) {
        String status;
        // setting up table name. table name will be "semester"+number of semester
        String tableName = tableName(semester_no);

        // creating mysql command
        String createTableCommand = "DROP TABLE " + tableName;

        // executing the command with this.statement
        try {
            this.statement.execute(createTableCommand);
            status = "Successful";
        } catch (SQLException e) {
            status = e.getMessage();
        }
        return status;
    }

    public String insertData(int semester_no, String course_no, String course_title, int inc, int fin) {
        String table = tableName(semester_no);
        String command;
        // calculating grade letter and grade point
        Grade grd = new Grade();
        grd.setMark((inc), fin, 0);
        String grade_letter = grd.gradeLetter();
        float grade_point = grd.gradePoint();
        
        // getting previous grade points
        ArrayList<Float> allPoints = getAllPoint(semester_no);
        
        allPoints.add(grade_point);
        
        // getting average grade point and average grade letter
        String avgGP = Float.toString(grd.avgGradePoint(allPoints));
        String avgGL = grd.avgGradeLetter(allPoints);
        
        command = "INSERT INTO " + table + " (`Course No`, `Course Title`, `Incourse`, `Final`, `Grade Letter`, `Grade Point`, `Avg Grade Letter`, `Avg Grade Point`) " +
                "VALUES " + "('" + course_no + "','" + course_title + "','" + Integer.toString(inc) + 
                "','"+ Integer.toString(fin) + "','" + grade_letter+"','"+grade_point+"', '"+avgGL+"', '"+avgGP+"')";
        // System.out.println(command);
        return execute(command);
    }
    
    /**
    * return all stored grade points of a table
    * @param semester number
    * @return ArrayList<Float>
    */
    private ArrayList<Float> getAllPoint(int semester_no) {
        String table = tableName(semester_no);
        ResultSet wholeData = getData(table);
        ArrayList<Float> allPoints = new ArrayList<>();
        try {
            while (wholeData.next()) {
                allPoints.add(Float.parseFloat(wholeData.getString("Grade Point")));
            }
        } catch (SQLException e) {
            System.out.println("Error(File: Database, method: getAllPoint): " + e.getMessage());
        }
        return allPoints;
    }
    
//    private void updateAvgGrade(int semester_no) {
//        String table = tableName(semester_no);
//        
//        // get all the grade points of semester_no table and create a avg grade and store it
//        String gPQuery = "SELECT `Grade Point` FROM `" + table + "`" ;
//        try {
//            // getting data from the table
//            ResultSet gPData = statement.executeQuery(gPQuery);
//            // storing them in a ArrayList
//            ArrayList<Float> allPoints = new ArrayList<>();
//            float sum = 0.0f;
//            
//            while (gPData.next()) {
//                // invalidFloat will track if the data comming from "Grade Point"
//                // is a valid float number or not
//                boolean invalidFloat = false;
//                String colValue = gPData.getString("Grade Point");
//                float colvalueFloat;
//                try {
//                   colvalueFloat = Float.parseFloat(colValue); 
//                } catch (NumberFormatException e) {
//                    // if cant convert into a float, it is not a float number.
//                    // so make invalidFloat equal to true
//                    invalidFloat = true;
//                    System.out.println("Error(File: Database, method: updateAvgGrade): " + e.getMessage());
//                }
//                if (invalidFloat == false) {
//                    allPoints.add(Float.parseFloat(gPData.getString("Grade Point")));                    
//                }
//
//            }
//            
//            Grade g = new Grade();
//            String avgGP = Float.toString(g.avgGradePoint(allPoints));
//            String avgGL = g.avgGradeLetter(allPoints);
//            String gPInsert = "INSERT INTO `" + table  +"` (`Avg Grade Point`, `Avg Grade Letter`) VALUES ('" + avgGP +"', '"+ avgGL +"')";
//            
//        } catch (SQLException e) {
//            System.out.println("Error(File: Databse, Method: insertData): " + e.getMessage());
//        }
//    }
    
    /**
     * clear all the data of a table
     * 
     * @param semester number
     * @return true / error message
    */
    public String clearTable(int semester_no) {
        String tableName = tableName(semester_no);
        return execute("DELETE FROM " + tableName);
    }
    
    /**
     * get all the data of a table
     * @param, table name
     * @return ResultSet
     */
    public ResultSet getData(String table) {
        ResultSet data = null;
        String query = "SELECT * FROM `" + table + "`";
        try {
            // get data from role(student/teacher) table
            data = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }
}
