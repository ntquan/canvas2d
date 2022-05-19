package com.canvas2d;

import java.util.ArrayList;
import java.util.List;

import com.canvas2d.model.Canvas;
import com.canvas2d.model.DrawBase;
import com.canvas2d.model.Line;
import com.canvas2d.model.Rectangle;

public class ConsoleFactory {
   private DrawBase shape;

   public DrawBase getShape(String type) {
      if (type == null)
         return null;

      if (type.equals("C")) {
         return new Canvas();
      } else if (type.equals("L")) {
         return new Line();
      } else if (type.equals("R")) {
         return new Rectangle();
      }
      return null;
   }

   public void create(String cmd) {
      String[] outputArr = cmd.split(" ");
      String shapeType = outputArr[0].toUpperCase();
      List<String> args = new ArrayList<String>();
      for (int i = 1; i < outputArr.length; i++) {
         args.add(outputArr[i]);
      }
      DrawBase newShape = getShape(shapeType);
      // Assign old value to current console
      // TODO: should check input Canvas at the first time
      if (shape != null) {
         System.out.println(shape.getHeight());
         System.out.println(shape.getWidth());
         newShape.setHeight(shape.getHeight());
         newShape.setWidth(shape.getWidth());
         newShape.setShape(shape.getShape());
      }

      shape = newShape;
      shape.draw(args);
   }
}
