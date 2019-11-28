package com.skole;
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
                    System.out.println("Not implemented.");
                    break;
                case 2:
                    System.out.println("Not implemented.");
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
}
