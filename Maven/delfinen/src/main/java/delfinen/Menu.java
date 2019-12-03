package delfinen;

public class Menu {

    /*TODO
       Denne classe skal indeholde en switchcase som styres afhængigt af hvilken rolle, 'USER' har.

    */

    Menu(User u) {
        int ID = u.getRoleID();
        switch (ID) {
            case 1:
                presidentMenu();
                break;
            case 2:
                accountantMenu();
                break;
            case 3:
                trainerMenu();
                break;
        }
    }

    //TODO code menu
    private void presidentMenu() {

    }

    //TODO code menu
    private void accountantMenu() {

    }

    //TODO code menu
    private void trainerMenu() {

    }
}
