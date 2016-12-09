package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author freshloic
 *
 */

public class Triangle extends Polygone {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4256290225673351646L;
	private Point p1, p2, p3;

	public Triangle(Point p1, Point p2, Point p3){
		Sommets = new LinkedList<Point>();
		Sommets.add(p1);
		Sommets.add(p2);
		Sommets.add(p3);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Triangle(Point p1, Point p2) { this(p1,p2,null); }

	public double getLongueurX(Point p1, Point p2) { return p1.distanceX(p2);}

	public double getLongueurY(Point p1, Point p2) { return p1.distanceY(p2);}

	public void translater(double dx, double dy) {
		int x1 = (int) p1.getX();
		int x2 = (int) p2.getX();

		int y1 = (int) p1.getY();
		int y2 = (int) p2.getY();

		int x3 = (int) Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
		int y3 = (int) Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2));

		setP3(new Point(x3,y3));

		p2.translater(dx  + getLongueurX(p2,p1), dy  + getLongueurY(p2,p1));
		p3.translater(dx  + getLongueurX(p3,p1), dy  + getLongueurY(p3,p1));
		p1.translater(dx, dy);
	}

	public String toString(){ return getNom() +":[ "+ p1.toString() + ";" + p2.toString() + p3.toString() + "]"; }

	public Point getP2() { return p2; }

	public void setP2(Point p2) { this.p2 = p2; }

	public Point getP3() {
		int x1 = (int) p1.getX();
		int x2 = (int) p2.getX();

		int y1 = (int) p1.getY();
		int y2 = (int) p2.getY();

		int x3 = (int) Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
		int y3 = (int) Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2));
		return new Point(x3,y3); 
	}

	public void setP3(Point p3) { this.p3 = p3; }

	public boolean equals(Triangle t){
		if(t != null)
			return (this.p1.equals(t.p1) && this.p2.equals(t.p2) && this.p3.equals(t.p3))
					|| (this.p1.equals(t.p2) && this.p2.equals(t.p1) && this.p3.equals(t.p2))
					|| (this.p1.equals(t.p3) && this.p2.equals(t.p3) && this.p3.equals(t.p1));
		else
			return false;
	}

	public LinkedList<Point> getPoints() {
		LinkedList<Point> liste = new LinkedList<Point>();
		liste.add(this.p1);
		liste.add(this.p2);
		liste.add(getP3());
		return liste;
	}

	public void paint(Graphics gc) {

		int x1 = (int) p1.getX();
		int x2 = (int) p2.getX();

		int y1 = (int) p1.getY();
		int y2 = (int) p2.getY();

		int x3 = (int) Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
		int y3 = (int) Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2));

		if(getCouleur() != null) gc.setColor(getCouleur());
		gc.fillPolygon(new int[] {x1, x2, x3},new int[] {y1, y2, y3}, 3);

	}

	public Object cloner(){
		Triangle t = null;
		try {
			t = (Triangle) super.clone();
			t.Sommets = new LinkedList<Point>();
			t.Sommets.add((Point) p1.cloner());
			t.Sommets.add((Point) p2.cloner());
			t.Sommets.add((Point) getP3().cloner());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return t;
	}
}
