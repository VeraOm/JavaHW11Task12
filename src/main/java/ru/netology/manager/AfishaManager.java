package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private AfishaRepository repository;
    private int outItemCount = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository=repository;
    }

    public AfishaManager(AfishaRepository repository, int outItemCount) {
        this.repository=repository;
        this.outItemCount = outItemCount;
    }

    public AfishaItem[] getLast() {
        AfishaItem[] items=repository.findAll();
        int count = items.length > outItemCount ? outItemCount : items.length;
        AfishaItem[] result = new AfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public AfishaItem[] getAll() {
        return repository.findAll();
    }

    public void add(AfishaItem item) {
        repository.save(item);
    }

}
