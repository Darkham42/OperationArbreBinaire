interface ArbreElem {
	public String getEtiquette();

	// retourne un String representant l'etiquette du noeud

	public ArbreElem getGauche();

	// retourne une reference sur le sous-arbre gauche

	public ArbreElem getDroite();
	// retourne une reference sur le sous-arbre droit
}