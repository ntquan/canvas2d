package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.canvas2d.exception.InvalidInputException;

import org.junit.jupiter.api.Test;

public class CanvasTest {
   @Test
   public void testRender() throws InvalidInputException {
      // New canvas with width: 5, height: 6
      Canvas canvas = new Canvas();
      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("6");
      canvas.render(args);

      char[][] expected = {
         { '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Canvas information",
            () -> assertEquals(5, canvas.getWidth()),
            () -> assertEquals(6, canvas.getHeight()),
            () -> assertNotNull(canvas.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.getShape())));

      // New canvas with width: 20, height: 4
      args.clear();
      args.add("20");
      args.add("4");
      canvas.render(args);
      char[][] expected2 = {
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|' },
         { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
      };
      assertAll("Canvas information",
            () -> assertEquals(20, canvas.getWidth()),
            () -> assertEquals(4, canvas.getHeight()),
            () -> assertNotNull(canvas.getShape()),
            () -> assertEquals(Arrays.deepToString(expected2), Arrays.deepToString(canvas.getShape())));
   }

   @Test
   void exceptionParameterTesting() {
      Canvas canvas = new Canvas();
      List<String> args = new ArrayList<>();
      args.add("5");
      Throwable exception = assertThrows(InvalidInputException.class, () -> canvas.render(args));
      assertEquals("Canvas requires 2 parameters", exception.getMessage());
   }

   @Test
   void exceptionIsNotIntegerTesting() {
      Canvas canvas = new Canvas();
      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("a");
      Throwable exception = assertThrows(InvalidInputException.class, () -> canvas.render(args));
      assertEquals("w h should be integer", exception.getMessage());
   }

   @Test
   void exceptionIsNegativeIntegerTesting() {
      Canvas canvas = new Canvas();
      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("-3");
      Throwable exception = assertThrows(InvalidInputException.class, () -> canvas.render(args));
      assertEquals("width w and height h should be greater than 0", exception.getMessage());
   }
}
