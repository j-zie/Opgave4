package com.skole;

import java.sql.*;
import java.util.ArrayList;

public class Formand extends Membership {

    public Formand (){
        showMenu();
    }

    /**
     * TODO
     * I add member crasher den på forkert input
     * Og der mangler hold
     *
     * Vis medlemmer printer kun fornavn
     *
     * Man kan ikke ændre bruger informationer
     * kunne være nice
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
                        registerMember();
                    } catch (Exception e) {System.out.println("No DB connection");};
                    break;
                case 2:
                    try {
                        showMembers();
                    } catch (Exception e) {System.out.println("No DB connection");};
                    break;
                case 3:
                    Main.start();
                    break;
                default:
                    printMenu();
                    break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println("1. Add member");
        System.out.println("2. Vis medlemmer");
        System.out.println("3. Tilbage");
        System.out.println("0. Exit");
    }


    public void registerMember() throws SQLException {
        /** Get input form user */
        String fname = inputPrint("Enter first name:"), lname = inputPrint("Enter last name");
        String pnumber = inputPrint("Enter phone number:"), adress = inputPrint("Enter adress");
        String email = inputPrint("Enter email:");
        int age = intInputPrint("Enter age:");
        boolean active = true;
        /** Push it to DB */

        String member = "insert into Medlem(navn, efternavn, adresse, email, alder, telefonnummer, aktivtMedlem)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(member);
        preparedStatement.setString(1, fname);
        preparedStatement.setString(2, lname);
        preparedStatement.setString(3, adress);
        preparedStatement.setString(4, email);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, pnumber);
        preparedStatement.setBoolean(7, active);
        preparedStatement.execute();
        System.out.println("Member added!");
        this.showMenu();
    }

    public void showMembers() throws SQLException {
        ArrayList<String> a = new ArrayList<>(10);
        Statement tmp = conn.createStatement();
        ResultSet members = tmp.executeQuery("SELECT * from Medlem");

        while(members.next()) {
            a.add(members.getString("navn"));
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        this.showMenu();
    }
}
