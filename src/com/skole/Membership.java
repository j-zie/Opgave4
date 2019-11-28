package com.skole;

import java.util.Scanner;

abstract class Membership {
    final int INIT = 9;

    abstract void showMenu();
    abstract void printMenu();

    Scanner in = new Scanner(System.in);
}
