package items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Categoty extends Throwable {

    private String name;
    private Categoty parent;
    private List<Categoty> childrenCategory = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int level = 1;

    public Categoty(String name) {
        if (DefaultCategory.categotyListName.size() == 0) {
            this.name = name;
            DefaultCategory.categotyListName.add(this);
        } else
            for (Categoty c :
                    DefaultCategory.categotyListName) {

                if (!name.equals(c.name)) {
                    this.name = name;
                    DefaultCategory.categotyListName.add(this);
                    break;
                } else throw new IllegalArgumentException("Такой каталог уже существует");

            }
    }

    public Categoty(String categoryName, Categoty parentCategory) {
        Iterator<Categoty> iterator = DefaultCategory.categotyListName.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().name.equals(categoryName)) {
                this.name = categoryName;
                DefaultCategory.categotyListName.add(this);
                this.setParent(parentCategory);
                break;
            } else throw new IllegalArgumentException("Такой каталог уже существует");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            parent.addChildCategory(this);
        }
    }

    public Categoty addChildCategory(Categoty childCategory) {
        childrenCategory.add(childCategory);
        return childCategory;
    }

    public void addItem(Item item) {
        items.add(item);
    }


}
