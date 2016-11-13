package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;


public class Point  extends Figure
{
	private static final long serialVersionUID = 313383061543819140L;
	private double x;
	private	double y;

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

 public String toString(){
	 return  getNom() +"( "+ getX() + "," + getY() + ")";
 }

 public  double distance(Point val)
 {
	 return Math.sqrt( ((this.getX() - val.getX()) * (this.getX() - val.getX())) + ((this.getY() - val.getY()) * (this.getY() - val.getY())) );
 }

 public void translater(double dx, double dy)
 {
	 setX(getX() + dx);
	 setY(getY() + dy);
 }

 public Point getCentre() {
	return this;
 }
 
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

 public Object clone(){
		Point ob = null;
		try {
			ob = (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ob;
	}

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public double getY() {
	return y;
}

public void setY(double y) {
	this.y = y;
}

public void paint(Graphics gc) {
	gc.drawString(getNom(), (int)getX(), (int)getY() - 5);
	gc.drawOval((int)getX(), (int)getY(), 10, 10);
}

}
