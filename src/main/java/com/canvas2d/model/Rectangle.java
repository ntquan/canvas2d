package com.canvas2d.model;

import java.util.List;

import com.canvas2d.exception.InvalidInputException;

public class Rectangle extends DrawBase {
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
      if (x1 == x2 || y1 == y2)
         throw new InvalidInputException("upper left corner is (x1,y1) and lower right corner is (x2,y2)");
      //Draw Rectangle
      if(x1 < x2 && y1 < y2) {
         // Draw upper border
         drawLine(x1, y1, x2, y1, 'x');
         // Draw left border
         drawLine(x1, y1, x1, y2, 'x');
         // Draw right border
         drawLine(x2, y1, x2, y2, 'x');
         // Draw lower border
         drawLine(x1, y2, x2, y2, 'x');
      }
      if(x2 < x1 && y2 < y1) {
         // Draw upper border
         drawLine(x2, y2, x1, y2, 'x');
         // Draw left border
         drawLine(x2, y2, x2, y1, 'x');
         // Draw right border
         drawLine(x1, y2, x1, y1, 'x');
         // Draw lower border
         drawLine(x2, y1, x1, y1, 'x');
      }
      System.out.print(this.toConsole());
   }

   private void validInput(List<String> args) throws InvalidInputException {
      if (args.size() < 4)
         throw new InvalidInputException("Rectangle requires 4 parameters");
      boolean result = isInteger(args.get(0)) && isInteger(args.get(1)) && isInteger(args.get(2))
            && isInteger(args.get(3));
      if (!result)
         throw new InvalidInputException("x1 y1 x2 y2 should be integer");
   }
}
