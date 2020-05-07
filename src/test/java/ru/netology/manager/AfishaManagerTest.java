package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    private AfishaManager manager;
    private AfishaItem item1 = new AfishaItem(1, "first", "http://", "");
    private AfishaItem item2 = new AfishaItem(2, "second", "http://", "");
    private AfishaItem item3 = new AfishaItem(3, "third", "http://", "");
    private AfishaItem item4 = new AfishaItem(4, "fourth", "http://", "");
    private AfishaItem item5 = new AfishaItem(5, "fifth", "http://", "");
    private AfishaItem item6 = new AfishaItem(6, "sixth", "http://", "");
    private AfishaItem item7 = new AfishaItem(7, "seventh", "http://", "");
    private AfishaItem item8 = new AfishaItem(8, "eigth", "http://", "");
    private AfishaItem item9 = new AfishaItem(9, "ninth", "http://", "");
    private AfishaItem item10 = new AfishaItem(10, "tenth", "http://", "");
    private AfishaItem item11 = new AfishaItem(11, "last", "http://", "");

    private void fillFirstData() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
    }

    @Test
    void getLastLessZeroOutCount() {
        manager = new AfishaManager(-1);
        fillFirstData();

        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastZeroOutCount() {
        manager = new AfishaManager(0);
        fillFirstData();

        AfishaItem[] expected = new AfishaItem[0];
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastLessOutCount() {
        manager = new AfishaManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3, item2, item1};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastEqualOutCount() {
        manager = new AfishaManager(11);
        fillFirstData();

        AfishaItem[] allItems = manager.getAll();
        AfishaItem[] expected = new AfishaItem[allItems.length];
        for (int i = 0; i < allItems.length; i++) {
            expected[i] = allItems[allItems.length - i - 1];
        }

        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastMoreOutCount() {
        manager = new AfishaManager(3);
        fillFirstData();

        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        manager = new AfishaManager(5);
        fillFirstData();

        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};

        assertArrayEquals(expected, actual);
    }
}