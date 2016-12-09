package logicieldedessin;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JComponent;

/**
 * @author freshloic
 *
 */
public class MyGame extends JComponent implements MouseMotionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	BufferedImage intro;
	BufferedImage level1;
	BufferedImage level2;
	BufferedImage level3;
	BufferedImage gameover;
	BufferedImage currentLevel;
	private int level1wallcolor;
	private int level2wallcolor;
	private int goalcolor;
	private int x;
	private int y;
	private int color;
	private int level3wallcolor;
	AudioClip scream;
	AudioClip ambience;

	public AudioClip getAmbience() {
		return ambience;
	}

	public void setAmbience(AudioClip ambience) {
		this.ambience = ambience;
	}

	public MyGame() throws IOException {
		//source image fait par moi 
		intro    = ImageIO.read(ZoneDeDessin.class.getResource("res/intro.png"));
		level1   = ImageIO.read(ZoneDeDessin.class.getResource("res/level1.png"));
		level2   = ImageIO.read(ZoneDeDessin.class.getResource("res/level2.png"));
		level3   = ImageIO.read(ZoneDeDessin.class.getResource("res/level3.png"));
		gameover = ImageIO.read(ZoneDeDessin.class.getResource("res/game over.jpg"));

		//source audio freeSound
		scream       = JApplet.newAudioClip(ZoneDeDessin.class.getResource("res/220623_adriancalzon_scream-05.wav"));
		ambience     = JApplet.newAudioClip(ZoneDeDessin.class.getResource("res/33987__erh__slow-atmosphere-4.wav"));
		currentLevel = intro;

		ambience.loop();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(currentLevel, 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		color = currentLevel.getRGB(x, y);

		level1wallcolor = -1618884;
		level2wallcolor = -13877680;
		level3wallcolor = -15789044;
		goalcolor = -9787584;

		if(color == goalcolor){
			if(currentLevel == intro) currentLevel = level1;
			else if(currentLevel == level1) currentLevel = level2;
			else if(currentLevel == level2) currentLevel = level3;
		}

		if(color == level1wallcolor){
			currentLevel = intro;
		}else if(color == level2wallcolor || color == level3wallcolor){
			scream.play();
			ambience.stop();
			currentLevel = gameover;
		}

		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(currentLevel == gameover) currentLevel = intro;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
