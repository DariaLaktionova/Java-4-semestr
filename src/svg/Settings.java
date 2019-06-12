package svg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class Settings {
    private static Settings instance = new Settings();
    private static Properties p = new Properties();
    private static int width;
    private static int height;
    private static String background;
    private static Random random;
    private static String draw;

    public static Settings getInstance() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8));
            width = Integer.parseInt(p.getProperty("width"));
            background = p.getProperty("background");
            height = Integer.parseInt(p.getProperty("height"));
            draw = p.getProperty("draw");

            String randSeed = p.getProperty("rand_seed");
            if (randSeed.equals("auto"))
                random = new Random();
            else
                random = new Random(Long.parseLong(randSeed));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static String getBackground() {
        return background;
    }

    public static Random getRandom() {
        return random;
    }

    public String getShapeDescription(String figureName) {
        return p.getProperty("shape." + figureName);
    }

    public Map<String, Integer> getShapeWithCount() {
        Map<String, Integer> oneShapeOneCount = new HashMap<>();

        String arrayOfShapeWithCounts[] = draw.split(" ");
        for (String shapeWithCount : arrayOfShapeWithCounts) {
            int delenie = shapeWithCount.indexOf(":");
            String key = shapeWithCount.substring(0, delenie);
            int value = Integer.parseInt(shapeWithCount.substring(delenie + 1));
            oneShapeOneCount.put(key, value);

        }

        return oneShapeOneCount;
    }
}
