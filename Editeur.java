package logicieldedessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.*;

public class Editeur extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static LinkedList<Figure> figures;

	public Editeur(){
		super();
		repaint();
	}

	public void paint(Graphics gc) {
	  super.paint(gc);
      for(Figure f : figures) f.paint(gc);
	}

	public static void main(String[] args) throws PointsConfondusException {
		Editeur test = new Editeur();
		test.setSize(800, 600);
		
		//Lui donner un titre
		test.setTitle("Figure");
		//Op�ration quand on ferme par d�faut
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		figures = new LinkedList<Figure>();
		//figures.clear();
		
		Container contenu = test.getContentPane();
		
		//on cr�e les panneaux
		JPanel panneau1 = new JPanel();
		JPanel panneau2 = new JPanel();
		panneau2.setBackground(Color.white);
		panneau2.setBackground(Color.gray);
		panneau1.setSize(800, 400);

		//On ajoute les panneaux � la fen�tre
		contenu.add(panneau1, BorderLayout.CENTER);
		contenu.add(panneau2, BorderLayout.SOUTH);
		
		panneau2.setLayout(new FlowLayout());
		
		JButton Init = new JButton("Initialiser la liste de figures");
		JButton Vider = new JButton("Vider la liste de figures");
		
		Init.addActionListener(new InitListener(figures));
		Vider.addActionListener(new ViderListener(figures));
		
		//On ajoute les boutons � la fen�tre
		panneau2.add(Init);
		panneau2.add(Vider);

        Point p = new Point(10, 80, "A");
        
		Point p3 = new Point(150, 200, "A");
		Point p4 = new Point(3, 6,"B");
		Segment s = new Segment(p3,p4, "S");

		Point p5 = new Point(220, 150, "A");
		Point p6 = new Point(260, 100,"B");
		Cercle c = new Cercle(p5,p6,"C");

		Point p7 = new Point(300,300, "A");
		Point p8 = new Point(350, 300,"B");
		Point p10 = new Point(350, 350, "C");
		Point p9 = new Point(300, 350,"D");

		Polygone poly = new Polygone("poli");
		poly.add(p7);
		poly.add(p8);
		poly.add(p9);
		poly.add(p10);

		figures.add(p);
		figures.add(s);
		figures.add(c);
		figures.add(poly);
		
		test.repaint();
		test.setVisible(true);

	}

}
