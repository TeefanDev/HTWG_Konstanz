package aufgabe1;

import java.util.Arrays;

/**
 *
 * @author Stefan Ptacek
 * @since 25.03.2022
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
	private int size;
	private Word fqTable[];
	private final int DEFAULT_SIZE = 100;

	public ArrayFrequencyTable() {
        clear();
    }
	
	@Override
	public int size() {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		return size;
	}

	@Override
	public final void clear() {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code: 
		size = 0;
		fqTable = new Word[DEFAULT_SIZE];
	}

	@Override
	public void add(String w, int f) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		int k = 0;
		for (int i = 0; i < size; i++) {
			if (fqTable[i].getWord().equals(w)) {
				fqTable[i].addFrequency(f);
				sort(i);
				return;
			}
		}
		if (fqTable.length <= size) {
			fqTable = Arrays.copyOf(fqTable, 2 * size);
		}
		fqTable[size] = new Word(w, f);
		sort(size);
		size++;
	}

	private void sort(int s) {
		Word w = fqTable[s];
		while(s > 0 && fqTable[s-1].getFrequency() < w.getFrequency()) {
			fqTable[s] = fqTable[s-1];
			s--;
		}
		fqTable[s] = w;
	}


	@Override
	public Word get(int pos) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		int frequency = 0;
		String word;
		if(pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		return fqTable[pos];
	}

	@Override
	public int get(String w) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		int frequency = 0;
		for(int i = 0; i < size; i++) {
			if(fqTable[i].getWord().equals(w)) {
				return fqTable[i].getFrequency();
			}
		}
		return 0;
	}
}
