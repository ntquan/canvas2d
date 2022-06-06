package com.canvas2d;

import java.util.Scanner;

/**
 * Run application
 *
 */
public class App {
    public static void main(String[] args) {
        help();

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

    private static void help() {
        String str = String.join("\n"
            , "The program works as follows:"
            , "1. Create a new canvas"
            , "2. Start drawing on the canvas by issuing various commands"
            , "3. Quit\n\n"
            , "Command         Description"
            , "C w h           Create a new canvas of width w and height h."
            , "L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2). Currently only"
            , "                horizontal or vertical lines are supported. Horizontal and vertical lines"
            , "                will be drawn using the 'x' character."
            , "R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and"
            , "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn"
            , "                using the 'x' character."
            , "B x y c         Fill the entire area connected to (x,y) with \"colour\" c. The"
            , "                behavior of this is the same as that of the \"bucket fill\" tool in paint"
            , "                programs."
            , "Q               Quit the program.");
        System.out.println(str);
    }
}
