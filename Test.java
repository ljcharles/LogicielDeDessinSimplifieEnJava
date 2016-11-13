package logicieldedessin;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.*;

public class Test {

	public void testPoint(){
		Point p = new Point(1, 8, "A");
		Point p1 = new Point(3, 6,"B");
		p1.afficher();
		p1.translater(5, 3);
		p1.afficher();
		System.out.println(p1.distance(p));
		p1.afficher();
		Point p2 = new Point(1, 9, "C");
		p2.afficher();
		System.out.println(p1.equals(p2));

		Point p9;
		p9 = (Point) p.clone();
		p.afficher();
		p9.afficher();

	}

	public void testSegment() throws PointsConfondusException{
		Point p3 = new Point(3, 8, "A");
		Point p4 = new Point(3, 6,"B");
		Segment s = new Segment(p3,p4, "S");
		Segment s1 = new Segment(p4,p3, "S1");
		s.afficher();
		s.getCentre();
		s.getLongueur();
		s.translater(4, 6);
		s.afficher();
		System.out.println(s.equals(s1));

		Segment s3;
		s3 =  (Segment) s.clone();
		s.afficher();
		s3.afficher();

	}

	public void testCercle(){
		Point p5 = new Point(2, 7, "A");
		Point p6 = new Point(3, 1,"B");
		Cercle c = new Cercle(p5,p6,"C");
		c.afficher();
		c.getCentre();
		c.translater(4, 6);
		c.afficher();

		Point p7 = new Point(2, 14, "A");
		Point p8 = new Point(14, 5,"B");
		Cercle c1 = new Cercle(p7,p8,"C1");
		System.out.println(c.equals(c1));

		Cercle c2;
		c2 = (Cercle) c.clone();
		c.afficher();
		c2.afficher();


	}

	public void SauveQuiPeut(LinkedList<Figure> col, ObjectOutputStream out){
		for(Object o : col) 
			if(o instanceof Serializable)
				try { out.writeObject(o); } 
			    catch (IOException e) { e.printStackTrace();}
	}
	
	public void testSerialization(){
		Point p7 = new Point(2, 14, "A");
		Point p8 = new Point(14, 5,"B");
		Cercle c1 = new Cercle(p7,p8,"C1");
		
		Point p = new Point(1, 2, "E");
		Point p1 = new Point(3, 4,"F");
		Point p2 = new Point(5, 6, "G");
		Point p3 = new Point(7, 8,"H");

		Polygone poly = new Polygone("poli");
		poly.add(p);
		poly.add(p1);
		poly.add(p2);
		poly.add(p3);

		try {
			OutputStream f = new FileOutputStream("testJava.txt");
			ObjectOutputStream out = new ObjectOutputStream(f);
			LinkedList<Figure> lf = new LinkedList<Figure>();
			
			lf.add(poly);
			lf.add(c1);
			lf.add(p);
			
			SauveQuiPeut(lf, out);		
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testStructures() throws PointsConfondusException{
		LinkedList<Figure> llF = new LinkedList<>();
		Point p7 = new Point(2, 14, "A");
		Point p8 = new Point(14, 5,"B");
		Segment s = new Segment(p7,p8, "S");
		Cercle c1 = new Cercle(p7,p8,"C1");
		llF.add(p7);
		llF.add(s);
		llF.add(c1);

		for(Figure f : llF){
			f.afficher();
			f.translater(4, 5);
			if(f instanceof Point)
			f.afficher();
		}
	}

	public void testPolygone(){
		Point p = new Point(1, 2, "A");
		Point p1 = new Point(3, 4,"B");
		Point p2 = new Point(5, 6, "C");
		Point p3 = new Point(7, 8,"D");

		Polygone poly = new Polygone("poli");
		poly.add(p);
		poly.add(p1);
		poly.add(p2);
		poly.add(p3);

		p1 = new Point(1, 2, "A");
		p = new Point(3, 4,"B");
		p2 = new Point(5, 6, "C");
		p3 = new Point(7, 8,"D");

		Polygone poly2 = new Polygone("poli2");
		poly2.add(p);
		poly2.add(p1);
		poly2.add(p2);
		poly2.add(p3);

		System.out.println(poly.equals(poly2));

	}

	public void fenetre(){
		//Cr�e une fen�tre
		JFrame f = new JFrame();
		//D�finie sa taille
		f.setSize(800, 600);

		//Lui donner un titre
		f.setTitle("Figure");
		//Op�ration quand on ferme par d�faut
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//R�cup�re le contenu de la fen�tre
		Container contenu = f.getContentPane();

		//on cr�e les panneaux
		JPanel p1 = new JPanel();
		p1.setBackground(Color.red);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.blue);
		p2.setSize(300,0);
		JPanel p3 = new JPanel();

		//On ajoute les panneaux � la fen�tre
		contenu.add(p1, BorderLayout.CENTER);
		contenu.add(p2, BorderLayout.WEST);
		contenu.add(p3, BorderLayout.NORTH);

		//Change la facon d'on va s'afficher l'�l�ment P3
		p3.setLayout(new FlowLayout());

		//On ajoute les panneaux � la fen�tre
		p3.add(new JButton("b1"));
		p3.add(new JButton("b2"));
		p3.add(new JButton("b3"));

		p2.setLayout(new GridLayout(4,1));
		p2.add(new JLabel("nom"));
		p2.add(new JTextField());
		p2.add(new JLabel("Age"));
		p2.add(new JTextField());

		//La rend visible
		f.setVisible(true);
	}

	public static void main(String[] args) throws PointsConfondusException {
		Test test = new Test();
		//test.testPoint();
		//test.testSegment();
	    //test.testCercle();
		test.testSerialization();
		//test.testStructures();
		//test.testPolygone();
		//test.fenetre();


	}

}
