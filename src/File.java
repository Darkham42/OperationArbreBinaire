class File {
	protected Cellule entree, sortie;

	// Le constructeur par défaut
	public File() {
		entree = null;
		sortie = null;
	}

	public boolean estVide() {
		return sortie == null;
	}

	public void entrer(Object x) {
		Cellule n = new Cellule(x);
		if (estVide()) {
			entree = n;
			sortie = n;
		} else {
			entree.setSuivant(n);
			entree = n;
		}
	}

	public Object sortir() {
		// / on suppose que le méthode sortie n'est pas appelée si la file est
		// vide
		if (estVide())
			throw new Error("La file d'attente est vide");

		Object o = sortie.getObject();
		if (entree == sortie) {
			entree = null;
			sortie = null;
		} else {
			sortie = sortie.getSuivant();
		}
		return (o);
	}

	// public void afficher(){
	// Cellule p=sortie;
	// System.out.println("#################");
	// System.out.println("Entree="+ entree);
	// System.out.println("Sortie="+ sortie);
	// while (p!=null){
	// System.out.println("valeur=" + p.getObject()+
	// " suivant "+p.getSuivant());
	// p=p.getSuivant();
	// }
	// }

	public void afficher() {
		Cellule p = sortie;
		System.out.println("#################");
		System.out.println("Entree=" + entree);
		System.out.println("Sortie=" + sortie);
		while (p != null) {
			System.out.println("Sortie :" + p + "   valeur="
					+ ((ArbreBinaire) p.getObject()).etiquette() + " suivant "
					+ p.getSuivant());
			p = p.getSuivant();
		}
	}

	public static void main(String arg[]) {
		File f = new File();
		f.entrer("E1");
		f.entrer("E2");
		f.entrer("E3");

		f.afficher();

		System.out.println((String) f.sortir());
		System.out.println((String) f.sortir());
		f.afficher();
		System.out.println((String) f.sortir());
		System.out.println(f.estVide());
		f.entrer("E4");
		f.afficher();

		System.out.println((String) f.sortir());
		System.out.println(f.estVide());
		System.out.println((String) f.sortir());
	}

}

class Cellule {
	protected Object objet;
	protected Cellule suivant;

	public Cellule(Object o) {
		objet = o;
		suivant = null;
	}

	public Object getObject() {
		return objet;
	}

	public Cellule getSuivant() {
		return suivant;
	}

	public void setSuivant(Cellule n) {
		suivant = n;
	}

}