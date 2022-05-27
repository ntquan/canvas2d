package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.Mockito;

import com.canvas2d.exception.InvalidInputException;

import org.junit.jupiter.api.Test;

public class LineTest {
   @Test
   public void testRender() throws InvalidInputException {
      // New canvas with width: 5, height: 6
      char[][] array = {
         { '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-' }
      };

      Canvas canvas = Mockito.mock(Canvas.class);
      when(canvas.getWidth()).thenReturn(5);
      when(canvas.getHeight()).thenReturn(6);
      when(canvas.getShape()).thenReturn(array);

      Line line = new Line();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      args.add("3");
      args.add("2");
      line.setHeight(canvas.getHeight());
      line.setWidth(canvas.getWidth());
      line.setShape(canvas.getShape());
      line.render(args);

      char[][] expected = {
            { '-', '-', '-', '-', '-', '-', '-' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 'x', 'x', 'x', 0, 0, '|' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Line information",
            () -> assertEquals(5, line.getWidth()),
            () -> assertEquals(6, line.getHeight()),
            () -> assertNotNull(line.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(line.getShape())));

      args.clear();
      args.add("1");
      args.add("2");
      args.add("1");
      args.add("5");
      line.render(args);

      char[][] expected2 = {
            { '-', '-', '-', '-', '-', '-', '-' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 'x', 'x', 'x', 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertEquals(Arrays.deepToString(expected2), Arrays.deepToString(line.getShape()));

      args.clear();
      args.add("2");
      args.add("6");
      args.add("5");
      args.add("6");
      line.render(args);

      char[][] expected3 = {
         { '-', '-', '-', '-', '-', '-', '-' },
            { '|', 0, 0, 0, 0, 0, '|' },
            { '|', 'x', 'x', 'x', 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 'x', 0, 0, 0, 0, '|' },
            { '|', 0, 'x', 'x', 'x', 'x', '|' },
            { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertEquals(Arrays.deepToString(expected3), Arrays.deepToString(line.getShape()));

      // New canvas with width: 20, height: 4
      char[][] array1 = {
              { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
              { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
              { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
              { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
              { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      when(canvas.getWidth()).thenReturn(20);
      when(canvas.getHeight()).thenReturn(4);
      when(canvas.getShape()).thenReturn(array1);

      args.clear();
      args.add("1");
      args.add("2");
      args.add("6");
      args.add("2");
      line.setHeight(canvas.getHeight());
      line.setWidth(canvas.getWidth());
      line.setShape(canvas.getShape());
      line.render(args);

      char[][] expected4 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      assertEquals(Arrays.deepToString(expected4), Arrays.deepToString(line.getShape()));

      args.clear();
      args.add("6");
      args.add("3");
      args.add("6");
      args.add("4");
      line.render(args);

      char[][] expected5 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      assertEquals(Arrays.deepToString(expected5), Arrays.deepToString(line.getShape()));
   }

   @Test
   void exceptionParameterTesting() {
      Line line = new Line();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("Line requires 4 parameters", exception.getMessage());
   }

   @Test
   void exceptionIsNotIntegerTesting() {
      Line line = new Line();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      args.add("3");
      args.add("a");
      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("x1 y1 x2 y2 should be integer", exception.getMessage());
   }

   @Test
   void exceptionIsNegativeIntegerTesting() {
      Line line = new Line();
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("6");
      args.add("3");
      args.add("-3");
      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("x1 y1 x2 y2 should be greater than 0", exception.getMessage());
   }

   @Test
   void exceptionOutOfHorizontalTesting() {
      Line line = new Line();
      line.setHeight(4);
      line.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("6");
      args.add("30");
      args.add("6");

      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("x1, x2 should be in range [1,20]", exception.getMessage());
   }

   @Test
   void exceptionOutOfVerticalTesting() {
      Line line = new Line();
      line.setHeight(4);
      line.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("1");
      args.add("20");
      args.add("6");

      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("y1, y2 should be in range [1,4]", exception.getMessage());
   }

   @Test
   void exceptionInvalidLineTesting() {
      Line line = new Line();
      line.setHeight(4);
      line.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("1");
      args.add("10");
      args.add("3");

      Throwable exception = assertThrows(InvalidInputException.class, () -> line.render(args));
      assertEquals("Only support horizontal and vertical lines", exception.getMessage());
   }
}
