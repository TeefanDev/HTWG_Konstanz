package aufgabe4;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Julian K.
 * @since 11.04.2022
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
	public Iterator<Element<T>> iterator() {
		return new ArrayListIterator();
	}
	private int size;
	private Element<T> fqTable[]; // oder nur <T> ??
	private final int DEFAULT_SIZE = 100;

	public ArrayFrequencyTable() { clear(); }

	@Override
	public int size() { return size; }

	@SuppressWarnings("unchecked")
	@Override
	public final void clear() {
		size = 0;
		fqTable = new Element[DEFAULT_SIZE];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(T w, int f) {
		for (int i = 0; i < size; i++) {
			if (fqTable[i].getElement().equals(w)) {
				fqTable[i].addFrequency(f);
				sort(i);
				return;
			}
		}
		if (fqTable.length <= size) {
			fqTable = Arrays.copyOf(fqTable, 2 * size);
		}
		fqTable[size] = new Element(w, f);
		sort(size);
		size++;
	}

	private void sort(int s) {
		Element<T> w = fqTable[s];
		while(s > 0 && fqTable[s-1].getFrequency() < w.getFrequency()) {
			fqTable[s] = fqTable[s-1];
			s--;
		}
		fqTable[s] = w;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Element<T> get(int pos) {
		if(pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		return (Element<T>) fqTable[pos];
	}

	@Override
	public int get(T w) {
		for(int i = 0; i < size; i++) {
			if(fqTable[i].getElement().equals(w)) {
				return fqTable[i].getFrequency();
			}
		}
		return 0;
	}

	private class ArrayListIterator implements Iterator<Element<T>> {
		private int i = 0;

		public boolean hasNext() {
			return i < size;
		}
		public Element next() {
			if (!hasNext()) {
				return null;
			}
			return fqTable[i++];
		}
	}
}