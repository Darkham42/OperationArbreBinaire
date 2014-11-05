import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArbreDessin extends JFrame {

	private JPanel arbdess;
	private static int num = 0;

	ArbreDessin(ArbDessin td) {
		Container pane;
		setTitle("Affichage Arbre" + num++);
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = getContentPane();
		pane.setLayout(new GridLayout(1, 1));

		JPanel arbdess = new JPanel();
		arbdess.setLayout(new GridLayout(1, 1));
		arbdess.add(td);
		pane.add(arbdess);

		setVisible(true);
	}

	public static void dessinerArbre(ArbreElem tree) {
		ArbDessin td = new ArbDessin(tree);
		JFrame f = new ArbreDessin(td);
	}
}

class ArbDessin extends Canvas {
	ArbreElem myTree;
	static final int RADIUS = 20;
	static final int V = 40;

	ArbDessin(ArbreElem tree) {
		myTree = tree;
	}

	public void paint(Graphics g) {
		dessinerSousArbre(g, myTree, (int) (getWidth() / 2), getWidth(), 1);
	}

	private static Color gray = new Color((float) 0.8, (float) 0.8, (float) 0.8);

	public void dessinerSousArbre(Graphics g, ArbreElem tree, int x, int width,
			int level) {
		g.setFont(g.getFont().deriveFont((float) 18.0));
		g.setColor(gray);
		g.fillOval(x - RADIUS, (level * V) - RADIUS, RADIUS * 2, RADIUS * 2);
		g.setColor(Color.black);
		int w = g.getFontMetrics().stringWidth(tree.getEtiquette());
		int h = g.getFontMetrics().getHeight();
		g.drawString(tree.getEtiquette(), x - (int) (w / 2), (level * V)
				+ (int) (h / 4));
		if (tree.getGauche() != null) {
			g.drawLine(x - RADIUS, level * V, x - (int) (width / 4),
					(level + 1) * V);
			dessinerSousArbre(g, tree.getGauche(), x - (int) (width / 4),
					(int) (width / 2), level + 1);
		}
		if (tree.getDroite() != null) {
			g.drawLine(x + RADIUS, level * V, x + (int) (width / 4),
					(level + 1) * V);
			dessinerSousArbre(g, tree.getDroite(), x + (int) (width / 4),
					(int) (width / 2), level + 1);
		}
	}
}