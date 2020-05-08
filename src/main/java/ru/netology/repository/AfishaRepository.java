package ru.netology.repository;

import ru.netology.domain.AfishaItem;

public class AfishaRepository {

    private AfishaItem[] items = new AfishaItem[0];

    public AfishaItem[] findAll() {
        return items;
    }

    public void save(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem findById(int id) {
        for (AfishaItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        AfishaItem[] tmp = new AfishaItem[length];
        int index = 0;
        for (AfishaItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new AfishaItem[0];
    }
}
