package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

enum Color { Red, Yellow, Blue, Green }

public class PyramidRubiksCube {
    private Map<String, Color[]> tips;
    private Map<String, Color[]> faces;
    private Map<String, Color[]> edges;

    public PyramidRubiksCube() {
        tips = new HashMap<String, Color[]>();
        faces = new HashMap<String, Color[]>();
        edges = new HashMap<String, Color[]>();

        initializeTips();
        initializeFaces();
        initializeEdges();
    }

    private void initializeTips() {
        // each tip has 3 colors and there are 4 tips
        tips.put("Tip1", new Color[]{Color.Red, Color.Yellow, Color.Green});
        tips.put("Tip2", new Color[]{Color.Blue, Color.Yellow, Color.Green});
        tips.put("Tip3", new Color[]{Color.Blue, Color.Yellow, Color.Green});
        tips.put("Tip4", new Color[]{Color.Red, Color.Blue, Color.Green});
    }

    private void initializeFaces() {
        Color[] faceColors = Color.values();

        // initialize 4 faces
        for (int i = 0; i < 4; i++) {
            String faceKey = "Face" + (i + 1);
            Color faceColor = faceColors[i];

            // initialize 9 tiles per face
            for (int j = 0; j < 9; j++) {
                Color[] tiles = new Color[9];
                Arrays.fill(tiles, faceColor);
                faces.put(faceKey, tiles);
            }
        }
    }

    private void initializeEdges() {
        // 6 edges are initialized
        edges.put("Edge1", new Color[]{Color.Yellow, Color.Blue});
        edges.put("Edge2", new Color[]{Color.Yellow, Color.Green});
        edges.put("Edge3", new Color[]{Color.Yellow, Color.Red});
        edges.put("Edge4", new Color[]{Color.Red, Color.Blue});
        edges.put("Edge5", new Color[]{Color.Red, Color.Green});
        edges.put("Edge6", new Color[]{Color.Green, Color.Blue});
    }

    private boolean validateCube() {
        if (faces.isEmpty()) {
            return false;
        }

        // assigns a count to each color, to ensure there is 9 of each
        Map<Color, Integer> colorCount = new HashMap<>();

        for (Color color : Color.values()) {
            colorCount.put(color, 0);
        }

        // count tiles on faces
        for (Color[] tiles : faces.values()) {
            for (Color tile : tiles) {
                colorCount.put(tile, colorCount.get(tile) + 1);
            }
        }

        for (Color color : Color.values()) {
            if (colorCount.get(color) != 9) {
                return false;
            }
        }

        return true; // All faces have 9 tiles
    }

    public static void main(String[] args) {
        PyramidRubiksCube pyraminx = new PyramidRubiksCube();
        System.out.print(pyraminx.validateCube()); // should return true
    }
}