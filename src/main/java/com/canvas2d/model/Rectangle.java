package com.canvas2d.model;

import java.util.List;

public class Rectangle extends DrawBase {
   /**
    * Java doc
    * args has 4 items: (x1, y1) - (x2, y2)
    */
   public void draw(List<String> args) {
      int x1 = Integer.parseInt(args.get(0));
      int y1 = Integer.parseInt(args.get(1));
      int x2 = Integer.parseInt(args.get(2));
      int y2 = Integer.parseInt(args.get(3));
      // TODO: draw Rectangle
   }
}
