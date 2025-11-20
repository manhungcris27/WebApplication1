package murach.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<LineItem> getItems() { return items; }

    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();

        for (LineItem li : items) {
            if (li.getProduct().getCode().equals(code)) {
                li.setQuantity(li.getQuantity() + quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        items.removeIf(li -> li.getProduct().getCode().equals(code));
    }
}
