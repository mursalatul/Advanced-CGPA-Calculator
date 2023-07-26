/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package advancedcgpacalculator;

/**
 *
 * @author mursalatul
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdvancedCGPACalculator {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/cgpa_storage";
        String user = "root";
        String password = "root";

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");

            // Now you can execute queries, update data, etc.
            // For example:
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name;");
            // while (resultSet.next()) {
            //     // Process the data
            // }

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
