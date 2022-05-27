package com.canvas2d.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.canvas2d.exception.InvalidInputException;

public class Fill extends DrawBase {
   /**
    * args has 3 items: (x1, y1) and letter to fill
    */
   public void render(List<String> args) throws InvalidInputException {
      validInput(args);
      int x = Integer.parseInt(args.get(0));
      int y = Integer.parseInt(args.get(1));
      char newLetter = args.get(2).charAt(0);
      validRender(x, y, x, y);

      String output = fillNonRecursive(x, y, shape[y][x], newLetter);
      System.out.println(output);
   }

   private String fillNonRecursive(int x, int y, char oldLetter, char newLetter) {
      Queue<Integer> xCoor = new LinkedList<>();
      Queue<Integer> yCoor = new LinkedList<>();
      if (shape[y][x] == oldLetter) {
         xCoor.add(x);
         yCoor.add(y);
         shape[y][x] = newLetter;
         while (!xCoor.isEmpty()) {
            x = xCoor.remove();
            y = yCoor.remove();
            // Do not fill edge of canvas
            if (x < 1 || y < 1 || x > width || y > height)
               continue;
            // up
            if (shape[y - 1][x] == oldLetter) {
               shape[y - 1][x] = newLetter;
               xCoor.add(x);
               yCoor.add(y - 1);
            }
            // right
            if (shape[y][x + 1] == oldLetter) {
               shape[y][x + 1] = newLetter;
               xCoor.add(x + 1);
               yCoor.add(y);
            }
            // down
            if (shape[y + 1][x] == oldLetter) {
               shape[y + 1][x] = newLetter;
               xCoor.add(x);
               yCoor.add(y + 1);
            }
            // left
            if (shape[y][x - 1] == oldLetter) {
               shape[y][x - 1] = newLetter;
               xCoor.add(x - 1);
               yCoor.add(y);
            }
         }
      }
      return this.toConsole();
   }

   private void validInput(List<String> args) throws InvalidInputException {
      if (args.size() < 3)
         throw new InvalidInputException("Fill requires 3 parameters");
      boolean result = isInteger(args.get(0)) && isInteger(args.get(1)) && args.get(2).length() == 1;
      if (!result)
         throw new InvalidInputException("x y c with (x,y) is integer and c is one letter");
   }
}
