package democollections.model.entities;

import java.time.LocalDate;

public class Cycliste implements Comparable<Cycliste> {

	private String nom;
	private int frequenceCardiaque;
	private LocalDate dernierDepistage;

	public Cycliste() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getFrequenceCardiaque() {
		return frequenceCardiaque;
	}

	public void setFrequenceCardiaque(int frequenceCardiaque) {
		this.frequenceCardiaque = frequenceCardiaque;
	}

	public LocalDate getDernierDepistage() {
		return dernierDepistage;
	}

	public void setDernierDepistage(LocalDate dernierDepistage) {
		this.dernierDepistage = dernierDepistage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cycliste [nom=");
		builder.append(nom);
		builder.append(", frequenceCardiaque=");
		builder.append(frequenceCardiaque);
		builder.append(", dernierDepistage=");
		builder.append(dernierDepistage);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cycliste other = (Cycliste) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cycliste o) {
		/*
		 * Pas de choix que comparer des cyclistes sur leur nom car l'identité
		 * est fondée sur le nom. ATTENTION VERIFIER o != null
		 */
		if (o != null) {
			// pas besoin de passer par le getNom
			return nom.compareTo(o.nom);
		}
		return -1;
	}

}
