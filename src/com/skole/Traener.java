package com.skole;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

//Registrer resultat
//Vis hold
//Vis top 5 svømmere
public class Traener extends Membership {

    public Traener () {
        showMenu();
    }
    @Override
    public void showMenu() {
        int input = INIT;
        printMenu();
        while (input != 0) {
            input = in.nextInt();

            switch (input) {
                case 1:
                    try {
                        registreHold();
                    } catch (Exception e) {System.out.println("No DB connection");};
                    break;
                case 2:
                    System.out.println("Ved ikke lige hvad hold er.");
                    break;
                case 3:
                    System.out.println("Not implemented.");
                    break;
                case 4:
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
        System.out.println("1. Registre resultat");
        System.out.println("2. Vis hold");
        System.out.println("3. Vis top 5 svømmere");
        System.out.println("4. Tilbage");
        System.out.println("0. Logout");
    }


    public void registreHold() throws SQLException {
        int idOfMember = intInputPrint("ID of member you wanna register");
        String staevneNavn = inputPrint("Hvad hed stævnet?");
        String disciplin = inputPrint("Hvilken svømme disciplin var det?");
        String time = inputPrint("Enter time(HH:MM:SS)");
        String date = inputPrint("Enter date(YYYY-MM-DD):");

        String member = "insert into Resultater(medlemID, staevneNavn, disciplin, dato, tid)"
                    + "VALUES (?, ?, ?, ?, ?)";
        System.out.println("Result added!");
        System.out.println(idOfMember);
        System.out.println(staevneNavn);
        System.out.println(disciplin);
        System.out.println(time);
        System.out.println(date);
        PreparedStatement preparedStatement = conn.prepareStatement(member);
        preparedStatement.setInt(1, idOfMember);
        preparedStatement.setString(2, staevneNavn);
        preparedStatement.setString(3, disciplin);
        preparedStatement.setDate(4, Date.valueOf(date));
        preparedStatement.setTime(5, Time.valueOf(time));
        preparedStatement.execute();
        this.showMenu();
    }
}
