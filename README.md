# L'objet List et ses implémentations
L'interface List hérite de Collection, par conséquent toutes ses implémentations s'utilisent avec les mêmes méthodes.
La déclaration d'une List utilise l'opérateur diamant pour préciser le type d'objet que pourra contenir la liste.
Avant Java 7 on type le diamant à la déclaration et à la construction, ici il découvre seul son type.
```java
List<Cycliste> (lst|lk)Cyclistes;
```

## ArrayList
```java
List<Cycliste> lstCyclistes = new ArrayList<>();
```

## LinkedList
La LinkedList est à utiliser en priorié en cas d'ajouts/suppression fréquents d'éléments en milieu de liste.

```java
List<Cycliste> lkCyclistes = new LinkedList<>();
```

## Utilisation
### Ajout
```
lkCyclistes.add(c1);
lkCyclistes.add(c2);
lkCyclistes.add(c3);
```
### Passage d'un type de List à l'autre
```
List<Cycliste> lkCyclistes =  new LinkedList<>();
List<Cycliste> lstCyclistes = new ArrayList<>(lkCyclistes);
```
### récupération d'un élément de la liste
Sur les ArrayList et les LinkedList, un élément peut se récupérer par son index.
```
lkCyclistes.get(0);
```
### Parcourir une List
// parcourir la liste de Cyclistes sans tri.
```
for (Cycliste cycliste : lkCyclistes) {
	System.out.println(cycliste);
}
```
### Trier une liste
#### Avec le tri naturel des objets *Comparable*
**L'objet doit implémenter Comparable.**
Le tri comparable se base sur l'identité de l'objet et utilise sa méthode ```compareTo``` pour le tri.
La méthode ```compareTo``` doit être cohérente avec les méthodes ```equals``` et ```hashCode```.
```
Collections.sort(lkCyclistes);
```
#### Avec le tri basé sur un attribut autre que l'identité de l'objet grâce à un *Comparator*
Ici on crée une classe qui implémente Comparator et sera capable de trier les objets sur tel ou tel attribut.
**Se base sur l’implémentation d'un Comparator.**
```
// Déclaration de la classe Comparator
public class FrequenceCardiaqueComparator implements Comparator<Cycliste> {
	@Override
	public int compare(Cycliste o1, Cycliste o2) {
		return Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque());
	}
}
// Utilisation du Comparator
Collections.sort(lkCyclistes, new FrequenceCardiaqueComparator());
```

/*
* Depuis Java 8.
* parcourir la liste de Cycliste avec l'utilisation de lambdas. 
* - lambdas en syntaxe lourde et en syntaxe réduite.
* - le code d'une lambda n'est pas réutilisable (si le même tri doit être fait plusieurs fois, envisager un Comparator)
*/
System.out.println("3. Trié par lambda");

/*
* version lourde (multiligne : accolades, type les arguments, mettre un
* return)
*/
Collections.sort(lkCyclistes, (Cycliste o1, Cycliste o2) -> {
// multiligne
System.out.println("Je suis une lambda multiligne.");
return Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque());
});

/*
* Version légère (multiligne impossible, typage des arguments
* automatique, pas besoin du return et pas d'accolades)
*/
Collections.sort(lkCyclistes, (o1, o2) -> Integer.compare(o1.getFrequenceCardiaque(), o2.getFrequenceCardiaque()));

// affichage
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

//////////////////////////
// Functional Interface //
//////////////////////////

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

//////////////
// LES SET //
//////////////

Set<Cycliste> monSettest = new TreeSet<Cycliste>(lstCyclistes2);

// Collection d'instances uniques (au sens d'equals).
Set<Cycliste> set = new HashSet<>();

System.out.println(set.add(c1));
System.out.println(set.add(c2));
// c3 s'apelle fifi comme c2
System.out.println(set.add(c3));

for (Cycliste cycliste : set) {
System.out.println(cycliste);
}

for (int i = 0; i < set.size(); i++) {
// Set s = set.get(); PAS D'INDICE SUR LES SET
// pas d'indexOf non plus
}

Iterator it2 = set.iterator();
while (it2.hasNext()) {
Cycliste cycliste = (Cycliste) it2.next();
System.out.println(cycliste);
}

/*
* Les set ne sont pas triés par défaut, la liste sort en vrac. Pour les
* trier on a le SortedSet implémenté dans TreeSet ici collection de
* cyclistes uniques triés par ordre alphabétique de nom car compareTo
* compare les noms.
*/
SortedSet<Cycliste> sset = new TreeSet<>(set);
sset.forEach(System.out::println);

//////////////
// LES MAPS //
//////////////

/*
* LES MAPS : couples clés/valeurs Elles se manipullent de maière
* totalement différence des "Collection" - clé unique
* 
*/
Map<String, String> mapAcro = new HashMap<>();
mapAcro.put("SNCF", "Société Nationale des Chemins de Fer");
mapAcro.put("LED", "Light Emmiting Diode");
mapAcro.put("LED", "Light Emmiting ...");
mapAcro.put("RADAR", "Ranging...");

for (String cle : mapAcro.keySet()) {
System.out.printf("%s => %s %n", cle, mapAcro.get(cle));
}

// LinkedHashMap : il est trié
Map<String, String> mapAcro2 = new LinkedHashMap<>();
mapAcro2.put("SNCF", "Société Nationale des Chemins de Fer");
mapAcro2.put("LED", "Light Emmiting Diode");
mapAcro2.put("LED", "Light Emmiting ...");
mapAcro2.put("RADAR", "Ranging...");

for (String cle : mapAcro2.keySet()) {
System.out.printf("%s => %s %n", cle, mapAcro2.get(cle));
}

Map<Integer, Cycliste> mapCyclistes = new HashMap<>();
mapCyclistes.put(3, c3);
mapCyclistes.put(1, c1);
mapCyclistes.put(2, c2);

// Parcours d'une map
for (Integer cle : mapCyclistes.keySet()) {
System.out.printf("%s => %s %n", cle, mapCyclistes.get(cle));
}

// Autre façon de parcourir en ayant juste les valeurs.
Collection<String> valeurs = mapAcro.values();
valeurs.forEach(System.out::println);

}

}
