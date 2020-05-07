package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.domain.PurchaseItem;

public class AfishaManager {

    private AfishaItem[] items = new AfishaItem[0];
    private int outItemCount = 10;

    public AfishaManager() {
    }

    public AfishaManager(int outItemCount) {
        if (outItemCount >= 0) {
            this.outItemCount = outItemCount;
        }
    }

    public AfishaItem[] getLast() {
        int count = items.length > outItemCount ? outItemCount : items.length;
        AfishaItem[] result = new AfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public AfishaItem[] getAll() {
        return items;
    }

    public void add(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

}
