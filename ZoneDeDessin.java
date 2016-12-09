package logicieldedessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author freshloic
 *
 */
public class ZoneDeDessin extends JPanel implements MouseInputListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private static String message;
	private static JFrame frame;
	private static Container contenu;
	private static JPanel panneauNord;
	private static JPanel panneauSud;
	private static LinkedList<Figure> figures;
	private LinkedList<Figure> figuresCloner;
	private LinkedList<LinkedList<Figure>> listeFigures;
	private ImageIcon IconMenuQuitter;
	private ImageIcon IconCreer;
	private ImageIcon IconSave;
	private ImageIcon IconSavePng;
	private ImageIcon IconRestore;
	private ImageIcon IconFile;
	private ImageIcon IconPoint;
	private ImageIcon IconCercle;
	private ImageIcon IconSegment;
	private ImageIcon IconRectangle;
	private ImageIcon IconPoli;
	private ImageIcon IconTriangle;
	private ImageIcon IconMove;
	private ImageIcon IconDelete;
	private ImageIcon IconSelect;
	private ImageIcon IconCopy;
	private ImageIcon IconEdit;
	private ImageIcon IconplayButton;
	private ImageIcon IconbackButton;
	private JButton pointbutton;
	private JButton cerclebutton;
	private JButton segmentbutton;
	private JButton polybutton;
	private JButton rectanglebutton;
	private JButton trianglebutton;
	private JButton playButton;
	private JButton menu;
	private JButton InitProg;
	private JButton ViderList;
	private JButton colorbutton;
	private JMenuBar menuBar;
	private JMenuItem MenuSiCreerPoint;
	private JMenuItem MenuSiCreerCercle;
	private JMenuItem MenuSiCreerSegment;
	private JMenuItem MenuSiCreerPoli;
	private JMenuItem MenuSiCreerRectangle;
	private JMenuItem MenuSiCreerTriangle;
	private JMenuItem MenuQuitter;
	private JMenuItem MenuSupprimer;
	private JMenuItem Menuselect;
	private JMenuItem Menutranslater;
	private JMenuItem MenuSiCopier;
	private JMenuItem MenuSauvegarder;
	private JMenuItem restaurer;
	private JMenuItem MenuSauvegarderPng;
	private boolean SiCreerPoint;
	private boolean SiCreerSegment;
	private boolean SiCreerCercle;
	private boolean SiCreerPoli;
	private boolean SiCreerRectangle;
	private boolean SiCreerTriangle;
	private boolean Menuselected;
	private boolean MenuSupprimerFigures;
	private boolean translater;
	private boolean SiCopier;
	private boolean figureChoose;
	private boolean suppression;
	private boolean select;
	private Figure f;
	private Figure v;
	private Point pt;
	private Color couleur;
	private Color couleurButton;
	private Color whiteButton;
	private MyGame game;
//	private int dX;
	private Object clone;
    private Figure destroy;

	public ZoneDeDessin(){
		figures = new LinkedList<Figure>();
		figuresCloner = new LinkedList<Figure>();
		listeFigures = new LinkedList<LinkedList<Figure>>();
		couleurButton = new Color(52, 152, 219);
		whiteButton = Color.WHITE;
		iconSet();

		String str1 = "Jouer à  ScaryGame"; 
		String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));

		InitProg = new JButton("Cliquer ici pour commencer");
		ViderList = new JButton("Nettoyer");
		colorbutton = new JButton("Choisir une couleur");
		pointbutton = new JButton();
		cerclebutton = new JButton();
		segmentbutton = new JButton();
		polybutton = new JButton();
		rectanglebutton = new JButton();
		trianglebutton = new JButton();
		playButton = new JButton(str2);
		menu = new JButton("Revenir");
		menu.setVisible(false);

		InitProg.setBackground(couleurButton);
		InitProg.setForeground(Color.white);
		ViderList.setBackground(couleurButton);
		ViderList.setForeground(Color.white);
		colorbutton.setBackground(couleurButton);
		colorbutton.setForeground(Color.white);
		pointbutton.setBackground(whiteButton);
		cerclebutton.setBackground(whiteButton);
		segmentbutton.setBackground(whiteButton);
		polybutton.setBackground(whiteButton);
		rectanglebutton.setBackground(whiteButton);
		trianglebutton.setBackground(whiteButton);

		pointbutton.setIcon(IconPoint); 
		cerclebutton.setIcon(IconCercle); 
		segmentbutton.setIcon(IconSegment); 
		polybutton.setIcon(IconPoli); 
		rectanglebutton.setIcon(IconRectangle); 
		trianglebutton.setIcon(IconTriangle); 
		playButton.setIcon(IconplayButton);
		menu.setIcon(IconbackButton);

		InitProg.setCursor( Cursor.getPredefinedCursor(12) );
		ViderList.setCursor( Cursor.getPredefinedCursor(12) );
		colorbutton.setCursor( Cursor.getPredefinedCursor(12) );
		pointbutton.setCursor( Cursor.getPredefinedCursor(12) );		
		cerclebutton.setCursor( Cursor.getPredefinedCursor(12) );
		segmentbutton.setCursor( Cursor.getPredefinedCursor(12) );
		polybutton.setCursor( Cursor.getPredefinedCursor(12) );
		rectanglebutton.setCursor( Cursor.getPredefinedCursor(12) );
		trianglebutton.setCursor( Cursor.getPredefinedCursor(12) );

		InitProg.addActionListener(this);		
		ViderList.addActionListener(this);
		colorbutton.addActionListener(this);
		pointbutton.addActionListener(this);		
		cerclebutton.addActionListener(this);
		segmentbutton.addActionListener(this);
		polybutton.addActionListener(this);		
		rectanglebutton.addActionListener(this);
		trianglebutton.addActionListener(this);
		playButton.addActionListener(this);
		menu.addActionListener(this);

		SiCreerPoint=false;
		SiCreerSegment=false;
		SiCreerPoint=false;
		SiCreerSegment=false;
		SiCreerCercle=false;
		SiCreerPoli=false;
		Menuselected=false;
		MenuSupprimerFigures = false;
		translater = false;
		figureChoose = false;
		SiCopier = false;
		select = false;

		this.addMouseListener(this);
		this.addMouseMotionListener(this); 
		repaint();
	}

	/* (non-Javadoc) 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		// Ameliore vachement la qualitÃ© 
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		super.paint(g2);

		if(figures.size() != 0){
			for(Figure f : figures){ 
				f.paint(g2); 
			}
		}

		if(figuresCloner.size() != 0){
			for(Figure x : figuresCloner) {
				x.paint(g2);
			}
		}
	}

	/**
	 * @param f Permet de changer la couleur d'une figure
	 */
	private void colorChanger(Figure f) {
		if(couleur != null && f != null) f.setCouleur(couleur);
		repaint();
	}

	/**
	 * Permet de Vider les listes de figures 
	 */
	public void clearList(){
		if(figures.size()!=0) figures.clear();
		if(figuresCloner.size()!=0) figuresCloner.clear();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {

//		if(select){
//			if (this.isFocusable()) {
//				this.setLocation(e.getLocationOnScreen().x - dX, this.getY());
//				dX = e.getLocationOnScreen().x - this.getX();
//				this.setSize(this.getWidth() + dX, this.getHeight());
//			}
//		}

		//      PARTIE SELECTION ET TRANSLATION

		if(translater){
			setCursor(new Cursor(Cursor.MOVE_CURSOR));
			Point p = createMousePoint(e);

			figureChoose=false;
			for(Figure f:figures){
				for(Point x : f.getPoints()){
					if(((x!=null && x.distance(p) <= 55)
							||(f.getCentre().distance(p) <= 55)
							||f.getPoints().contains(p)) 
							&& (!figureChoose)){
						figureChoose = true;
						((Figure) f).translater(p.getX(),p.getY());
						//					 f.setCouleur(Color.LIGHT_GRAY);
						repaint();
					}
				}
			}


			for(Figure f:figuresCloner){
				for(Point x : f.getPoints()){
					if(((x!=null && x.distance(p) <= 55)
							||(f.getCentre().distance(p) <= 55)
							||f.getPoints().contains(p)) 
							&& (!figureChoose)){
						figureChoose = true;
						((Figure) f).translater(p.getX(),p.getY());
						repaint();
					}
				}
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {


		if(SiCreerSegment && f != null && f instanceof Segment)
		{
			Point p = createMousePoint(e);
			Segment s = (Segment)f;
			s.setP2(p);
			colorChanger(s);
			repaint();
		}

		if(SiCreerCercle && f != null && f instanceof Cercle)
		{
			Point p = createMousePoint(e);
			Cercle c = (Cercle)f;
			c.setRayon(c.getCentre().distance(p));
			colorChanger(c);
			repaint();
		}

		if(pt != null){
			if(SiCreerPoli)
			{
				if(f == null){
					f = new Polygone();
					figures.add(f);
					Polygone poly = (Polygone)f;
					poly.add(pt);
					pt = createMousePoint(e);
					poly.add(pt);
				}

				if(!(f instanceof Polygone)) f=null;
				Polygone poly = (Polygone)f;

				if(poly != null && e != null){
					poly.getLast().setX(e.getX());
					poly.getLast().setY(e.getY());
					colorChanger(poly);
					repaint();
				}
			}
		}

		if(SiCreerRectangle && f != null && f instanceof Rectangle)
		{
			Point p = createMousePoint(e);
			Rectangle r = (Rectangle)f;
			r.setP2(p);
			r.add(p);
			colorChanger(r);
			repaint();
		}


		if(SiCreerTriangle && f != null && f instanceof Triangle)
		{
			Point p = createMousePoint(e);
			Triangle t = (Triangle)f;
			t.setP2(p);
			t.add(p);
			colorChanger(t);
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent evt) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
//		if(select){
//			if (this.contains(e.getPoint())) {
//				dX = e.getLocationOnScreen().x - this.getX();
//				this.setFocusable(true);
//			}
//		}

		if(pt == null) pt = createMousePoint(e);
		else
		{
			if(!SiCreerPoli || e.getClickCount()==2)
			{
				if(SiCreerPoli)
				{
					Polygone v = (Polygone)f;
					if(v.getLast() != null && v != null && v.Sommets != null) v.Sommets.remove(v.getLast());
					colorChanger(v);
					repaint();
				}
				f = null;
				pt = null;
			}
			else
			{
				pt = new Point(e.getX(), e.getY());
				Polygone v = (Polygone)f;
				if(v != null && pt != null) v.add(pt);
			}
		}

		if(SiCreerSegment){
			if(f == null || !(f instanceof Segment))
			{
				Point p = createMousePoint(e);
				f = new Segment(p,p);
				colorChanger(f);
				figures.add(f);
			}else f = null;
		}

		if(SiCreerCercle){
			if(f == null || !(f instanceof Cercle))
			{
				Point p = createMousePoint(e);
				f = new Cercle(p,p);
				colorChanger(f);
				figures.add(f);
			}else f = null;
		}

		chooseAndSuppr(e);
	}


	/**
	 * @param e Permet de supprimer ou de choisir une figure seulement si elle a une distance assez proche de la souris
	 */
	private void chooseAndSuppr(MouseEvent e) {
		//                         PARTIE SUPPRESSION ET SELECTION
		if(Menuselected){
			if(figureChoose && figures.size() != 0) setCursor(new Cursor(Cursor.HAND_CURSOR));
			Point p = createMousePoint(e);
			figureChoose=false;
			suppression = false;

			for(Figure f:figures){
				suppression(p, f);

				if(select){
					for(Point x : f.getPoints()){
						if((x!=null && x.distance(p) <= 55) 
								||(f.getCentre().distance(p) <= 55) 
								||(f.getPoints().contains(p))){ 
							setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							if(couleur != null){
								colorChanger(f);
								clone = f.cloner();
								destroy=f;
								repaint();
							}
						}
					}
				}
				
				if(SiCopier && f != null){
					clone = f.cloner();
					((Figure) clone).translater(f.getCentre().getX()+20,f.getCentre().getY()+20);
					figuresCloner.add(((Figure) clone));
					repaint();
				}

			}

			if(v != null) figures.remove(v);
			if(couleur != null && clone != null){
				if(destroy != null) figures.remove(destroy);
				figures.add((Figure) clone);
			}

			for(Figure f:figuresCloner){
				suppression(p, f);
				if(SiCopier && f != null) SiCopier=false;
			}

			if(v != null) figuresCloner.remove(v);
		}
	}

	/**
	 * @param p
	 * @param f donne les parametre de suppression
	 */
	private void suppression(Point p, Figure f) {
		if(MenuSupprimerFigures && !figureChoose && !suppression) {
			for(Point x : f.getPoints()){
				if((x!=null && x.distance(p) <= 55) 
						||(f.getCentre().distance(p) <= 55) 
						||(f.getPoints().contains(p))){ 
					figureChoose = true;
					v = f;
					suppression = true;
					if(suppression) setCursor(new Cursor(Cursor.WAIT_CURSOR));
					repaint();
					figureChoose = false;
					suppression = false;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		}
	}

	/**
	 * @param e
	 * @return p le point contenant les coordonnées de la souris
	 */
	private Point createMousePoint(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		return p;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if(SiCreerPoint){
			int x = e.getX();
			int y = e.getY();

			f = new Point(x,y);
			figures.add(f);
			colorChanger(f);
			this.repaint();

		}

		if(SiCreerTriangle){
			if(f == null || !(f instanceof Triangle))
			{
				Point p = createMousePoint(e);
				f = new Triangle(p,p);
				((Triangle) f).add(p);
				figures.add(f);
				colorChanger(f);
				this.repaint();
			}else f = null;
		}

		if(SiCreerRectangle){
			if(f == null || !(f instanceof Rectangle))
			{
				Point p = createMousePoint(e);
				f = new Rectangle(p,p);
				((Rectangle) f).add(p);
				figures.add(f);
				colorChanger(f);
				this.repaint();
			}else f = null;
		}

	}

	/**
	 * @param frame Crée un menu et l'ajoute à la fenête Frame
	 */
	public void createMenuBar(JFrame frame){
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		String str1 = "Édition"; 
		String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));

		String str3 = "Créer"; 
		String str4 = new String(str3.getBytes(),Charset.forName("UTF-8"));

		JMenu fileMenu = new JMenu("Fichier");
		JMenu editMenu  = new JMenu(str2);
		JMenu createNewFigure     = new JMenu(str4);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		MenuSiCreerPoint      = new JMenuItem("Point");
		MenuSiCreerCercle     = new JMenuItem("Cercle");
		MenuSiCreerSegment    = new JMenuItem("Segment");
		MenuSiCreerPoli       = new JMenuItem("Polygone");
		MenuSiCreerRectangle  = new JMenuItem("Rectangle");
		MenuSiCreerTriangle   = new JMenuItem("Triangle");
		MenuQuitter        = new JMenuItem("Quitter");
		Menutranslater = new JMenuItem("Translater");
		MenuSupprimer      = new JMenuItem("Supprimer");

		String str5 = "Sélectionner"; 
		String str6 = new String(str5.getBytes(),Charset.forName("UTF-8"));

		Menuselect     = new JMenuItem(str6);
		MenuSiCopier     = new JMenuItem("Copier");
		MenuSauvegarder    = new JMenuItem("Sauvegarder");
		MenuSauvegarderPng = new JMenuItem("Exporter en Png");
		restaurer      = new JMenuItem("Restaurer");


		createNewFigure.add(MenuSiCreerPoint);
		createNewFigure.add(MenuSiCreerCercle); 
		createNewFigure.add(MenuSiCreerSegment); 
		createNewFigure.add(MenuSiCreerPoli); 
		createNewFigure.add(MenuSiCreerRectangle); 
		createNewFigure.add(MenuSiCreerTriangle); 
		fileMenu.add(createNewFigure);
		fileMenu.add(MenuSauvegarder);
		fileMenu.add(MenuSauvegarderPng);
		fileMenu.add(restaurer);
		fileMenu.add(MenuQuitter);
		editMenu.add(Menutranslater);
		editMenu.add(MenuSupprimer);
		editMenu.add(Menuselect);
		editMenu.add(MenuSiCopier);

		MenuSiCreerPoint.addActionListener(this);
		MenuSiCreerCercle.addActionListener(this);
		MenuSiCreerSegment.addActionListener(this);
		MenuSiCreerPoli.addActionListener(this);
		MenuSiCreerRectangle.addActionListener(this);
		MenuSiCreerTriangle.addActionListener(this);
		MenuQuitter.addActionListener(this);
		Menutranslater.addActionListener(this);
		MenuSupprimer.addActionListener(this);
		Menuselect.addActionListener(this);
		MenuSiCopier.addActionListener(this);
		MenuSauvegarder.addActionListener(this);
		MenuSauvegarderPng.addActionListener(this);
		restaurer.addActionListener(this);

		MenuQuitter.setIcon(IconMenuQuitter); 
		fileMenu.setIcon(IconFile);
		createNewFigure.setIcon(IconCreer); 
		MenuSauvegarderPng.setIcon(IconSavePng); 
		MenuSauvegarder.setIcon(IconSave); 
		restaurer.setIcon(IconRestore); 
		MenuSiCreerPoint.setIcon(IconPoint); 
		MenuSiCreerCercle.setIcon(IconCercle);
		MenuSiCreerSegment.setIcon(IconSegment);
		MenuSiCreerPoli.setIcon(IconPoli);
		MenuSiCreerRectangle.setIcon(IconRectangle);
		MenuSiCreerTriangle.setIcon(IconTriangle);
		Menutranslater.setIcon(IconMove);
		MenuSupprimer.setIcon(IconDelete);
		Menuselect.setIcon(IconSelect);
		MenuSiCopier.setIcon(IconCopy);
		editMenu.setIcon(IconEdit);
	}

	/**
	 * Permet de déclarer les icones
	 */
	private void iconSet() {
		IconFile      = new ImageIcon(this.getClass().getResource("res/IconFile.png"));
		IconMenuQuitter   = new ImageIcon(this.getClass().getResource("res/IconQuitter.png"));
		IconCreer     = new ImageIcon(this.getClass().getResource("res/IconCreer.png"));
		IconPoint     = new ImageIcon(this.getClass().getResource("res/IconPoint.png"));
		IconCercle    = new ImageIcon(this.getClass().getResource("res/IconCercle.png"));
		IconSegment   = new ImageIcon(this.getClass().getResource("res/IconSegment.png"));
		IconRectangle = new ImageIcon(this.getClass().getResource("res/IconRectangle.png"));
		IconPoli      = new ImageIcon(this.getClass().getResource("res/IconPolygon.png"));
		IconTriangle  = new ImageIcon(this.getClass().getResource("res/IconTriangle.png"));
		IconSavePng   = new ImageIcon(this.getClass().getResource("res/IconSavePng.png"));
		IconSave      = new ImageIcon(this.getClass().getResource("res/IconSavePng.png"));
		IconRestore   = new ImageIcon(this.getClass().getResource("res/IconRestore.png"));
		IconMove      = new ImageIcon(this.getClass().getResource("res/IconMove.png"));
		IconDelete    = new ImageIcon(this.getClass().getResource("res/IconDelete.png"));
		IconSelect    = new ImageIcon(this.getClass().getResource("res/IconSelect.png"));
		IconCopy      = new ImageIcon(this.getClass().getResource("res/IconCopy.png"));
		IconEdit      = new ImageIcon(this.getClass().getResource("res/IconEdit.png"));
		IconplayButton= new ImageIcon(this.getClass().getResource("res/playButton.png"));
		IconbackButton= new ImageIcon(this.getClass().getResource("res/backButton.png"));
	}	

	@Override
	public void actionPerformed(ActionEvent e) {

		String str3 = "Cliquer une fois sur la zone de dessin pour arrêter !"; 
		String str4 = new String(str3.getBytes(),Charset.forName("UTF-8"));

		String str5 = "Cliquer deux fois sur la zone de dessin pour arrêter !";
		String str6 = new String(str5.getBytes(),Charset.forName("UTF-8"));

		if(e.getSource().equals(InitProg)){
			setVisible(true);
			bienvenueButton();
			repaint();
		}else if(e.getSource().equals(ViderList)) clearList();
		else if(e.getSource().equals(MenuQuitter)) System.exit(0);

		//Active les actions des commandes seulement si le bouton InitList à été cliqué
		if(isVisible()){
			if(e.getSource().equals(MenuSiCreerPoint) || e.getSource().equals(pointbutton)){
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerPoint = true;

				bienvenueButton();
			} 
			else if(e.getSource().equals(MenuSiCreerSegment) || e.getSource().equals(segmentbutton)){ 
				SiCreerPoint = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerSegment = true;

				bienvenueButton();
			}
			else if(e.getSource().equals(MenuSiCreerCercle) || e.getSource().equals(cerclebutton)){ 
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerCercle = true;

				bienvenueButton();
			}
			else if(e.getSource().equals(MenuSiCreerPoli) || e.getSource().equals(polybutton)){ 
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerPoli = true;

				message = str6;
				InitProg.setText(message);
			}
			else if(e.getSource().equals(MenuSiCreerRectangle) || e.getSource().equals(rectanglebutton)){ 
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerTriangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerRectangle = true;

				message = str4;
				InitProg.setText(message);
			}
			else if(e.getSource().equals(MenuSiCreerTriangle) || e.getSource().equals(trianglebutton)){ 
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				Menuselected = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				select = false;
				SiCreerTriangle = true;

				message = str4;
				InitProg.setText(message);
			}
			else if(e.getSource().equals(MenuSupprimer)) {
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				translater = false;
				SiCopier = false; 
				select = false;
				Menuselected = true;
				MenuSupprimerFigures = true;

				bienvenueButton();
			}
			else if(e.getSource().equals(Menuselect)) {
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				Menuselected = true;
				select = true;

				if(select){
					message = "Choisissez une couleur puis une figure !";
					InitProg.setText(message);
				}
			}
			else if(e.getSource().equals(Menutranslater)) {
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				MenuSupprimerFigures = false;
				select = false;
				Menuselected = true;
				translater = true;

				bienvenueButton();
			}
			else if(e.getSource().equals(MenuSiCopier)) {
				SiCreerPoint = false;
				SiCreerSegment = false;
				SiCreerCercle = false;
				SiCreerPoli = false;
				SiCreerRectangle = false;
				SiCreerTriangle = false;
				MenuSupprimerFigures = false;
				translater = false;
				select = false;
				Menuselected = true;
				SiCopier = true;  

				bienvenueButton();
			}
			else if(e.getSource().equals(colorbutton)) {
				MenuSupprimerFigures = false;
				translater = false;
				SiCopier = false; 
				Menuselected = true;
				couleur = JColorChooser.showDialog(frame, "Choix d'une couleur", Color.BLACK);
				repaint();

				if(!select) bienvenueButton();
			}
			else if(e.getSource().equals(MenuSauvegarder)){
				if(figures.size() != 0) MenuSauvegarder();
				else {
					showMessage("Le document est vide : veuillez dessiner quelque chose avant de sauvegarder x)");
				}

				bienvenueButton();
			}
			else if(e.getSource().equals(MenuSauvegarderPng)){
				if(figures.size() != 0) save(this);
				else {
					showMessage("Le document est vide : veuillez dessiner quelque chose avant d'exporter en PNG x)");
				}

				bienvenueButton();
			}
			else if(e.getSource().equals(restaurer)){
				if(figures.size() == 0) Restaurer();
				else {
					showMessage("Veuillez vider la liste de figures, avant de restaurer :/");
				}

				bienvenueButton();
			}
		}

		if(e.getSource().equals(playButton)){
			try {
				game = new MyGame();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JFrame fenetre = new JFrame();
			fenetre.setSize(800, 600);
			//Donne la taille minimale de la fenetre
			fenetre.setMinimumSize(new Dimension(800, 600));
			fenetre.setMaximumSize(new Dimension(800, 600));
			fenetre.setBackground(new Color(41, 128, 185));
			fenetre.setLayout(new FlowLayout());

			String str1 = "★ FreshPaint ★"; 
			String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));
			//Lui donner un titre
			fenetre.setTitle(str2);

			//Changer l'icone de la fenÃƒÂªtre
			fenetre.setIconImage(Toolkit.getDefaultToolkit().getImage(ZoneDeDessin.class.getResource("res/Icon.png"))); 

			//Met la fenetre au centre de l'Ã©cran
			fenetre.setLocationRelativeTo(frame);
			fenetre.add(game);
			fenetre.setVisible(true);

			fenetre.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					frame.setEnabled(true);
					game.getAmbience().stop();
				}
			});

			game.addMouseMotionListener(game);
			game.addMouseListener(game);
		}
	}

	/**
	 * Définie le text du bouton InitList à sa valeur par défaut
	 */
	private void bienvenueButton() {
		message = "Bienvenue !";
		InitProg.setText(message);
	}

	/**
	 * @param listeFigures Vérifie que la liste complête de figure est sérialisable
	 * @param out
	 */
	public void SauveQuiPeut(LinkedList<LinkedList<Figure>> listeFigures, ObjectOutputStream out){
		if(listeFigures instanceof Serializable)
			try { out.writeObject(listeFigures); } 
		catch (IOException e) { e.printStackTrace();}
	}

	/**
	 * Permet d'afficher les figures se trouvant dans un fichier (désérialisation)
	 */
	@SuppressWarnings("unchecked")
	public void Restaurer(){
		JFileChooser fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ser", "SER");

		String str1 = "Choisir un fichier à  restaurer !"; 
		String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));

		String str3 = "Restauration terminée avec succès :)"; 
		String str4 = new String(str3.getBytes(),Charset.forName("UTF-8"));

		String str5 = "Aucune sauvegarde n'a été trouvée :("; 
		String str6 = new String(str5.getBytes(),Charset.forName("UTF-8"));

		int savefile = fileChooserSetting(fileDialog, filter, str2);

		if(savefile==JFileChooser.APPROVE_OPTION){
			File file = fileDialog.getSelectedFile();
			if(file.length() != 0){
				LinkedList<LinkedList<Figure>> figuresRestaurer = null;
				try {
					InputStream fileIn = new FileInputStream(file);
					ObjectInputStream in = new ObjectInputStream(fileIn);
					figuresRestaurer = (LinkedList<LinkedList<Figure>>) in.readObject();
					in.close();
					fileIn.close();
				}catch (IOException | ClassNotFoundException l) {showMessage("OUPS! Ce fichier ne semble pas contenir de sauvegarde :(");}

				if(figuresRestaurer.size() != 0){
					for(LinkedList<Figure> x : figuresRestaurer) for(Figure y : x) figures.add(y);
					repaint();
					showMessage(str4);
				}
			}else showMessage(str6);
		}
	}

	/**
	 * @param title Permet d'afficher un message dans une petite fenêtre
	 */
	private static void showMessage(String title) {
		message = new String(title);
		javax.swing.JOptionPane.showMessageDialog(frame,message);
	}

	/**
	 * Permet de sauvegarder les figures des listes dans un fichier grâce à la sérialisation
	 */
	public void MenuSauvegarder(){
		JFileChooser fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ser", "SER");

		int savefile = fileChooserSetting(fileDialog, filter, "Choisir un dossier de destination !");

		if(savefile==JFileChooser.APPROVE_OPTION){
			File file = new File(fileDialog.getSelectedFile() + ".SER");
			try {
				OutputStream f = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(f);
				listeFigures.add(figures);
				if(figuresCloner.size() != 0) listeFigures.add(figuresCloner);
				SauveQuiPeut(listeFigures, out);		
				out.close(); 

				String str1 = "Sauvegarde terminée avec succès :)"; 
				String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));
				showMessage(str2);
			} catch (IOException e1) { e1.printStackTrace();}
		}

	}

	/**
	 * @param fileDialog
	 * @param filter
	 * @param title
	 * @return le fichier sauvegardé et modifie fileDialog
	 */
	private static int fileChooserSetting(JFileChooser fileDialog, FileNameExtensionFilter filter, String title) {
		fileDialog.setFileFilter(filter);
		fileDialog.setDialogTitle(title);
		fileDialog.setAcceptAllFileFilterUsed(false);
		int savefile = fileDialog.showSaveDialog(frame);
		return savefile;
	}

	/**
	 * @param panel Sauvegarde le panel dans une image PNG et permet de choisir le lieu de sauvegarde
	 */
	public static void save(JPanel panel)
	{
		BufferedImage bufferedImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics graphic = bufferedImage.createGraphics();
		panel.paint(graphic);

		JFileChooser fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "PNG");

		int savefile = fileChooserSetting(fileDialog, filter, "Choisir un dossier de destination !");

		if(savefile==JFileChooser.APPROVE_OPTION){
			File file = new File(fileDialog.getSelectedFile() + ".PNG");

			try {ImageIO.write(bufferedImage, "png", file);}
			catch(IOException exception) {exception.printStackTrace();}

			String str1 = "Image sauvegardée en .PNG avec succès :)"; 
			String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));
			showMessage(str2);
		}
	}

	public static void main(String[] args){
		frame = new JFrame();
		//Donne la taille de base de la fenÃƒÂªtre
		frame.setSize(800, 600);
		//Donne la taille minimale de la fenetre
		frame.setMinimumSize(new Dimension(650, 600));

		String str1 = "★ FreshPaint ★"; 
		String str2 = new String(str1.getBytes(),Charset.forName("UTF-8"));

		//Lui donner un titre
		frame.setTitle(str2);

		//Changer l'icone de la fenÃƒÂªtre
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ZoneDeDessin.class.getResource("res/Icon.png"))); 

		//OpÃƒÂ©ration quand on ferme par dÃƒÂ©faut
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Met la fenetre au centre de l'Ã©cran
		frame.setLocationRelativeTo(null);

		contenu = frame.getContentPane();
		//on crÃƒÂ©e les panneaux
		panneauNord = new JPanel();
		ZoneDeDessin zoneDessin = new ZoneDeDessin();

		panneauSud = new JPanel();
		panneauNord.setBackground(new Color(41, 128, 185));
		panneauSud.setBackground(new Color(41, 128, 185));
		zoneDessin.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		//cl = UIManager.getColor ( InitList.getBackground() ); rÃ©cupÃ¨re la couleur du bouton InitList

		zoneDessin.setBackground(Color.white);

		panneauNord.setSize(800, 400);
		panneauSud.setSize(800, 400);

		//On ajoute les panneaux Ã Â  la fenÃªtre
		contenu.add(panneauNord, BorderLayout.NORTH);
		contenu.add(zoneDessin, BorderLayout.CENTER);
		contenu.add(panneauSud, BorderLayout.SOUTH);
		contenu.setBackground(new Color(236, 240, 241));

		//On ajoute les boutons Ã Â  la fenÃƒÂªtre
		panneauNord.add(zoneDessin.InitProg);
		panneauNord.add(zoneDessin.ViderList);
		panneauNord.add(zoneDessin.colorbutton);

		panneauSud.add(zoneDessin.pointbutton);
		panneauSud.add(zoneDessin.segmentbutton);
		panneauSud.add(zoneDessin.cerclebutton);
		panneauSud.add(zoneDessin.polybutton);
		panneauSud.add(zoneDessin.rectanglebutton);
		panneauSud.add(zoneDessin.trianglebutton);
		panneauSud.add(zoneDessin.playButton);
		panneauSud.add(zoneDessin.menu);

		//Color cl = new Color(15, 24, 32);
		zoneDessin.setLayout(new FlowLayout());
		zoneDessin.createMenuBar(frame);
		zoneDessin.setVisible(false);

		frame.repaint();
		frame.setVisible(true);

	}
}
