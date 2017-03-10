package democollections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
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
		// liste chainée: ajout/sup fréquente
		List<Cycliste> lkCyclistes = new LinkedList<>();

		// ajouter un cycliste
		lkCyclistes.add(c1);
		lkCyclistes.add(c2);

		// passage d'un type de liste à un autre.
		List<Cycliste> lstCyclistes2 = new ArrayList<>(lkCyclistes);

		// récupérer par index
		lkCyclistes.get(0);

		// parcourir les cyclistes
		for (Cycliste cycliste : lkCyclistes) {
			System.out.println(cycliste);
		}

		/*
		 * trier les cyclistes par hash ATTENTION IMPLEMENTER COMPARABLE !!
		 * methode compareTo
		 */
		Collections.sort(lkCyclistes);
		for (Cycliste cycliste : lkCyclistes) {
			System.out.println(cycliste);
		}

		/*
		 * trier la liste de cycliste par fréquence cardiaque => Comparator.
		 */
		Collections.sort(lkCyclistes, new FrequenceCardiaqueComparator());
		for (Cycliste cycliste : lkCyclistes) {
			System.out.println(cycliste);
		}

		/*
		 * trier la liste de cycliste par fréquence cardiaque => expression
		 * lambda.
		 */
		// version lourde
		Collections.sort(lkCyclistes, (Cycliste o1, Cycliste o2) -> {
			return Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque());
		});
		// version légère
		Collections.sort(lkCyclistes,
				(o1, o2) -> Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque()));
		for (Cycliste cycliste : lkCyclistes) {
			System.out.println(cycliste);
		}

		// Old school
		Calculable addition = new Calculable() {

			@Override
			public double calculer(double op1, double op2) {
				return op1 + op2;
			}
		};
		System.out.println(addition.calculer(2, 5));

		// Lamdda
		Calculable add = (op1, op2) -> op1 + op2;
		System.out.println(add.calculer(2, 5));

		// Iterator
		Iterator<Cycliste> it = lstCyclistes2.iterator();
		while (it.hasNext()) {
			Cycliste cycliste = (Cycliste) it.next();
			System.out.println(cycliste);
		}

		// attention identité de la classe
		System.out.println(lkCyclistes.contains(c2));

		// référence de méthode
		lstCyclistes2.forEach(System.out::println);

		// indexof attention à l'identité de la classe aussi.
		// il retourne la dernière occurence de la liste si occurences
		// multiples.
		lstCyclistes2.indexOf(c2);
	}

}
