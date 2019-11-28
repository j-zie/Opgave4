package com.skole;


import java.util.Scanner;

public class Main {
  private static int INIT = 9;

  public static void main(String[] args) {
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