package democollections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import democollections.model.entities.Cycliste;
import democollections.model.entities.comparators.FrequenceCardiaqueComparator;

public class Lanceur {

	public static void main(String[] args) {
		Cycliste c1 = new Cycliste();
		c1.setNom("riri");
		c1.setDernierDepistage(LocalDate.of(2017, 01, 01));
		c1.setFrequenceCardiaque(210);

		Cycliste c2 = new Cycliste();
		c2.setNom("fifi");
		c2.setDernierDepistage(LocalDate.of(2017, 01, 02));
		c2.setFrequenceCardiaque(100);

		// Avant Java 7 on type aussi le new
		// List<Cycliste> lstCyclistes = new ArrayList<Cycliste>();
		// Depuis java 7
		List<Cycliste> lstCyclistes = new ArrayList<>();

		// ajouter un cycliste
		lstCyclistes.add(c1);
		lstCyclistes.add(c2);

		// récupérer par index
		lstCyclistes.get(0);

		// parcourir les cyclistes
		for (Cycliste cycliste : lstCyclistes) {
			System.out.println(cycliste);
		}

		/*
		 * trier les cyclistes par hash ATTENTION IMPLEMENTER COMPARABLE !!
		 * methode compareTo
		 */
		Collections.sort(lstCyclistes);
		for (Cycliste cycliste : lstCyclistes) {
			System.out.println(cycliste);
		}

		/*
		 * trier la liste de cycliste par fréquence cardiaque => Comparator.
		 */
		Collections.sort(lstCyclistes, new FrequenceCardiaqueComparator());
		for (Cycliste cycliste : lstCyclistes) {
			System.out.println(cycliste);
		}

	}

}
