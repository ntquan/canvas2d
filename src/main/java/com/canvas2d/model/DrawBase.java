package com.canvas2d.model;

import java.util.List;

import com.canvas2d.exception.InvalidInputException;

public abstract class DrawBase {
   protected int width;
   protected int height;
   protected char[][] shape;

   /**
    * get width
    */
   public int getWidth() {
      return width;
   }

   /**
    * set width
    */
   public void setWidth(int w) {
      width = w;
   }

   /**
    * get height
    */
   public int getHeight() {
      return height;
   }

   /**
    * set height
    */
   public void setHeight(int h) {
      height = h;
   }

   /**
    * get shape
    */
   public char[][] getShape() {
      return shape;
   }

   /**
    * set shape
    */
   public void setShape(char[][] shape) {
      this.shape = shape;
   }

   /**
    * Draw from position (x1, y1) to position (x2, y2) by any letter (enter)
    */
   public void drawLine(int x1, int y1, int x2, int y2, char drawLetter) {
      if (x1 == x2) {
         // Draw vertical line
         for (int i = y1; i <= y2; i++) {

            shape[i][x1] = drawLetter;
         }
      }
      if (y1 == y2) {
         // Draw horizontal line
         for (int i = x1; i <= x2; i++) {
            shape[y1][i] = drawLetter;
         }
      }
   }

   public String toConsole() {
      StringBuilder output = new StringBuilder();
      // System.out.println("Debug + " + shape.length);
      for (char[] chars : shape) {
         for (char aChar : chars) {
            output.append(aChar == 0 ? " " : aChar);
         }
         output.append("\n");
      }
      return output.toString();
   }

   /**
    * Check integer
    */
   protected boolean isInteger(String str) {
      return str.matches("-?\\d+?");
   }

   /**
    * Valid the (x, y) in render of canvas
    */
   protected void validRender(int x1, int y1, int x2, int y2) throws InvalidInputException {
      if (x1 <=0 || x2 <=0 || y1 <= 0 || y2 <=0)
         throw new InvalidInputException("x1 y1 x2 y2 should be greater than 0");

      if (x1 > width || x2 > width)
         throw new InvalidInputException("x1, x2 should be in range [1," + width + "]");
      if (y1 > height || y2 > height)
         throw new InvalidInputException("y1, y2 should be in range [1," + height + "]");
   }

   public abstract void render(List<String> args) throws InvalidInputException;
}
