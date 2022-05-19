package com.canvas2d.model;

import java.util.List;

public abstract class DrawBase {
   protected int width;
   protected int height;
   protected char[][] shape;

   /**
    * Java doc
    */
   public int getWidth() {
      return width;
   }

   /**
    * Java doc
    */
   public void setWidth(int w) {
      width = w;
   }

   /**
    * Java doc
    */
   public int getHeight() {
      return width;
   }

   /**
    * Java doc
    */
   public void setHeight(int h) {
      height = h;
   }

   /**
    * Java doc
    */
   public char[][] getShape() {
      return shape;
   }

   /**
    * Java doc
    */
   public void setShape(char[][] shape) {
      this.shape = shape;
   }

   /**
    * Draw from position (x1, y1) to position (x2, y2) by any letter (etter)
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

   @Override
   public String toString() {
      StringBuilder output = new StringBuilder();
      // System.out.println("Debug + " + shape.length);
      for (int i = 0; i < shape.length; i++) {
         for (int j = 0; j < shape[i].length; j++) {
            output.append((shape[i][j]) == 0 ? " " : shape[i][j]);
         }
         output.append("\n");
      }
      return output.toString();
   }

   /**
    * Output directly output to console
    */
   public void toConsole() {
      for (int i = 0; i < shape.length; i++) {
         for (int j = 0; j < shape[i].length; j++) {
            if (shape[i][j] == 0)
               System.out.print("*");
            else
               System.out.print(shape[i][j]);
         }
         System.out.println("");
      }
   }

   public abstract void draw(List<String> args);
}
