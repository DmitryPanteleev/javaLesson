package items;

import java.util.ArrayList;
import java.util.List;

public class Categoty {

    private String name;

    private Categoty parent;
    private List<Categoty> childrenCategory = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void setParent(Categoty parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChildCategory(Categoty childCategory) {
        childrenCategory.add(childCategory);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
