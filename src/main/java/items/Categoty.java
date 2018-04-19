package items;

import java.util.ArrayList;
import java.util.List;

public class Categoty extends Throwable {

    private String name;
    private Categoty parent;
    private List<Categoty> childrenCategory = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int level = 1;

    public Categoty(String name) {
        if (this.equals(DefaultCategory.categotyListName.iterator())) {
            this.name = name;
            DefaultCategory.categotyListName.add(this);
        }else return;
    }

    public int getLevel() {
        return level;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setParent(Categoty parent) {

        if (parent.level + 1 > 5) {
            throw new IllegalArgumentException("Нельзя назаначить категорию больше уровня 5");
        } else {
            this.parent = parent;
            this.level = parent.level + 1;
        }
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
