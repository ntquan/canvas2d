package com.canvas2d.model;

import java.util.List;

import com.canvas2d.exception.InvalidInputException;

public class Line extends DrawBase {
   /**
    * args has 4 items: (x1, y1) - (x2, y2)
    */
   public void render(List<String> args) throws InvalidInputException {
      validInput(args);
      int x1 = Integer.parseInt(args.get(0));
      int y1 = Integer.parseInt(args.get(1));
      int x2 = Integer.parseInt(args.get(2));
      int y2 = Integer.parseInt(args.get(3));
      validRender(x1, y1, x2, y2);
      if (x1 != x2 && y1 != y2)
         throw new InvalidInputException("Only support horizontal and vertical lines");
      //Draw horizontal line
      if (x1 < x2)
         drawLine(x1, y1, x2, y2, 'x');
      else
         drawLine(x2, y1, x1, y2, 'x');
      //Draw vertical line
      if (y1 < y2)
         drawLine(x1, y1, x2, y2, 'x');
      else
         drawLine(x1, y2, x2, y1, 'x');

      System.out.print(this.toConsole());
   }

   private void validInput(List<String> args) throws InvalidInputException {
      if (args.size() < 4)
         throw new InvalidInputException("Line requires 4 parameters");
      boolean result = isInteger(args.get(0)) && isInteger(args.get(1)) && isInteger(args.get(2))
            && isInteger(args.get(3));
      if (!result)
         throw new InvalidInputException("x1 y1 x2 y2 should be integer");
   }
}
