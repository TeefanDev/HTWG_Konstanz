package aufgabe4;

/**
 *
 * @author Julian Klimek
 * @since 11.04.22
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(T w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		int n = fq.size();
		//for(var x: fq) {
		for(Element<? extends T> x: fq) {
			this.add(x.getElement(), x.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable<? super T> fq) {
		fq.clear();
		if (this.isEmpty())
			return;
		int f = this.get(0).getFrequency();
		for (Element<T> x : this)
			if (x.getFrequency() == f)
				fq.add(x.getElement(),x.getFrequency());
		/*int i = 0;
		fq.add((T) get(i).getElement(), get(i).getFrequency());
		while(get(i).getFrequency() == get(i+1).getFrequency()) {
			fq.add((T) get(i+1).getElement(), get(i+1).getFrequency());
			i++;
		}*/
	}

	@Override
	public void collectLeastFrequent(FrequencyTable<? super T> fq) {
		fq.clear();
		if(this.isEmpty())
			return;
		int f = this.get(size()-1).getFrequency();
		for (Element<? extends T> x : this)
			if(x.getFrequency() == f)
				fq.add(x.getElement(), x.getFrequency());
		/*int i = size()-1;
		fq.add((T) get(i-1).getElement(), get(i-1).getFrequency());
		while(get(i).getFrequency() == get(i-1).getFrequency()) {
			fq.add((T) get(i).getElement(), get(i).getFrequency());
			i--;
		}*/
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
