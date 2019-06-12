package svg;

import java.util.Map;
import java.util.Random;

public class Drawing {
    public static void main(String[] args) {

        Tag rect1 = new Tag("rect");
        rect1.set("x", "10");
        rect1.set("y", "10");
        rect1.set("height", "100");
        rect1.set("width", "100");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");

        Tag rect2 = new Tag("rect");
        rect2.set("x", "20");
        rect2.set("y", "20");
        rect2.set("height", "100");
        rect2.set("width", "100");
        rect2.set("style", "stroke:#ff0000; fill: #00ff00");

        Tag g = new Tag("g", TagType.OPEN);
        g.set("transform", "translate(150, 150)");
        Tag gClose = new Tag("g", TagType.CLOSE);

        try (SVG svg = new SVG("b.svg", Settings.getInstance().getWidth(), Settings.getInstance().getHeight())) {

            Random random = Settings.getInstance().getRandom();
            ShapeFactory shapeFactory = new ShapeFactory();

            Map<String, Integer> oneShapeOneCount = Settings.getInstance().getShapeWithCount();

            oneShapeOneCount.forEach((key, value) -> {

                String figureName = key;
                String figureNameDescription = Settings.getInstance().getShapeDescription(figureName);
                try {
                    Shape figureShape = shapeFactory.create(figureNameDescription);


                    for (int i = 0; i < value; i++) {
                        PositionedShape nShape = new PositionedShape(figureShape,
                                random.nextInt(Settings.getInstance().getWidth()),
                                random.nextInt(Settings.getInstance().getHeight()));
                        nShape.draw(svg);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

  /*Shape nShape = new SmallSquare();
            nShape.draw(svg);

            svg.addTag(rect1);
            svg.addTag(rect2);
            svg.addTag(g);
            svg.addTag(rect1);
            svg.addTag(rect2);
            svg.addTag(gClose);

            PositionedShape nShape1 = new PositionedShape(new RedCircle(),50, 50);
            nShape1.draw(svg);*/
