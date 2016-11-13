package logicieldedessin;

import java.util.LinkedList;

/**
 * @author ljeanc04
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
   }

   public void translater(double dx, double dy) {
     p1.translater(dx, dy);
     p2.translater(dx, dy);
     p3.translater(dx, dy);
   }

   public String toString(){ return getNom() +":[ "+ p1.toString() + ";" + p2.toString() + p3.toString() + "]"; }

   public boolean equals(Triangle t){
     if(t != null)
       return (this.p1.equals(t.p1) && this.p2.equals(t.p2) && this.p3.equals(t.p3))
           || (this.p1.equals(t.p2) && this.p2.equals(t.p1) && this.p3.equals(t.p2))
           || (this.p1.equals(t.p3) && this.p2.equals(t.p3) && this.p3.equals(t.p1));
     else
       return false;
   }
 }
