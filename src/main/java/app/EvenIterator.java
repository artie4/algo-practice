package app;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final List<Integer> collection;
    private int index;

    public EvenIterator(List<Integer> _collection) {
        this.collection = _collection;
    }

    @Override
    public boolean hasNext() {
        for (int i = index + 1; i < collection.size(); i++) {
            if (collection.get(i) % 2 == 0) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Integer next() {
        for (int i = index; i < collection.size(); i++) {
            Integer integer = collection.get(i);
            if (integer % 2 == 0) {
                index = i + 1;
                return integer;
            }
        }
        throw new NoSuchElementException();
    }
}
