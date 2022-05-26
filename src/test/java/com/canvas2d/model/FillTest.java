package com.canvas2d.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FillTest {
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

      Fill fill = new Fill();
      args.clear();
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
      assertAll("Canvas information",
            () -> assertEquals(5, fill.getWidth()),
            () -> assertEquals(6, fill.getHeight()),
            () -> assertNotNull(fill.getShape()),
            () -> assertEquals(Arrays.deepToString(expected), Arrays.deepToString(fill.getShape())));
   }
}
