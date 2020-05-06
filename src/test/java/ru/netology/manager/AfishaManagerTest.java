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

    private void fillFirstData() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
    }

    @Test
    void getLastLessZeroOutCount() {
        manager = new AfishaManager(-1);
        fillFirstData();

        AfishaItem[] expected = new AfishaItem[0];
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
        fillFirstData();

        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3, item2, item1};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastEqualOutCount() {
        manager = new AfishaManager(5);
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

        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        manager = new AfishaManager();
        fillFirstData();

        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{item1, item2, item3, item4, item5};

        assertArrayEquals(expected, actual);
    }
}