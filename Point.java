package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;


/**
 * @author freshloic
 *
 */
public class Point  extends Figure
{
	private static final long serialVersionUID = 313383061543819140L;
	private double x;
	private	double y;
	private int taille = 7;

	public Point(double x, double y, String nom)
	{
		this.setX(x);
		this.setY(y);
		this.setNom(nom);
	}

	public Point(double x, double y)
	{
		this(x,y,"");
	}

	public Point() { this(0,0); }

	public Point(Point p){
		this();
	}

	public void afficher()
	{
		System.out.println(toString());
	}

	public String toString(){ return  getNom() +"( "+ getX() + "," + getY() + ")"; }

	public  double distance(Point val)
	{
		return Math.sqrt( ((this.getX() - val.getX()) * (this.getX() - val.getX())) + ((this.getY() - val.getY()) * (this.getY() - val.getY())) );
	}

	public void translater(double dx, double dy)
	{
		setX(dx);
		setY(dy);
	}

	public Point getCentre() {return this;}

	public LinkedList<Point> getPoints() {
		LinkedList<Point> liste = new LinkedList<Point>();
		liste.add(this);
		return liste;
	}

	public boolean equals(Point p){
		if(p != null)
			return this.getX() == p.getX() && this.getY() == p.getY();
		else
			return false;
	}

	public Object cloner(){
		Point ob = null;
		try {
			ob = (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ob;
	}

	public double getX() {return x;}

	public void setX(double x) {this.x = x;}

	public double getY() {return y;}

	public void setY(double y) {this.y = y;}

	public void paint(Graphics gc) {
		if(getCouleur() != null) gc.setColor(getCouleur());
		gc.drawString(getNom(), (int)getX(), (int)getY() - 5);
		gc.fillOval((int)getX(), (int)getY(), taille, taille);
	}

	@Override
	public int compareTo(Object o) {
		if(this.equals((Point) o)) return 0;
		return -1;
	}

	@Override
	public int getPoids() { return this.getPoints().size(); }

	public double distanceX(Point val) {
		return this.getX() - val.getX();
	}

	public double distanceY(Point val) {
		return this.getY() - val.getY();
	}


}
