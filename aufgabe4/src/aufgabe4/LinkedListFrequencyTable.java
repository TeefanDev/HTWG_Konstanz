package aufgabe4;

// import java.util.Arrays;

import java.util.Iterator;

/**
 *
 * @author Julian Klimek
 * @since 11.04.2022
 */

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    public Iterator<Element<T>> iterator() {
        return new LinkedListIterator();
    }

    private Node<T> begin;
    private Node<T> end;
    private int size;

    public LinkedListFrequencyTable() { clear(); }

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        Element data;

        Node(Element x, Node<T> n, Node<T> p) {
            data = x;
            next = n;
            prev = p;
        }
    }

    @Override
    public void clear() {
        begin = new Node<T>(null, null, null);
        end = new Node<T>(null, null, begin);
        begin.next = end;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @SuppressWarnings("unchecked")
    @Override
    public void add(T w, int f) {
        Node<T> p = begin.next;
        for (int i = 0; i < size; i++) {
            if (p.data.getElement().equals(w)) {
                p.data.addFrequency(f);
                sort(i);
                return;
            }
            p = p.next;
        }
        p = end.prev;
        Node<T> n = new Node<T>(new Element<T>(w, f), p.next, p);
        n.next.prev = n;
        p.next = n;
        sort(size);
        size++;
    }

    private void sort(int s) {
        Node<T> p = begin.next;
        for(int i = 0; i < s; i++) {
            p = p.next;
        }
        Element w = p.data;
        while(s > 0 && p.prev.data.getFrequency() < w.getFrequency()) {
            p.data = p.prev.data;
            s--;
            p = p.prev;
        }
        p.data = w;
    }

    @Override
    public Element get(int idx) {
        if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = begin.next;
        for(int i = 0; i < idx; i++) {
            p = p.next;
        }
        return p.data;
    }

    public int get(T w) {
        Node<T> p = begin.next;
        for(int i = 0; i < size; i++) {
            if(((Element<T>) p.data).getElement().equals(w)) {
                return p.data.getFrequency();
            }
            p = p.next;
        }
        return 0;
    }

    private class LinkedListIterator implements Iterator<Element<T>> {
        Node<T> p = begin;
        public boolean hasNext() {
            return p.next != end;
        }
        public Element next() {
            if (!hasNext()) {
                return null;
            }
            p = p.next;
            return p.data;
        }
    }

}