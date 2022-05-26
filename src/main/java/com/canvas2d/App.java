package com.canvas2d;

import java.util.Scanner;

/**
 * Run application
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ConsoleFactory console = new ConsoleFactory();
            while (true) {
                System.out.print("Enter command: ");
                console.create(scanner.nextLine());

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
