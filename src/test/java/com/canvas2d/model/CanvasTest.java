package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CanvasTest {
   @Test
   public void testDraw() {
      Canvas canvas = new Canvas();

      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("6");

      char[][] expected = { { '-', '-', '-', '-', '-' },
            { '|', 0, 0, 0, '|' },
            { '|', 0, 0, 0, '|' },
            { '|', 0, 0, 0, '|' },
            { '|', 0, 0, 0, '|' },
            { '|', 0, 0, 0, '|' },
            { '|', 0, 0, 0, '|' },
            { '-', '-', '-', '-', '-' } };
      canvas.draw(args);
      assertAll("Canvas information",
            ()->assertEquals(5, canvas.getWidth()),
            ()->assertEquals(6, canvas.getHeight()),
            ()->assertNotNull(canvas.getShape()),
            ()->assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.getShape())));
   }
}
