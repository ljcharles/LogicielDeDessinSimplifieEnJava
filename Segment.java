package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author freshloic
 *
 */
public class Segment extends Figure {

	private static final long serialVersionUID = -8647029111111835870L;
	private Point p1 , p2;

	/**
	 * @param p1
	 * @param p2
	 * @param nom
	 */
	public Segment(Point p1, Point p2, String nom){
		this.p1 = p1;
		this.p2 = p2;
		this.setNom(nom);
	}

	public Segment(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	/* (non-Javadoc)
	 * @see monpremierprojet.Figure#afficher()
	 */
	public void afficher()
	{
		System.out.println(toString());
	}

	public String toString(){
		return getNom() +":[ "+ p1.toString() + ";" + p2.toString() + "]";
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public double getLongueur() {
		return p2.distance(p1);
	}

	public double getLongueurX() {
		return p2.distanceX(p1);
	}

	public double getLongueurY() {
		return p2.distanceY(p1);
	}

	public void translater(double dx, double dy) {
		p2.translater(dx  + getLongueurX(), dy  + getLongueurY());
		p1.translater(dx, dy);
	}

	public Point getCentre() {
		return new Point((p1.getX() + p2.getX())/2,(p1.getY()+p2.getY())/2,"Centre");

	}

	public LinkedList<Point> getPoints() {
		LinkedList<Point> liste = new LinkedList<Point>();
		liste.add(this.p1);
		liste.add(this.p2);
		return liste;
	}

	public boolean equals(Segment s){
		if(s != null)
			return (this.p1.equals(s.p1) && this.p2.equals(s.p2))
					|| (this.p1.equals(s.p2) && this.p2.equals(s.p1));
		else
			return false;
	}

	public Object cloner(){
		Segment ob = null;
		try {
			ob = (Segment) super.clone();
			((Segment) ob).p1 = (Point) this.p1.cloner();
			((Segment) ob).p2 = (Point) this.p2.cloner();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ob;
	}

	public void paint(Graphics gc) {
		if(getCouleur() != null) gc.setColor(getCouleur());
		//gc.drawString(getNom(), ((int)p1.getX() + (int)p2.getX()) / 2, ((int)p1.getY() + (int)p2.getY()) / 2);
		gc.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());

	}

	@Override
	public int compareTo(Object o) {
		return (int) (this.getLongueur() - ((Segment) o).getLongueur());
	}

	@Override
	int getPoids() {
		return 0;
	}

}
