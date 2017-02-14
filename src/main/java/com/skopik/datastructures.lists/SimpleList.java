package com.skopik.datastructures.lists;

/**
 * An interface for a minimal generic list.
 *
 * @param <E> Type.
 */
public interface SimpleList<E> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element Element to add.
     */
    void add(E element);

    /**
     * Removes an element at a specified index.
     *
     * @param index Index of the element.
     *
     * @throws IndexOutOfBoundsException
     */
    void removeAt(int index);

    /**
     * Returns the specified element.
     * @param element Element to retrieve.
     * @return Element or null;
     */
    E get(E element);

    /**
     * Removes an element at the specified index.
     *
     * @param index Index.
     *
     * @return Element with the specified index.
     * @throws IndexOutOfBoundsException
     */
    E getAt(int index);

    /**
     * Returns size of the list.
     *
     * @return Size.
     */
    int size();

}
