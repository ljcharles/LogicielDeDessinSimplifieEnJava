package logicieldedessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
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
import javax.swing.event.MouseInputListener;

public class ZoneDeDessin extends JPanel implements MouseInputListener, ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static LinkedList<Figure> figures;
	JButton Init;
	JButton Vider;
	Figure f;
	JMenuItem quitter;
	JMenuItem Menucercle;
	JMenuItem Menusegment;
	JMenuItem Menupoli;
	JMenuItem modif;
	JMenuItem Menupoint;
	boolean creerPoint ;
	boolean creerSegment ;
	int initX, initY;

	public ZoneDeDessin(){
		figures = new LinkedList<Figure>();
		Init = new JButton("Initialiser la liste de figures");
		Vider = new JButton("Vider la liste de figures");
		
		Init.addActionListener(this);
		
		Vider.addActionListener(this);
		
		creerPoint=false;
		creerSegment=false;
		
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
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(creerSegment && f != null & f instanceof Segment)
		{
			Point p = new Point(e.getX(), e.getY());
			Segment s = (Segment)f;
			s.setP2(p);
			repaint();
		}
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(creerSegment){
			if(f == null || !(f instanceof Segment))
			{
				Point p = new Point(e.getX(), e.getY());
				f = new Segment(p,p);
				figures.add(f);
			}
			else
			{
				f = null;
			}
		}
	}
	
	public void initDroite(int x, int y) {
		initX = x;
		initY = y;
		
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
	
	public void termineDroite(int x, int y) {
		// TODO Auto-generated method stub
			f = new Segment(new Point(initX,initY),new Point(x,y));
			figures.add(f);
			this.repaint();
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
        Menucercle = new JMenuItem("Cercle");
        Menusegment = new JMenuItem("Segment");
        Menupoli = new JMenuItem("Polygone");
        quitter = new JMenuItem("Quitter");
        modif = new JMenuItem("Modifier");
        
        nouveau.add(Menupoint);
        nouveau.add(Menucercle); 
        nouveau.add(Menusegment); 
        nouveau.add(Menupoli); 
        fichierMenu.add(nouveau);
        fichierMenu.add(quitter);
        editerMenu.add(modif);
        
        Menupoint.addActionListener(this);
        
        Menucercle.addActionListener(this);
        
        Menusegment.addActionListener(this);
        
        Menupoli.addActionListener(this);
        
        quitter.addActionListener(this);
        
        modif.addActionListener(this);
	}

	
	public static void main(String[] args){
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
		panneau2.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
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
		else if(e.getSource().equals(Menusegment)){ 
			creerPoint = false;
			creerSegment =true;
		}
		else if(e.getSource().equals(modif)) System.out.println("test");
	}

}
