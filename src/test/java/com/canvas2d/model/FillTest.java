package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.canvas2d.exception.InvalidInputException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FillTest {
   @Test
   public void testRender() throws InvalidInputException {
      // New canvas with width: 5, height: 6
      List<String> args = new ArrayList<>();
      char[][] array = {
         { '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 0, '|' },
         { '|', 'x', 0, 0, 'x', 0, '|' },
         { '|', 'x', 0, 0, 'x', 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-' }
      };

      Canvas canvas = Mockito.mock(Canvas.class);
      when(canvas.getWidth()).thenReturn(5);
      when(canvas.getHeight()).thenReturn(6);
      when(canvas.getShape()).thenReturn(array);

      Fill fill = new Fill();
      args.add("1");
      args.add("1");
      args.add("o");
      fill.setHeight(canvas.getHeight());
      fill.setWidth(canvas.getWidth());
      fill.setShape(canvas.getShape());
      fill.render(args);

      char[][] expected = {
         { '-', '-', '-', '-', '-', '-', '-' },
         { '|', 'o', 'o', 'o', 'o', 'o', '|' },
         { '|', 'x', 'x', 'x', 'x', 'o', '|' },
         { '|', 'x', 0, 0, 'x', 'o', '|' },
         { '|', 'x', 0, 0, 'x', 'o', '|' },
         { '|', 'x', 'x', 'x', 'x', 'o', '|' },
         { '|', 'o', 'o', 'o', 'o', 'o', '|' },
         { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Fill information",
            () -> assertEquals(5, fill.getWidth()),
            () -> assertEquals(6, fill.getHeight()),
            () -> assertNotNull(fill.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(fill.getShape())));

      // New canvas with width: 20, height: 4
      char[][] array1 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'x', 'x', 'x', 'x', 'x', 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, 0, 0, 0, 0, 0, 'x', 0, 0, 0, 'x', 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 'x', 'x', 'x', 'x', 'x', 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };

      when(canvas.getWidth()).thenReturn(20);
      when(canvas.getHeight()).thenReturn(4);
      when(canvas.getShape()).thenReturn(array1);

      args.clear();
      args.add("10");
      args.add("3");
      args.add("o");
      fill.setHeight(canvas.getHeight());
      fill.setWidth(canvas.getWidth());
      fill.setShape(canvas.getShape());
      fill.render(args);

      char[][] expected2 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'o', '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 0, 0, 0, 'x', 'o', 'o', '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'o', '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Fill information",
            () -> assertEquals(20, fill.getWidth()),
            () -> assertEquals(4, fill.getHeight()),
            () -> assertNotNull(fill.getShape()),
            () -> assertEquals(Arrays.deepToString(expected2), Arrays.deepToString(fill.getShape())));
   }

   @Test
   void exceptionParameterTesting() {
      Fill fill = new Fill();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      Throwable exception = assertThrows(InvalidInputException.class, () -> fill.render(args));
      assertEquals("Fill requires 3 parameters", exception.getMessage());
   }

   @Test
   void exceptionIsNotIntegerTesting() {
      Fill fill = new Fill();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("a");
      args.add("3");
      Throwable exception = assertThrows(InvalidInputException.class, () -> fill.render(args));
      assertEquals("x y c with (x,y) is integer and c is one letter", exception.getMessage());
   }

   @Test
   void exceptionIsNegativeIntegerTesting() {
      Fill fill = new Fill();
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("-6");
      args.add(".");

      Throwable exception = assertThrows(InvalidInputException.class, () -> fill.render(args));
      assertEquals("x1 y1 x2 y2 should be greater than 0", exception.getMessage());
   }

   @Test
   void exceptionOutOfHorizontalTesting() {
      Fill fill = new Fill();
      fill.setHeight(4);
      fill.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("30");
      args.add("6");
      args.add(".");

      Throwable exception = assertThrows(InvalidInputException.class, () -> fill.render(args));
      assertEquals("x1, x2 should be in range [1,20]", exception.getMessage());
   }

   @Test
   void exceptionOutOfVerticalTesting() {
      Fill fill = new Fill();
      fill.setHeight(4);
      fill.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("6");
      args.add(".");

      Throwable exception = assertThrows(InvalidInputException.class, () -> fill.render(args));
      assertEquals("y1, y2 should be in range [1,4]", exception.getMessage());
   }
}
