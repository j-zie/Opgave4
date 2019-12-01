package com.skole;

import java.sql.Connection;
import java.util.Scanner;

abstract class Membership {
    final int INIT = 9;

    abstract void showMenu();
    abstract void printMenu();

    static Connection conn = SQLConnector.connect();
    static Scanner in = new Scanner(System.in);

    public static String inputPrint(String stringToPrint) {
        System.out.println(stringToPrint);
        System.out.print("> ");
        String retVal = in.next();
        return retVal;
    }

}
