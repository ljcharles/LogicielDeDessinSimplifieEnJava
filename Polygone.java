package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

public class Polygone extends Figure{

	private static final long serialVersionUID = -4577800669531061605L;
	public LinkedList<Point> Sommets;

	public Polygone(){this("");}

	public Polygone(String nom){
		Sommets = new LinkedList<>();
		setNom(nom);
	}

	@Override
	public void afficher() {
		System.out.println(toString());
	}

	 public String toString(){
	  	 return getNom();
	   }


	@Override
	public void translater(double dx, double dy) {
		for(Point p : Sommets){
			p.translater(dx, dy);
		}
	}

	@Override
	public Point getCentre() {
		float x = 0, y = 0;
		int taille = Sommets.size();

		for(Point p : Sommets){
			x += p.getX();
			y += p.getY();
		}

		return new Point(x/taille, y/taille);
	}
	
	public LinkedList<Point> getPoints(){ return this.Sommets; }

	public Object clone(){
		Polygone p = null;
		try {
			p = (Polygone) super.clone();
				p.Sommets = new LinkedList<Point>();
				for(Point pt : this.Sommets){
					p.Sommets.add((Point) pt.clone());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean add(Point p){
		Sommets.add(p);
		return true;

	}

	public boolean equals(Polygone p){
		if(p == null) return false;

		if(this == p) return true;

		if(this.Sommets.size() != p.Sommets.size()) return false;

		if(this.Sommets.size() == 0) return false;

		Point depart = this.Sommets.getFirst();
		Point departP = null;
		int i = 0;

		while(i < p.Sommets.size() && departP == null){
			if(depart.equals(p.Sommets.get(i))) departP = p.Sommets.get(i);
			else i++;
		}

		if(departP == null) return false;

		if(this.Sommets.get(1).equals(p.Sommets.get((i+1)%p.Sommets.size()))){
			for(int j=2; j < p.Sommets.size(); j++){
				if(!this.Sommets.get(j).equals(p.Sommets.get((i+j)%p.Sommets.size())))
					return false;
			}
			return true;
		 }
		else if(this.Sommets.get(1).equals(p.Sommets.get((i-1)%p.Sommets.size()))){
			 for(int j = 2; j < p.Sommets.size(); j++){
				 if(!this.Sommets.get(j).equals(p.Sommets.get((i-j + p.Sommets.size())%p.Sommets.size())))
					 return false;
		     }

			 return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void paint(Graphics gc) {
        int taille = Sommets.size();


		for( int i=0; i<taille; i++){
			int x1 = (int) Sommets.get(i).getX();
			int y1 = (int) Sommets.get(i).getY();

			int x2 = (int) Sommets.get((i+1)%taille).getX();
			int y2 = (int) Sommets.get((i+1)%taille).getY();
			gc.drawLine(x1, y1, x2, y2);
			gc.drawString(getNom(),
					(int) this.getCentre().getX(),
					(int)this.getCentre().getY() - 30);
		}

	}

	@Override
	public int compareTo(Object o) {
		if(this.getPoids() > ((Polygone)o).getPoids()) return 1;
		if(this.getPoids() == ((Polygone)o).getPoids()) return 0;
		return -1;
	}

	@Override
	public int getPoids() { return this.getPoints().size(); }
}
