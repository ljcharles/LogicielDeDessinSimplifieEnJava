package logicieldedessin;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.LinkedList;

	 abstract class Figure implements Cloneable,Serializable{
		private static final long serialVersionUID = 3516062312457681922L;
		private String nom;

		  public abstract void afficher();

		  public abstract void translater(double dx, double dy);

		  public abstract Point getCentre();

		  public abstract void paint(Graphics gc);
		  
		  public abstract LinkedList<Point> getPoints();

		public String getNom() {
			return nom.toUpperCase();
		}

		public void setNom(String nom) {
			if(nom != null) this.nom = nom;
		}
		
		public LinkedList<Point> creatList(LinkedList<Figure> l){
			LinkedList<Point> lp = new LinkedList<Point>();
			for( Figure f : l){ lp.addAll(((Point) f).getPoints());}
			return lp;
		}

		}
