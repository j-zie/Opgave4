package delfinen;

import java.util.Scanner;

public class Menu {

    /*TODO
       Denne classe skal indeholde en switchcase som styres afhængigt af hvilken rolle, 'USER' har.
       Menu skal vise en menu afhÊngig af hvilken "USER" der tilgår.
       Evt.: Hver Klasse der nedavrer fra "USER" har en rolle variabel som bruges til at identificere objektet.
       Derfra er det bare at lave menuÈn til hver rolle, seperat.

    */

    Scanner input;

    Menu(User user) {
        input = new Scanner(System.in);
        int ID = user.getRoleID();
        switch (ID) {
            case 1:
                presidentMenu(user);
                break;
            case 2:
                accountantMenu(user);
                break;
            case 3:
                trainerMenu(user);
                break;
        }
    }

    //TODO code menu
    private void presidentMenu(User user) {
        System.out.println("Vælg noget:");
        System.out.println("1: Opret medlem");
        System.out.println("2: Tilbage til hovedmenuen");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                ((President) user).createMember();
                break;
            case 2:
                break;

        }
    }

    //TODO code menu
    private void accountantMenu(User user) {
        System.out.println("Vælg noget:");
        System.out.println("1: Se medlemmer i restance");
        System.out.println("2: Tilbage til hovedmenuen");
    }

    //TODO code menu
    private void trainerMenu(User user) {

    }
}
