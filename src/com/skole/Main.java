package com.skole;


import java.util.Scanner;

public class Main {
  private static final String ANSI_RESET ="\u001B[30m" ;
  private static int INIT = 9;
  public static final String ANSI_BLUE = "\u001B[34m";
  public static void main(String[] args) {
    System.out.println(ANSI_BLUE + "Velkommen til Delfinens svømmelkub halløj" + ANSI_RESET);
    System.out.println(ANSI_BLUE + "Velkommen velkommen velkommen velkommen " + ANSI_RESET);
    start();
  }

  public static void showOptions() {
    System.out.println("1: Formand");
    System.out.println("2: Kasserer");
    System.out.println("3: Træner");
    System.out.println("0: Quit");
  }

  public static Membership start() {
    int input = INIT;
    Scanner in = new Scanner(System.in);
    showOptions();
    while (input != 0) {
      input = in.nextInt();
      switch (input) {
        case 1:
          return new Formand();
          case 2:
          return new Kasserer();
        case 3:
          return new Traener();
        case 4:
          System.out.println();
        default:
          showOptions();
      }
    }
    return null;
  }
}