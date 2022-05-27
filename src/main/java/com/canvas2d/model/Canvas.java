package com.canvas2d.model;

import java.util.List;

import com.canvas2d.exception.InvalidInputException;

public class Canvas extends DrawBase {
   /**
    * Java doc
    * args has 2 items: width and height
    *
    */
   @Override
   public void render(List<String> args) throws InvalidInputException {
      validInput(args);
      width = Integer.parseInt(args.get(0));
      height = Integer.parseInt(args.get(1));

      // Add +2 (upper, lower line and left right line)
      shape = new char[height + 2][width + 2];
      // Draw upper border
      drawLine(0, 0, width + 1, 0, '-');
      // Draw left border
      drawLine(0, 1, 0, height + 1, '|');
      // Draw right border
      drawLine(width + 1, 1, width + 1, height + 1, '|');
      // Draw lower border
      drawLine(0, height + 1, width + 1, height + 1, '-');

      System.out.print(this.toConsole());
   }

   private void validInput(List<String> args) throws InvalidInputException {
      if (args.size() < 2)
         throw new InvalidInputException("Canvas requires 2 parameters");
      boolean result = isInteger(args.get(0)) && isInteger(args.get(1));
      if (!result)
         throw new InvalidInputException("w h should be integer");
      int positive = Integer.parseInt(args.get(0)) * Integer.parseInt(args.get(1));
      if (positive <= 0)
         throw new InvalidInputException("width w and height h should be greater than 0");
   }
}
