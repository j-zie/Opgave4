package com.skole;

import java.sql.*;

public class SQLConnector {

        public static void connect() {

        String user = "root";
        String pass = "password"; // måske er default "" for dig

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", user, pass);
            Statement statement = myConn.createStatement();
            System.out.println("Connection established.");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
