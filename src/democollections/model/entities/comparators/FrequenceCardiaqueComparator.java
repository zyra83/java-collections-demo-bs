package democollections.model.entities.comparators;

import java.util.Comparator;

import democollections.model.entities.Cycliste;

public class FrequenceCardiaqueComparator implements Comparator<Cycliste> {

	@Override
	public int compare(Cycliste o1, Cycliste o2) {
		return Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque());
	}

}
