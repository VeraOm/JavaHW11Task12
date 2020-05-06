package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository=new AfishaRepository();
    private AfishaItem item1 = new AfishaItem(1, "first", "http://", "");
    private AfishaItem item2 = new AfishaItem(2, "second", "http://", "");
    private AfishaItem item3 = new AfishaItem(3, "third", "http://", "");
    private AfishaItem item4 = new AfishaItem(4, "fourth", "http://", "");
    private AfishaItem item5 = new AfishaItem(5, "fifth", "http://", "");

    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
    }


    @Test
    void saveAndFindAllTest() {
        AfishaItem[] actual=repository.findAll();
        AfishaItem[] expected=new AfishaItem[]{item1, item2, item3, item4, item5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findByIdFoundTest() {
        AfishaItem actual=repository.findById(3);
        AfishaItem expected=item3;

        assertEquals(expected, actual);
    }

    @Test
    void findByIdNotFoundTest() {
        AfishaItem actual=repository.findById(7);

        assertNull(actual);
    }

    @Test
    void removeByIdTest() {
        repository.removeById(2);

        AfishaItem[] actual=repository.findAll();
        AfishaItem[] expected=new AfishaItem[]{item1, item3, item4, item5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByNotExistIdTest() {
        repository.removeById(10);

        AfishaItem[] actual=repository.findAll();
        AfishaItem[] expected=new AfishaItem[]{item1, item2, item3, item4, item5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();

        AfishaItem[] actual=repository.findAll();
        AfishaItem[] expected=new AfishaItem[0];

        assertArrayEquals(expected, actual);
    }
}