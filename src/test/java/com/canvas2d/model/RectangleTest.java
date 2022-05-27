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

public class RectangleTest {
   @Test
   public void testRender() throws InvalidInputException {
      // New canvas with width: 5, height: 6
      List<String> args = new ArrayList<>();
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

      Rectangle rect = new Rectangle();
      args.add("1");
      args.add("2");
      args.add("4");
      args.add("5");
      rect.setHeight(canvas.getHeight());
      rect.setWidth(canvas.getWidth());
      rect.setShape(canvas.getShape());
      rect.render(args);

      char[][] expected = {
         { '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 0, '|' },
         { '|', 'x', 0, 0, 'x', 0, '|' },
         { '|', 'x', 0, 0, 'x', 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Rectangle information",
            () -> assertEquals(5, rect.getWidth()),
            () -> assertEquals(6, rect.getHeight()),
            () -> assertNotNull(rect.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(rect.getShape())));

      // New canvas with width: 20, height: 4
      char[][] array1 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };

      when(canvas.getWidth()).thenReturn(20);
      when(canvas.getHeight()).thenReturn(4);
      when(canvas.getShape()).thenReturn(array1);
      args.clear();
      args.add("14");
      args.add("1");
      args.add("18");
      args.add("3");
      rect.setHeight(canvas.getHeight());
      rect.setWidth(canvas.getWidth());
      rect.setShape(canvas.getShape());
      rect.render(args);

      char[][] expected2 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'x', 'x', 'x', 'x', 'x', 0, 0, '|' },
         { '|', 'x', 'x', 'x', 'x', 'x', 'x', 0, 0, 0, 0, 0, 0, 0, 'x', 0, 0, 0, 'x', 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 'x', 'x', 'x', 'x', 'x', 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Rectangle information",
            () -> assertEquals(20, rect.getWidth()),
            () -> assertEquals(4, rect.getHeight()),
            () -> assertNotNull(rect.getShape()),
            () -> assertEquals(Arrays.deepToString(expected2), Arrays.deepToString(rect.getShape())));
   }

   @Test
   void exceptionParameterTesting() {
      Rectangle rect = new Rectangle();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      Throwable exception = assertThrows(InvalidInputException.class, () -> rect.render(args));
      assertEquals("Rectangle requires 4 parameters", exception.getMessage());
   }

   @Test
   void exceptionIsNotIntegerTesting() {
      Rectangle rect = new Rectangle();
      List<String> args = new ArrayList<>();
      args.add("1");
      args.add("2");
      args.add("3");
      args.add("a");
      Throwable exception = assertThrows(InvalidInputException.class, () -> rect.render(args));
      assertEquals("x1 y1 x2 y2 should be integer", exception.getMessage());
   }

   @Test
   void exceptionIsNegativeIntegerTesting() {
      Rectangle rect = new Rectangle();
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("6");
      args.add("3");
      args.add("-3");
      Throwable exception = assertThrows(InvalidInputException.class, () -> rect.render(args));
      assertEquals("x1 y1 x2 y2 should be greater than 0", exception.getMessage());
   }

   @Test
   void exceptionOutOfHorizontalTesting() {
      Rectangle rect = new Rectangle();
      rect.setHeight(4);
      rect.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("6");
      args.add("30");
      args.add("6");

      Throwable exception = assertThrows(InvalidInputException.class, () -> rect.render(args));
      assertEquals("x1, x2 should be in range [1,20]", exception.getMessage());
   }

   @Test
   void exceptionOutOfVerticalTesting() {
      Rectangle rect = new Rectangle();
      rect.setHeight(4);
      rect.setWidth(20);
      List<String> args = new ArrayList<>();
      args.add("2");
      args.add("1");
      args.add("20");
      args.add("6");

      Throwable exception = assertThrows(InvalidInputException.class, () -> rect.render(args));
      assertEquals("y1, y2 should be in range [1,4]", exception.getMessage());
   }
}
