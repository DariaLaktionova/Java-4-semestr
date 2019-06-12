package svg;

public class ShapeFactory {

    public Shape create (String figureName) throws Exception {
        Class<?> cl = Class.forName(figureName);
        Shape shape = (Shape) cl.newInstance();
        return shape;
    }
}
