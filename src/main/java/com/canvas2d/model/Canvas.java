package com.canvas2d.model;

import java.util.List;

public class Canvas extends DrawBase {
   /**
    * Java doc
    * args has 2 items: width and height
    */
   @Override
   public void render(List<String> args) {
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

      System.out.print(this.toString());

   }
}
