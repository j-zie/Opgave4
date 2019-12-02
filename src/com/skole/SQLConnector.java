package com.skole;

import java.sql.*;

public class SQLConnector {

        public static Connection connect() {
        Connection myConn = null;
        String user = "root";
        String pass = "password"; // måske er default "" for dig

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/delfinDB?serverTimezone=UTC", user, pass);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return myConn;
    }
}
