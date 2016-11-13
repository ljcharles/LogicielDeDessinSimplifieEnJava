package logicieldedessin;

import java.awt.Graphics;
import java.io.Serializable;

	 abstract class Figure implements Cloneable,Serializable{
		private static final long serialVersionUID = 3516062312457681922L;
		private String nom;

		  public abstract void afficher();

		  public abstract void translater(double dx, double dy);

		  public abstract Point getCentre();

		  public abstract void paint(Graphics gc);

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		}
