package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public LinkedList<Figure> figures;

	public ZoneDeDessin(LinkedList<Figure> figures){
		this.figures = figures;
	}

	public void paint(Graphics g){
		super.paint(g);
		for(Figure f : figures) f.paint(g);
	}

	public void affichage(){
		Point p = new Point(10, 80, "A");

		Point p3 = new Point(150, 200, "A");
		Point p4 = new Point(3, 6,"B");
		Segment s = null;
		try {
			s = new Segment(p3,p4, "S");
		} catch (PointsConfondusException e1) {
			e1.printStackTrace();
		}

		Point p5 = new Point(220, 150, "A");
		Point p6 = new Point(260, 100,"B");
		Cercle c = new Cercle(p5,p6,"C");

		Point p7 = new Point(300,300, "A");
		Point p8 = new Point(350, 300,"B");
		Point p10 = new Point(350, 350, "C");
		Point p9 = new Point(300, 350,"D");

		Polygone poly = new Polygone("poli");
		poly.add(p7);
		poly.add(p8);
		poly.add(p9);
		poly.add(p10);

		figures.add(p);
		figures.add(s);
		figures.add(c);
		figures.add(poly);
	}

}
