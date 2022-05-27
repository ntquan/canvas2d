package com.canvas2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.canvas2d.exception.InvalidInputException;
import com.canvas2d.model.Canvas;
import com.canvas2d.model.DrawBase;
import com.canvas2d.model.Fill;
import com.canvas2d.model.Line;
import com.canvas2d.model.Rectangle;

public class ConsoleFactory {
   private DrawBase shape;

   public DrawBase createShape(String type) {
      if (type == null)
         return null;

      switch (type) {
         case "C":
            return new Canvas();
         case "L":
            return new Line();
         case "R":
            return new Rectangle();
         case "B":
            return new Fill();
      }
      return null;
   }

   public void create(String cmd) throws InvalidInputException {
      String[] outputArr = cmd.split(" ");
      String shapeType = outputArr[0].toUpperCase();
      if (shapeType.equals("Q")) {
         throw new InvalidInputException("Exit Application");
      }
      // the Canvas must be created at the first time
      if (shape == null && !shapeType.equals("C"))
         throw new InvalidInputException("Canvas must be created at the first time");
      DrawBase newShape = createShape(shapeType);
      if (newShape == null)
         throw new InvalidInputException("Command is is invalid");

      List<String> args = new ArrayList<>(Arrays.asList(outputArr));
      // remove type of command in argument
      args.remove(0);
      // Assign old value to current console
      if (shape != null) {
         newShape.setHeight(shape.getHeight());
         newShape.setWidth(shape.getWidth());
         newShape.setShape(shape.getShape());
      }

      try {
         newShape.render(args);
         shape = newShape;
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}
