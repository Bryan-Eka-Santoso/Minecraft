import java.util.*;

public class Inventory<T> {
    private ArrayListSaya<T> items;
    private ArrayListSaya<Integer> qty;

    public Inventory() {
        items = new ArrayListSaya<>();
        qty = new ArrayListSaya<>();
    }

    public void addItem(T item) {
        items.add(item);
        qty.add(0);
    }

    public void qtyAdd(int i) {
        int qtyBaru = qty.get(i) + 1;
        qty.set(i, qtyBaru);
    }

    public void qtyMin(int i) {
        int qtyBaru = qty.get(i) - 1;
        qty.set(i, qtyBaru);
    }
    
    public void removeItem(T item) {
        items.remove(item);
    }

    public T getItem(int i) {
        return items.get(i);
    }

    public int getQty(int i) {
        return qty.get(i);
    }

    public void displayItems() {
        System.out.println("Materials:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" - %-12s x%d\n", items.get(i) + ": ", qty.get(i));
        }
    }    
}