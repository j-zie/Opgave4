package com.skole;

import java.sql.*;

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
                    try {
                        topFive();
                    } catch (Exception e) {System.out.println("No DB connection");};
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

    public String chooseDiscipline() {
        System.out.println("Please choose the discipline:");
        System.out.println("1. Freestyle");
        System.out.println("2. Breaststroke");
        System.out.println("3. Butterfly");
        System.out.println("4. Backstroke");
        int ret = in.nextInt();
        if (ret == 1)
            return "Freestyle";
        else if (ret == 2)
            return "Breaststroke";
        else if (ret == 3)
            return "Butterfly";
        else if (ret == 4)
            return "Backstroke";
        else
            return chooseDiscipline();
    }

    public void registreHold() throws SQLException {
        int idOfMember = intInputPrint("ID of member you wanna register");
        String staevneNavn = inputPrint("Hvad hed stævnet?");
        String disciplin = chooseDiscipline();
        String time = inputPrint("Enter time(HH:MM:SS)");
        String date = inputPrint("Enter date(YYYY-MM-DD):");

        String member = "insert into Resultater(medlemID, staevneNavn, disciplin, dato, tid)"
                    + "VALUES (?, ?, ?, ?, ?)";
        System.out.println("Result added!");
        PreparedStatement preparedStatement = conn.prepareStatement(member);
        preparedStatement.setInt(1, idOfMember);
        preparedStatement.setString(2, staevneNavn);
        preparedStatement.setString(3, disciplin);
        preparedStatement.setDate(4, Date.valueOf(date));
        preparedStatement.setTime(5, Time.valueOf(time));
        preparedStatement.execute();
        System.out.println("Result added!");
        this.showMenu();
    }


    public void topFive() throws SQLException {
        int counter = 5;
        String fetch = chooseDiscipline();
        Connection con = SQLConnector.connect();
        Statement tmp = con.createStatement();
        ResultSet topAthletes = tmp.executeQuery("SELECT Medlem.navn, Resultater.tid, Resultater.disciplin," +
                " Resultater.tid, Resultater.staevneNavn, Medlem.efternavn " +
                "FROM Resultater " +
                "INNER JOIN Medlem ON Medlem.medlemID = Resultater.medlemID " +
                "WHERE disciplin = " + "\"" + fetch + "\" " +
                "ORDER BY tid");
        while (topAthletes.next() && counter-- > 0) {
            System.out.printf(topAthletes.getString("navn") + " " + topAthletes.getString("efternavn") + " @ " +
            topAthletes.getString("staevneNavn") + " TIME: " + topAthletes.getTime("tid"));
            System.out.println();
            showMenu();
        }
    }


}
