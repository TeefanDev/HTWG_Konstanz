package aufgabe1;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(String w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		// Ihr Code:
		int n = fq.size();
		for(int i = 0; i < n; i++) {
			this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable fq) {
		// Ihr Code:
		fq.clear();
		int i = 0;
		fq.add(get(i).getWord(), get(i).getFrequency());
		while(get(i).getFrequency() == get(i+1).getFrequency()) {
			fq.add(get(i+1).getWord(), get(i+1).getFrequency());
			i++;
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable fq) {
		// Ihr Code:
		fq.clear();
		int i = size()-1;
		fq.add(get(i-1).getWord(), get(i-1).getFrequency());
		while(get(i).getFrequency() == get(i-1).getFrequency()) {
			fq.add(get(i).getWord(), get(i).getFrequency());
			i--;
		}
		//for(int i = size()-1; i > 0; i--) {
		//	if(get(i-1).getFrequency() == get(i).getFrequency()) {
		//		fq.add(get(i).getWord(), get(i).getFrequency());
		//	} else {
		//		break;
		//	}
		//}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");
		s.append("{");
		for (int i = 0; i < size(); i++) {
			s.append(get(i)).append(", ");
		}
		s.append("} ");
		s.append("size = ").append(size());
		return s.toString();
	}
}
