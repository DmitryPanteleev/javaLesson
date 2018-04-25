package items;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private static List<Item> items = new ArrayList<>();

    public static List<Item> getItems() {
        return items;
    }

    public static void setItem(Item item) {
        items.add(item);
    }

    public static void toStringS() {
        for (Item item :
                items) {
            System.out.println(item.getName());
        }
    }

    public static Item getItem(String name){

        for (Item item : items) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }
}
