package logicieldedessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static LinkedList<Figure> figures;
	JButton Init;
	JButton Vider;
	Figure f;
	JMenuItem quitter;
	boolean creerPoint;
	JMenuItem cercle;
	JMenuItem segment;
	JMenuItem poli;
	JMenuItem modif;
	JMenuItem Menupoint;

	public ZoneDeDessin(){
		figures = new LinkedList<Figure>();
		Init = new JButton("Initialiser la liste de figures");
		Vider = new JButton("Vider la liste de figures");
		
		Init.addActionListener(this);
		
		Vider.addActionListener(this);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this); 
		repaint();
	}

	public void paint(Graphics g){
		super.paint(g);
		for(Figure f : figures) f.paint(g);
	}

	public void affichage(){
		Point p = new Point(10, 80, "A");

		Point p3 = new Point(150, 200, "A");
		Point p4 = new Point(3, 6,"B");
		Segment s = null;
		try {
			s = new Segment(p3,p4, "S");
		} catch (PointsConfondusException e1) {
			e1.printStackTrace();
		}

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
		repaint();
	}
	
	public void clearList(){
		figures.clear();
		this.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if(creerPoint){
			int x = e.getX();
			int y = e.getY();
			
			f = new Point(x,y);
			figures.add(f);
			this.repaint();
		}
		
	}
	
	public void createMenuBar(JFrame frame){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
        
        JMenu fichierMenu = new JMenu("Fichier");
        JMenu editerMenu = new JMenu("Edition");
        JMenu nouveau = new JMenu("Creer");
        
        menuBar.add(fichierMenu);
        menuBar.add(editerMenu);
        
        Menupoint = new JMenuItem("Point");
        cercle = new JMenuItem("Cercle");
        segment = new JMenuItem("Segment");
        poli = new JMenuItem("Polygone");
        quitter = new JMenuItem("Quitter");
        modif = new JMenuItem("Modifier");
        
        nouveau.add(Menupoint);
        nouveau.add(cercle); 
        nouveau.add(segment); 
        nouveau.add(poli); 
        fichierMenu.add(nouveau);
        fichierMenu.add(quitter);
        editerMenu.add(modif);
        
        Menupoint.addActionListener(this);
        
        cercle.addActionListener(this);
        
        segment.addActionListener(this);
        
        poli.addActionListener(this);
        
        quitter.addActionListener(this);
        
        modif.addActionListener(this);
	}

	
	public static void main(String[] args) throws PointsConfondusException {
		JFrame test = new JFrame();
		test.setSize(800, 600);
		
		//Lui donner un titre
		test.setTitle("Figure");
		//Op�ration quand on ferme par d�faut
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contenu = test.getContentPane();
		
		//Pour faire les tests
		
		
		//on cr�e les panneaux
		JPanel panneau1 = new JPanel();
		ZoneDeDessin panneau2 = new ZoneDeDessin();
		panneau1.setBackground(Color.lightGray);
		
		//cl = UIManager.getColor ( Init.getBackground() );
		
		panneau2.setBackground(Color.white);
		panneau1.setSize(800, 400);

		//On ajoute les panneaux � la fen�tre
		contenu.add(panneau1, BorderLayout.NORTH);
		contenu.add(panneau2, BorderLayout.CENTER);
		
		panneau2.setLayout(new FlowLayout());
		
		
		
		//On ajoute les boutons � la fen�tre
		panneau1.add(panneau2.Init);
		panneau1.add(panneau2.Vider);
		
		//Color cl = new Color(15, 24, 32);
		
		panneau2.createMenuBar(test);
		test.repaint();
		
		test.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Init)) affichage();
		else if(e.getSource().equals(Vider)) clearList();
		else if(e.getSource().equals(quitter)) System.exit(0);
		else if(e.getSource().equals(Menupoint)){
			creerPoint = true;
		} 
		else if(e.getSource().equals(segment)) System.out.println("test");
		else if(e.getSource().equals(modif)) System.out.println("test");
	}

}
