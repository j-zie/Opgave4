package delfinen;

import java.util.Scanner;

public class App

    /*TODO
    *  Denne klasse kører programmet, evt. while-loop der lukkes med en boolean.*/

{
    public static void main( String[] args )
    {
        //temp stuff for at teste
        //TODO valg af bruger og en måde at stoppe while loopet.
        President p = new President(1,02,63,"Jørgen Jørgensen","12 34 56 78");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("write anything to continue");
            String a = scan.next();
            Menu m = new Menu(p);
        }
    }
}
