package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LineTest {
   @Test
   public void testRender() {
      Canvas canvas = new Canvas();

      List<String> args = new ArrayList<>();
      args.add("5");
      args.add("6");
      canvas.render(args);

      Line line = new Line();
      args.clear();
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
      assertAll("Canvas information",
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
   }
}
