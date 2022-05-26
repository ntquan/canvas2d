package com.canvas2d.model;

import java.util.List;

public class Fill extends DrawBase {
   /**
    * Java doc
    * args has 3 items: (x1, y1) and letter to fill
    */
   public void render(List<String> args) {
      int x1 = Integer.parseInt(args.get(0));
      int y1 = Integer.parseInt(args.get(1));
      char newLetter = args.get(2).charAt(0);
      String output = fillRecursive(x1, y1, shape[y1][x1], newLetter);
      System.out.println(output);
   }

   private String fillRecursive(int x, int y, char oldLetter, char newLetter) {
      // Do not fill edge of canvas
      if (x < 1 || y < 1 || x > width || y > height || shape[y][x] != oldLetter) {
         return "";
      }

      if (shape[y][x] == oldLetter)
         shape[y][x] = newLetter;
      fillRecursive(x + 1, y, oldLetter, newLetter);
      fillRecursive(x - 1, y, oldLetter, newLetter);
      fillRecursive(x, y + 1, oldLetter, newLetter);
      fillRecursive(x, y - 1, oldLetter, newLetter);
      return this.toString();
   }
}
