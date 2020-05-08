package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {

    @Mock
    private AfishaRepository repository;

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


    @Test
    void getLastLessZeroOutCount() {
        AfishaItem[] mockCover = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(mockCover).when(repository).findAll();

        manager = new AfishaManager(repository, -1);

        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastZeroOutCount() {
        AfishaItem[] mockCover = new AfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();

        manager = new AfishaManager(repository, 0);

        AfishaItem[] expected = new AfishaItem[0];
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastLessOutCount() {
        AfishaItem[] mockCover = new AfishaItem[]{item1, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();

        manager = new AfishaManager(repository);

        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3, item1};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void getLastEqualOutCount() {
        AfishaItem[] mockCover = new AfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();

        manager = new AfishaManager(repository, 5);

        AfishaItem[] allItems = manager.getAll();
        AfishaItem[] expected = new AfishaItem[allItems.length];
        for (int i = 0; i < allItems.length; i++) {
            expected[i] = allItems[allItems.length - i - 1];
        }

        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository, times(2)).findAll();
    }

    @Test
    void getLastMoreOutCount() {
        AfishaItem[] mockCover = new AfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockCover).when(repository).findAll();

        manager = new AfishaManager(repository, 3);

        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void add() {
        doNothing().when(repository).save(any(AfishaItem.class));

        manager = new AfishaManager(repository);
        manager.add(item1);
        manager.add(item2);

        verify(repository, times(1)).save(item2);
        verify(repository, times(1)).save(item1);
    }

}