package com.canvas2d.model;

import java.util.List;

public class Rectangle extends DrawBase {
   /**
    * Java doc
    * args has 4 items: (x1, y1) - (x2, y2)
    */
   public void render(List<String> args) {
      int x1 = Integer.parseInt(args.get(0));
      int y1 = Integer.parseInt(args.get(1));
      int x2 = Integer.parseInt(args.get(2));
      int y2 = Integer.parseInt(args.get(3));
      // Draw upper border
      drawLine(x1, y1, x2, y1, 'x');
      // Draw left border
      drawLine(x1, y1, x1, y2, 'x');
      // Draw right border
      drawLine(x2, y1, x2, y2, 'x');
      // Draw lower border
      drawLine(x1, y2, x2, y2, 'x');
      System.out.print(this.toString());
   }
}
