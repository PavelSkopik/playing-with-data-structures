package com.skopik.datastructures.lists;

public class SinglyLinkedList<E> implements SimpleList<E> {

    int size;
    Element<E> head;
    Element<E> tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        if (head != null && tail != null) {
            Element<E> last = new Element<>(element);
            tail.next = last;
            tail = last;
        }

        if (head == null) {
            head = new Element<>(element);
            tail = head;
        }

        size++;
    }

    @Override
    public void removeAt(int index) {
        if (index < 1 || index > size || head == null)
            throw new IndexOutOfBoundsException();

        int counter = 1;
        Element<E> current = head;
        Element<E> previous = null;

        while (current != null) {
            if (current == tail && current == head) {
                head = tail = null;
                size--;
                break;
            }

            if (current == tail) {
                previous.next = null;
                tail = previous;
                size--;
            }

            if (counter == index && current.next != null && previous != null) {
                previous.next = current.next;
                size--;
                break;
            }

            previous = current;
            current = current.next;
            counter++;
        }
    }

    @Override
    public E get(E element) {
        if (head == null || tail == null)
            return null;

        if (head.value.equals(element) || tail.value.equals(element))
            return element;

        Element<E> current = head.next;
        while (current != null) {
            if (current.value.equals(element))
                return element;

            current = current.next;
        }

        return null;
    }

    @Override
    public E getAt(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException();

        int counter = 1;
        Element<E> current = head;

        while (current != null) {
            if (counter == index)
                return current.value;

            current = current.next;
            counter++;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Element<T> {

        private T value;
        private Element<T> next;

        public Element(T value) {
            this.value = value;
        }

    }
}
