package logicieldedessin;

import java.awt.Graphics;

/**
 * @author ljeanc04
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

	  public double getLongueur() {
		  return p1.distance(p2);
	  }

	public void translater(double dx, double dy) {
		p1.translater(dx, dy);
		p2.translater(dx, dy);

	}

	public Point getCentre() {
		 return new Point((p1.getX() + p2.getX())/2,(p1.getY()+p2.getY())/2,"Centre");

	}

	public boolean equals(Segment s){
		if(s != null)
			return (this.p1.equals(s.p1) && this.p2.equals(s.p2))
					|| (this.p1.equals(s.p2) && this.p2.equals(s.p1));
		else
			return false;
	}

	public Object clone(){
		Segment ob = null;
		try {
			ob = (Segment) super.clone();
			((Segment) ob).p1 = (Point) this.p1.clone();
			((Segment) ob).p2 = (Point) this.p2.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ob;
	}

	public void paint(Graphics gc) {
		gc.drawString(getNom(), ((int)p1.getX() + (int)p2.getX()) / 2, ((int)p1.getY() + (int)p2.getY()) / 2);
		gc.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
	}

	}
