package items;

import java.util.ArrayList;
import java.util.List;

public class Categoty {

    private String name;
    private Categoty parent;
    private List<Categoty> childrenCategory = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int level = 1;

    public Categoty(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setParent(Categoty parent) {
        this.parent = parent;
        this.level = parent.level + 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoty addChildCategory(Categoty childCategory) {
        childrenCategory.add(childCategory);
        return childCategory;
    }

    public void addItem(Item item) {
        items.add(item);
    }


}
