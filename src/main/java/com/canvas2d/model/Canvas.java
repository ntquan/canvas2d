package com.canvas2d.model;

import java.util.List;

public class Canvas extends DrawBase {
   /**
    * Java doc
    * args has 2 items: width and height
    */
   @Override
   public void draw(List<String> args) {
      width = Integer.parseInt(args.get(0));
      height = Integer.parseInt(args.get(1));

      // Add +2 (upper and lower line)
      int newHeight = height + 2;
      shape = new char[newHeight][width];
      // Draw upper border
      drawLine(0, 0, width - 1, 0, '-');
      // Draw left border
      drawLine(0, 1, 0, newHeight - 1, '|');
      // Draw right border
      drawLine(width - 1, 1, width - 1, newHeight - 1, '|');
      // Draw lower border
      drawLine(0, newHeight - 1, width - 1, newHeight - 1, '-');

      System.out.print(this.toString());

   }
}
