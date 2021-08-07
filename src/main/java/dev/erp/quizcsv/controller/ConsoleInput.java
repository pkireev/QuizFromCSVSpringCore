package dev.erp.quizcsv.controller;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner sc;

    public ConsoleInput() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    public String getString() {
        return sc.nextLine();
    }

    public int getInt() {
        return sc.nextInt();
    }
}
