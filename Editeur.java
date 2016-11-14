package logicieldedessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Editeur extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static LinkedList<Figure> figures;
	@SuppressWarnings("unused")
	private static Color cl;
	protected Editeur editeur;

	public Editeur(){
		super();
		repaint();
	}

	public void paint(Graphics gc) {
	  super.paint(gc);
      if( figures != null) for(Figure f : figures) f.paint(gc);
	}
	
	public void createMenuBar(){
		cl = new Color(15, 24, 32);
		
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fichierMenu = new JMenu("Fichier");
        JMenu editerMenu = new JMenu("Edition");
        JMenu nouveau = new JMenu("Creer");
        
        menuBar.add(fichierMenu);
        menuBar.add(editerMenu);
        
        JMenuItem point = new JMenuItem("Point");
        JMenuItem cercle = new JMenuItem("Cercle");
        JMenuItem segment = new JMenuItem("Segment");
        JMenuItem poli = new JMenuItem("Polygone");
        JMenuItem quitter = new JMenuItem("Quitter");
        JMenuItem modif = new JMenuItem("Modifier");
        
        nouveau.add(point);
        nouveau.add(cercle); 
        nouveau.add(segment); 
        nouveau.add(poli); 
        fichierMenu.add(nouveau);
        fichierMenu.add(quitter);
        editerMenu.add(modif);
        
        point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = new Point(400,500,"P");
				ZoneDeDessin z = new ZoneDeDessin(figures);
				if(z.figures != null) z.figures.add(p);
				
			}
		});
        
        cercle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        
        segment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        
        poli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        
        quitter.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Lol !");
			}
		});
        
	}

	public static void main(String[] args) throws PointsConfondusException {
		Editeur test = new Editeur();
		test.setSize(800, 600);
		
		//Lui donner un titre
		test.setTitle("Figure");
		//Op�ration quand on ferme par d�faut
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenu = test.getContentPane();
		
		//on cr�e les panneaux
		JPanel panneau1 = new JPanel();
		JPanel panneau2 = new JPanel();
		panneau1.setBackground(Color.white);
		
		JButton Init = new JButton("Initialiser la liste de figures");
		JButton Vider = new JButton("Vider la liste de figures");
		
		//cl = UIManager.getColor ( Init.getBackground() );
		
		panneau2.setBackground(Color.lightGray);
		panneau1.setSize(800, 400);

		//On ajoute les panneaux � la fen�tre
		contenu.add(panneau1, BorderLayout.CENTER);
		contenu.add(panneau2, BorderLayout.SOUTH);
		
		panneau2.setLayout(new FlowLayout());
		
		Init.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				figures = new LinkedList<Figure>();
				
				ZoneDeDessin dessin = new ZoneDeDessin(figures);
				dessin.affichage();
				
				test.repaint();
			}
		});
		
		Vider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				figures.clear();
				
				test.repaint();
			}
		});
		
		//On ajoute les boutons � la fen�tre
		panneau2.add(Init);
		panneau2.add(Vider);
		
		test.createMenuBar();
		test.repaint();
		
		test.setVisible(true);

	}

}
