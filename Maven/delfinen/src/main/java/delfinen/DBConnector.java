package delfinen;

import java.sql.*;

public class DBConnector {

    //Class for connecting to DB and performing queries.

    public static Connection conn() throws Exception {
        try {
            String driver, url, username, password, nameDB;
            nameDB = "DelfinenDB";
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/"+nameDB;
            username = "root";
            password = "password";
            Class.forName(driver);

            System.out.println("\n--------------- MySQL ---------------");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void updateSQL(String query) throws Exception {
        Statement st = null;
        try {
            st = conn().createStatement();
            st.executeUpdate(query);
            System.out.println("SQL updated");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("ErrorCode: " + ex.getErrorCode());
        } finally {
            if (st != null) {
                try {
                    st.close();
                    System.out.println("Disconnected\n");
                } catch (SQLException sqlEx) {
                }
            }
        }
    }

    public static ResultSet querySQL(String query) throws Exception {
        Statement st;
        ResultSet rs = null;
        try {
            st = conn().createStatement();
            rs = st.executeQuery(query);
            System.out.println("SQL query completed\n");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }
}


}
