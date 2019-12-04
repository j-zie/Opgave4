package delfinen;

import java.util.Scanner;

public class App

    /*TODO
        Denne klasse kører programmet, evt. while-loop der lukkes med en boolean.
        Klassediagram og programmet skal indeles i packages.

        ACCOUNTANT
        Funktion til at slÂ alle "MEMBERS" op, som er i restence.

        MEMBER
        Variabeler til at tracke alt data direkte relateret til "MEMBER".
        Getters og setters til at hente data fra SQL.

        PRESIDENT
        Funktion til at oprette et nyt medlem
         - >  skal oprettes i DB og instanciere objekt. Funktion til at Êndre et medlem?

        UTILITY
        Funktioner til at tage input (lav utility om sÂ man instancierer et objekt istedet for at lave en scanner hver gang).
        Resultater skal gemmes som integer, og formateres til tid (mÂske skal denne funktion laves i Utility?)
        Utility metode til input og til format?
        MÂske skal Medlem selv have en metode til at vise resultat, og bare hive resultatet fra SQL. (Ingen resultat class).

        MENU
        Menu skal vise en menu afhÊngig af hvilken "USER" der tilgÂr.
        Evt.: Hver Klasse der nedavrer fra "USER" har en rolle variabel som bruges til at identificere objektet.
        Derfra er det bare at lave menuÈn til hver rolle, seperat.
*/

{
    public static void main( String[] args )
    {
        //temp stuff for at teste
        //TODO valg af bruger og en måde at stoppe while loopet.

        Utility ut = new Utility();
        ut.intInput();

        /*
        President p = new President(1,02,63,"Jørgen Jørgensen","12 34 56 78");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("write anything to continue");
            String a = scan.next();
            Menu m = new Menu(p);

        }*/
    }
}
