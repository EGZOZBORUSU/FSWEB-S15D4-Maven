package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<E extends Comparable<E>> extends ArrayList<E> {

    // Tekrar eden datayı engelleme
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            return super.add(e);
        }
        return false;
    }

    // Listeyi doğal sıralamasına (A-Z veya küçükten büyüğe) göre sıralama
    public void sort() {
        Collections.sort(this);
    }

    // Eleman silinince otomatik olarak tekrar sıralama
    @Override
    public boolean remove(Object o) {
        boolean isRemoved = super.remove(o);
        if (isRemoved) {
            this.sort();
        }
        return isRemoved;
    }
}
