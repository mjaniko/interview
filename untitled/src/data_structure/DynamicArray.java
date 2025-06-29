package data_structure;

/**
 * Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.
 *
 * Your DynamicArray class should support the following operations:
 *
 * DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
 * int get(int i) will return the element at index i. Assume that index i is valid.
 * void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
 * void pushback(int n) will push the element n to the end of the array.
 * int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
 * void resize() will double the capacity of the array.
 * int getSize() will return the number of elements in the array.
 * int getCapacity() will return the capacity of the array.
 * If we call void pushback(int n) but the array is full, we should resize the array first.
 */
class DynamicArray {

    private int size; // Number of elements actually in the array
    private int capacity;
    private int[] items;

    public DynamicArray(int capacity) {
        if (capacity <= 0) return;
        this.items = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        if (i < 0 || i >= this.size) throw new IndexOutOfBoundsException();
        return this.items[i];
    }

    public void set(int i, int n) {
        if (i < 0 ) throw new IndexOutOfBoundsException();
        while (i >= capacity) {
            this.resize();
        }
        items[i] = n;

        // Update size if we're setting beyond current size
        if (i >= size) {
            size = i + 1;
        }
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        items[size++] = n;
    }

    public int popback() {
        if (size == 0) throw new IllegalStateException("Cannot pop from empty array");
        int value = items[--size];
        items[size] = 0;
        return value;
    }

    private void resize() {
        int newCapacity = capacity <= 0 ? 8 : capacity * 2;
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        capacity = newCapacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}

