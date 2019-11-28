package com.skole;
//Vis resistence
public class Kasserer extends Membership{

    public Kasserer() {
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
                    System.out.println("Not implemented.");
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
        System.out.println("1. Vis resistence");
        System.out.println("2. Tilbage");
        System.out.println("0. Logout");
    }
}

