package logicieldedessin;

import java.util.LinkedList;

/**
 * @author ljeanc04
 *
 */

public class Rectangle extends Polygone {
   /**
	 * 
	 */
	private static final long serialVersionUID = 2290634798329976089L;
private Point p1, p2, p3, p4;

   public Rectangle(Point p1, Point p2, Point p3, Point p4){
     Sommets = new LinkedList<Point>();
     Sommets.add(p1);
     Sommets.add(p2);
     Sommets.add(p3);
     Sommets.add(p4);
   }

   public void translater(double dx, double dy) {
     p1.translater(dx, dy);
     p2.translater(dx, dy);
     p3.translater(dx, dy);
     p4.translater(dx, dy);
   }

   public String toString(){ return getNom() +":[ "+ p1.toString() + ";" + p2.toString() + p3.toString() + p4.toString() + "]"; }

   public boolean equals(Rectangle r){
     if(r != null)
       return (this.p1.equals(r.p1) && this.p2.equals(r.p2) && this.p3.equals(r.p3) && this.p4.equals(r.p4))
           || (this.p1.equals(r.p2) && this.p2.equals(r.p1) && this.p3.equals(r.p2) && this.p4.equals(r.p3))
           || (this.p1.equals(r.p3) && this.p2.equals(r.p3) && this.p3.equals(r.p1) && this.p4.equals(r.p2))
           || (this.p1.equals(r.p4) && this.p2.equals(r.p4) && this.p3.equals(r.p4) && this.p4.equals(r.p1));
     else
       return false;
   }
 }
