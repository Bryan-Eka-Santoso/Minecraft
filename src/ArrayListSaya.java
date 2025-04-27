public class ArrayListSaya<V> {
    Data<V>[] daftar;
    int size;
    int capacity;

    @SuppressWarnings("unchecked")
    public ArrayListSaya() {
        size = 0;
        capacity = 10000;
        daftar = new Data[capacity];
    }

    public void set(int key, V value) {
        Data<V> baru = new Data(size, value);
        daftar[key] = baru;
    }

    public void add(V value) {
        if (size + 1 < capacity) {
            Data<V> baru = new Data(size, value);
            daftar[size] = baru;
            size++; 
        } else {
            System.out.println("Index out of bond");
        }
    }

    public void add(int key, V value) {
        if (size == 0) {
            add(value);
        } else {
            if (size + 1 < capacity) {
                for (int i = size; i >= 0; i--) {
                    daftar[i + 1] = daftar[i];
                }
                Data<V> baru = new Data(size, value);
                daftar[key] = baru;
                size++;
            } 
        }
    }

    public V get(int key) {
        return daftar[key].value;
    }

    public void remove(V value) {
        for (int i = 0; i < size; i++) { 
            if (daftar[i].value.equals(value)) {
                for (int j = i; j < size - 1; j++) {
                    daftar[j] = daftar[j + 1];
                }
                size--;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            if (daftar[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            daftar[i].value = null;
            size--;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("[" + (i) + "]" + " => " + "<" + daftar[i].value + ">");
        }
    }
}
