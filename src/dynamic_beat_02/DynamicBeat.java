package dynamic_beat_02;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	// for double bufferring
	private Image screenImage;
	private Graphics screenGraphic;
	// for introBackGround image
	private Image introBackGround;
	
	public DynamicBeat() {
		setTitle("DynamicBeat");
		setSize(Main.SCREEN_WITDH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		introBackGround = new ImageIcon(Main.class.getResource("../Images/introBackGround(Title).jpg")).getImage();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WITDH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackGround, 0, 0, null);
		this.repaint();
	}



}
