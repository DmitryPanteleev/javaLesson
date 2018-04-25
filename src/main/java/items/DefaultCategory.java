package items;

import java.util.ArrayList;
import java.util.List;

public class DefaultCategory {

    public static List<Categoty> categotyListName = new ArrayList();


    //Create default category
    public Categoty device = new Categoty("Device");
    public Categoty computer = new Categoty("Computer");
    public Categoty tv = new Categoty("TV");
    public Categoty hd = new Categoty("HD");
    public Categoty fullHd = new Categoty("FullHD");
    public Categoty mac = new Categoty("Mac");
    public Categoty windows = new Categoty("Win");

    public DefaultCategory() {
        setDefaultCategory();
        addChildrenCategory();
    }

    private void setDefaultCategory() {

        computer.setParent(device);
        mac.setParent(computer);
        windows.setParent(computer);
        tv.setParent(device);
        hd.setParent(tv);
        fullHd.setParent(tv);
    }

    private void addChildrenCategory() {

        device.addChildCategory(computer);
        device.addChildCategory(tv);
        computer.addChildCategory(mac);
        computer.addChildCategory(windows);
        tv.addChildCategory(hd);
        tv.addChildCategory(fullHd);

    }
}
