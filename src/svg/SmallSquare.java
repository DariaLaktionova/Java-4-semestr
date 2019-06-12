package svg;

import java.util.Collections;
import java.util.List;

public class SmallSquare implements Shape {

    @Override
    public List<Tag> getTags() {
        Tag rect = new Tag("rect");
        rect.set("x", "-20");
        rect.set("y", "-20");
        rect.set("height", "40");
        rect.set("width", "40");
        rect.set("fill", "#00ffff");
        rect.set("stroke", "#004cff");
        rect.set("stroke-width", "1");

        return Collections.singletonList(rect);
    }
}
