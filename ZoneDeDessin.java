package logicieldedessin;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LinkedList<Figure> figures;
	
	public void paint(Graphics g){
		super.paint(g);
		for(Figure f : figures) f.paint(g);
	}

}
