package democollections.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "nom" })
// attention avec Lombok le toString fait des + à la place des buffers
@ToString
// constructeur vide de bean
@NoArgsConstructor
public class Cycliste implements Serializable, Comparable<Cycliste> {

	@Getter
	@Setter
	String nom;

	@Getter
	@Setter
	String prenom;

	@Getter
	@Setter
	int frequenceCardiaque;

	@Getter
	@Setter
	LocalDate dernierDepistage;

//	List<Velo> lstVelo;
//
//	/**
//	 * On préfère ça sinon lombok renvoi direct un accès à la référence de la
//	 * liste de vélos de l'objet.
//	 * 
//	 * @return
//	 */
//	public List<Velo> getLstVelo() {
//		return Collections.unmodifiableList(lstVelo);
//	}
//
//	/**
//	 * Permet d'ajouter 1 à X vélos
//	 * 
//	 * @param velos
//	 */
//	public void ajouterVelo(Velo... velos) {
//		for (Velo velo : velos) {
//			lstVelo.add(velo);
//		}
//	}

	@Override
	public int compareTo(Cycliste o) {
		/*
		 * Pas de choix que comparer des cyclistes sur leur nom car l'identité
		 * est fondée sur le nom. ATTENTION VERIFIER o != null
		 */
		if (o != null) {
			// pas besoin de passer par le getNom
			return getNom().compareTo(o.getNom());
		}
		return -1;
	}

}
