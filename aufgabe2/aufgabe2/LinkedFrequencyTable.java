package aufgabe2;

import java.util.Arrays;

/**
 * @author Stefan Ptacek
 * @since 30.03.2022
 */

public class LinkedFrequencyTable extends AbstractFrequencyTable {

    private Node begin;
    private Node end;
    private int size;

    public LinkedFrequencyTable() {
        clear();
    }

    private static class Node {
        private Node next;
        private Node prev;
        private Word data;

        public Node(Word x, Node n, Node p) {
            data = x;
            next = n;
            prev = p;
        }
    }

    @Override
    public int size() {
        // throw muss noch auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        return this.size;
    }

    @Override
    public final void clear() {
        // throw muss noch auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        begin = new Node(null, null, null);
        end = new Node(null, null, begin);
        begin.next = end;
        size = 0;
    }
    @Override
    public void add(String w, int f) {
        // throw muss noch auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        Node p = begin.next;
        for(int i = 0; i < size; i++) {
            if (p.data.getWord().equals(w)) {
                p.data.addFrequency(f);
                sort(i);
                return;
            }
            p = p.next;
        }
        p = end.prev;
        Node n = new Node(new Word(w, f), p.next, p);
        n.next.prev = n;
        p.next = n;
        sort(size);
        size++;
    }

    private void sort(int s) {
        Node p = begin.next;
        for(int i = 0; i < s; i++) {
            p = p.next;
        }
        Word w = p.data;
        while(s > 0 && p.prev.data.getFrequency() < w.getFrequency()) {
            p.data = p.prev.data;
            s--;
            p = p.prev;
        }
        p.data = w;
    }


    @Override
    public Word get(int pos) {
        // throw muss noch auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        if(pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node p = begin.next;
        for(int i = 0; i < pos; i++) {
            p = p.next;
        }
        return p.data;
    }

    @Override
    public int get(String w) {
        // throw muss noch auskommentiert werden!
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // Ihr Code:
        Node p = begin.next;
        for(int i = 0; i < size; i++) {
            if(p.data.getWord().equals(w)) {
                return p.data.getFrequency();
            }
            p = p.next;
        }
        return 0;
    }
}