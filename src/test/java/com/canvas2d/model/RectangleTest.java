package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RectangleTest {
   @Test
   public void testRender() {
      Canvas canvas = new Canvas();

      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("6");

      canvas.render(args);

      Rectangle rect = new Rectangle();
      args.clear();
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
      assertAll("Canvas information",
            () -> assertEquals(5, rect.getWidth()),
            () -> assertEquals(6, rect.getHeight()),
            () -> assertNotNull(rect.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(rect.getShape())));
   }
}
