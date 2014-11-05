public class ArbreBinaire implements ArbreElem {

	Object e;
	ArbreBinaire Droite, Gauche;

	public ArbreBinaire(double d) {
		this.e = d;
		this.Droite = null;
		this.Gauche = null;
	}

	public ArbreBinaire(char str, ArbreBinaire Droite, ArbreBinaire Gauche) {
		this.e = str;
		this.Droite = Droite;
		this.Gauche = Gauche;
	}

	public String getEtiquette() {
		return this.e.toString();
	}

	public ArbreElem getGauche() {
		return this.Gauche;
	}

	public ArbreElem getDroite() {
		return this.Droite;
	}

	public boolean estFeuille() {
		if (this.Droite == null && this.Gauche == null)
			return true;
		else
			return false;
	}

	public double result() {
		if (this.estFeuille())
			return (double) this.e;
		else {
			switch ((char) this.e) {
			case '+':
				return (this.Gauche.result() + this.Droite.result());

			case '-':
				return (this.Gauche.result() - this.Droite.result());

			case '/':
				if ( this.Gauche.result() == 0 || this.Droite.result() == 0) {
					System.out.println("Impossible de diviser par 0");
					return 0;
				}
				else
					return (this.Gauche.result() / this.Droite.result());

			case '*':
				return (this.Gauche.result() * this.Droite.result());
			}
		}
		return 0;
	}

	public boolean search(double n) {
		return false;
	}

	public static void main(String[] args) {
		ArbreBinaire tree = new ArbreBinaire('*',
				new ArbreBinaire('+', new ArbreBinaire('/',
						new ArbreBinaire(3), new ArbreBinaire(9)),
						new ArbreBinaire(5)), new ArbreBinaire('/',
						new ArbreBinaire(2), new ArbreBinaire('+',
								new ArbreBinaire(7), new ArbreBinaire(5))));

		System.out.println("Resultat de l'arbre binaire : " + tree.result());
	}

}