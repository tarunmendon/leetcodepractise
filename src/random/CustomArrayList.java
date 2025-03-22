package src.random;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomArrayList<E> {

    int DEFAULT_CAPACITY = 10;
    E[] element;
    int size = 0;

    public CustomArrayList() {
        element = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        element = (E[]) new Object[capacity];
    }

    public void add(E element) {
        /*increase size*/
        if (size == this.element.length) {
            resize();
        }
        this.element[size++] = element;

    }

    private void resize() {
        int newSize = element.length * 2;
        System.out.println("Resizing - New Size"+newSize);;
        this.element = Arrays.copyOf(this.element, newSize);
    }

    public E get(int index) {
        validateIndex(index);

        return this.element[index];
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Range not correct");
        }
    }

    public void delete(int index) {
        validateIndex(index);
        for (int i = index; i < size - 1; i++) {
            this.element[i] = this.element[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        return (size == 0) ? "[]" :
                "[" + IntStream.range(0, size).mapToObj(i -> String.valueOf(this.element[i])).reduce((val1, val2) -> val1 + "," + val2).get() + "]";
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>(5);
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.toString());
        System.out.println("Value at index 1:"+list.get(1));
        list.add(40);
        list.add(50);
        list.add(60);
        System.out.println(list.toString());
        list.delete(1);
        list.delete(2);
        System.out.println(list.toString());
    }
}
