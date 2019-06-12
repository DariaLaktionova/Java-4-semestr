package svg;

import java.util.HashMap;
import java.util.Map;

public class Tag {
     private Map<String, String> m = new HashMap<>();
     private String tagName;
     private TagType tagType;

    public Tag(String tagName) {
        this.tagName = tagName;
        this.tagType = TagType.OPEN_AND_CLOSE;
    }

     public Tag(String tagName, TagType tagType) {
         this.tagName = tagName;
         this.tagType = tagType;
     }

     public void set(String key, String value) {
        m.put(key, value);
     }

    public Map<String, String> getM() {
        return m;
    }

    public String getTagName() {
        return tagName;
    }

    public TagType getTagType() {
        return tagType;
    }
}
