/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mursalatul
 */
public class LoginDB extends Database {
    
    // connecting login_credentials database
    public LoginDB() {
        connect("login_credentials");
    }
    
    /**
     * check if the login username and password is present in the database or not
     * @param role(student / teacher) username, password
     * @return true / false
    */
    public boolean isPresent(String role, String username, String pass) {
        boolean foundStatus = false;
        if (role.compareTo("student") == 0 || role.compareTo("teacher") == 0) {
            String query = "SELECT `username`, `password` FROM " + role;
            try {
                // get data from role(student/teacher) table
                ResultSet data = statement.executeQuery(query);
                
                // check data for username and password
                while (data.next()) {
                    String usernameFromTable = data.getString("username");
                    String passFromTable = data.getString("password");
                    
                    // checking username and password with provided username and password
                    if (username.compareTo(usernameFromTable) == 0 && pass.compareTo(passFromTable) == 0) {
                        foundStatus = true;
                        break;
                    }
                }
            }
            catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return foundStatus;
    }
}
