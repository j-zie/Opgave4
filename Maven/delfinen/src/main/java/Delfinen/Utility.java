package Delfinen;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Utility {
    private Scanner sc;

    int intInput() {
        boolean change = false;
        int input = 0;
        sc = new Scanner(System.in);
        while (!change) {
            try {
                input = sc.nextInt();
                change = true;
            } catch (Exception e) {
                System.out.print("Input an integer: ");
                sc.nextLine();
            }
        }
        return input;
    }

    boolean confirmInput() {
        boolean result = false;
        String input = "";
        sc = new Scanner(System.in);
        while (true) {
            input = sc.next();
            if (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))) {
                System.out.print("Input 'Y' or 'N': ");
                continue;
            }
            break;
        }
        if (input.equals("y") || input.equals("Y")) {
            result = true;
        }
        return result;
    }

    Timestamp timeInput() {
        Timestamp time;
        int hour = 0;
        int minute = 0;

        while (true) {
            System.out.print("Hour: ");
            hour = intInput();
            if (hour < 0 || hour > 23) {
                System.out.print("Input a number from 0 - 23: ");
                continue;
            }
            while (true) {
                System.out.print("Minute: ");
                minute = intInput();
                if (minute < 0 || minute > 59) {
                    System.out.print("Input a number from 0 - 59: ");
                    continue;
                }
                break;
            }
            break;
        }
        //Jeg henter lokal-tiden med LocalDateTime.now(), og parser den til et Timestamp objekt.
        time = Timestamp.valueOf(LocalDateTime.now());
        //Jeg benytter Depreciated metoder her, men idéelt bruger man 'setTime()'.
        time.setMinutes(minute);
        time.setHours(hour);
        return time;
    }

    //Simpel metode til at formatere tiden til kun at vise timer og minutter.
    static String formattedTimestamp(Timestamp time) {
        String hours, minutes;
        if (time.getHours() < 10) {
            hours = "0" + time.getHours();
        } else {
            hours = "" + time.getHours();
        }
        if (time.getMinutes() < 10) {
            minutes = "0" + time.getMinutes();
        } else {
            minutes = "" + time.getMinutes();
        }
        String timestamp = hours + ":" + minutes;
        return timestamp;
    }
}