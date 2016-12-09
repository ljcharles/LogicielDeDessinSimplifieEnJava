package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author freshloic
 *
 */

public class Rectangle extends Polygone {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2290634798329976089L;
	private Point p1, p2;
	private int width,height;

	public int getWidth() {
		int rx = (int) p1.getX();
		width  = (int) p2.getX()-rx;
		if(width  < 0)  rx += width;
		width  = Math.abs(width);
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		int ry = (int) p1.getY();
		height = (int) p2.getY()-ry;
		if(height < 0)  ry += height;
		height = Math.abs(height);
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}


	public Rectangle(Point p1, Point p2){
		Sommets = new LinkedList<Point>();
		Sommets.add(p1);
		Sommets.add(p2);
		this.p1 = p1;
		this.p2 = p2;
	}

	public double getLongueurX() {return p2.distanceX(p1);}

	public double getLongueurY() {return p2.distanceY(p1);}

	public void translater(double dx, double dy) {
		p2.translater(dx  + getLongueurX(), dy  + getLongueurY());
		p1.translater(dx, dy);

		width  = (int) getLongueurX();
		height = (int) getLongueurY();

		width  = Math.abs(width);
		height = Math.abs(height);

		setWidth(width);
		setHeight(height);
	}

	public String toString(){ return getNom() +":[ "+ p1.toString() + ";" + p2.toString()+ "]"; }

	public boolean equals(Rectangle r){
		if(r != null)
			return (this.p1.equals(r.p1) && this.p2.equals(r.p2) || (this.p1.equals(r.p2) && this.p2.equals(r.p1)));
		else
			return false;
	}

	public void paint(Graphics gc) {
		if(getCouleur() != null) gc.setColor(getCouleur());
		gc.fillRect((int)p1.getX(), (int)p1.getY(), getWidth(), getHeight());

	}

	public LinkedList<Point> getPoints() {
		LinkedList<Point> liste = new LinkedList<Point>();
		liste.add(this.p1);
		liste.add(this.p2);
		return liste;
	}

	public Object cloner(){
		Rectangle r = null;
		try {
			r = (Rectangle) super.clone();
			r.Sommets = new LinkedList<Point>();
			for(Point pt : this.Sommets){
				r.Sommets.add((Point) pt.cloner());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return r;
	}
}
