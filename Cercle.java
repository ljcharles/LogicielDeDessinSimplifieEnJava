package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author freshloic
 *
 */
public class Cercle extends Figure {

	/**
	 *
	 */
	private static final long serialVersionUID = 6947876081184348818L;

	private Point Centre;

	private double rayon;


	public Cercle(Point Centre,  Point p, String nom){
		this.Centre = Centre;
		this.rayon = Centre.distance(p);
		this.setNom(nom);
	}

	public Cercle(Point Centre, double rayon){
		this.Centre = Centre;
		this.rayon = rayon;
	}

	public Cercle(Point Centre, Point p){
		this(Centre,p,"");
	}

	public void afficher()
	{
		System.out.println(toString());
	}

	public String toString(){
		return getNom() + " r =" + rayon + " " + Centre;
	}


	public Point getCentre() {
		return Centre;
	}

	public double getRayon() {
		return rayon;
	}


	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public LinkedList<Point> getPoints() {
		LinkedList<Point> liste = new LinkedList<Point>();
		liste.add(this.Centre);
		return liste;
	}

	/* (non-Javadoc)
	 * @see monpremierprojet.Figure#translater(double, double)
	 */
	public void translater(double dx, double dy) {
		Centre.translater(dx, dy);
	}

	/**
	 * @param c
	 * @return
	 */
	public boolean equals(Cercle c){
		if(c != null)
			return this.Centre.equals(c.Centre) && this.rayon == c.rayon;
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object cloner(){
		Cercle ob = null;
		try {
			ob = (Cercle) super.clone();
			ob.Centre = (Point) Centre.cloner();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ob;
	}

	@Override
	public void paint(Graphics gc) {
		if(getCouleur() != null) gc.setColor(getCouleur());
		gc.drawString(getNom(), (int)Centre.getX(), (int)Centre.getY());
		gc.drawOval((int)Centre.getX() - (int)rayon, (int)Centre.getY() - (int)rayon, (int)rayon*2, (int)rayon*2);
	}

	@Override
	public int compareTo(Object o) {
		return (int) (rayon - ((Cercle) o).rayon);
	}

	@Override
	public int getPoids() { return this.getPoints().size(); }

}
