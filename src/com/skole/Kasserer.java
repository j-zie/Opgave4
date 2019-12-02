package com.skole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Vis resistence
public class Kasserer extends Membership{

    public Kasserer() {
        showMenu();
    }

    /**
     *  Vis resistence printer kun fornavn og er stavet forkert
     *
     *  Man kan ændre i kontigent, hvis man havde lyst.
     *
     */
    @Override
    public void showMenu() {
        int input = INIT;
        printMenu();
        while (input != 0) {
            input = in.nextInt();

            switch (input) {
                case 1:
                    try {
                        showMembersInResistence();
                    } catch (Exception e) {System.out.println("No DB connection");};
                    break;
                case 2:
                    Main.start();
                    break;
                default:
                    printMenu();
                    break;
            }
        }
    }

    @Override
    void printMenu() {
        System.out.println("1. Vis medlemmer i  resistence");
        System.out.println("2. Tilbage");
        System.out.println("0. Logout");
    }

    public void showMembersInResistence() throws SQLException {
        Connection con = SQLConnector.connect();
        Statement tmp = con.createStatement();
        ResultSet members = tmp.executeQuery("SELECT * FROM Medlem " +
                "WHERE datediff(curdate(), betalingsDato) > 365.25");
        while(members.next()) {
            System.out.println(members.getString("navn") + " " + members.getString("efternavn"));
        }   
    }
}

