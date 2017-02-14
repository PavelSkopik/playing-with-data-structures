package com.skopik.datastructures.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;

    @Before
    public void setUp() {
        this.list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void getSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void add() {
        assertEquals(new Integer(1), list.getAt(1));
        assertEquals(new Integer(3), list.getAt(3));
    }

    @Test
    public void removeAt(){
        list.removeAt(3);
        assertEquals(2, list.size());
        assertEquals(new Integer(2), list.getAt(list.size()));

        list.removeAt(2);
        assertEquals(1, list.size());

        list.removeAt(1);
        assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtOutOfBounds(){
        list.removeAt(7);
    }

    @Test
    public void getAt(){
        assertEquals(new Integer(2), list.getAt(2));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void getAtOutOfBounds(){
        list.getAt(7);
    }

    @Test
    public void get(){
        assertEquals(new Integer(2), list.get(2));
        assertNull(list.get(5));
    }


    @Test
    public void removeMiddleElementInRandomlySizedList() {
        SinglyLinkedList<Integer> randomSizeList = createList();
        int originalSize = randomSizeList.size();
        int middleEntryIndex = originalSize / 2;

        System.out.println("SimpleList size: " + randomSizeList.size());
        System.out.println("Middle entry index (rounded down): " + middleEntryIndex);

        assertEquals(new Integer(middleEntryIndex), randomSizeList.getAt(middleEntryIndex));

        randomSizeList.removeAt(middleEntryIndex);

        assertEquals(originalSize - 1, randomSizeList.size());
        assertEquals(new Integer(middleEntryIndex + 1), randomSizeList.getAt(middleEntryIndex));
    }

    private static SinglyLinkedList<Integer> createList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int size = getRandomInteger();

        for (int i = 0; i < size; i++) {
            list.add(i + 1);
        }

        return list;
    }

    private static int getRandomInteger() {
        int number = (int) ((Math.random() + 1) * 7);
        return number == 0 || number == 1 || number / 2 == 0 ? getRandomInteger() : number;
    }

}
