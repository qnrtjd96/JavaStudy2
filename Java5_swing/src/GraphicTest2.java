import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicTest2 extends JFrame{
	
	MyCanvas mc = new MyCanvas();
	public GraphicTest2() {
		add(mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		while(true) {
			mc.repaint();
			//일시정지
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
		}
	}
	
	public class MyCanvas extends Canvas{
		Random ran = new Random();
		public void paint(Graphics g) {
			int x = ran.nextInt(700);
			int y = ran.nextInt(700);
			g.fillOval(x, y, 10, 10);
		}
		public void update(Graphics g) {
			paint(g);
		}
	}
	public static void main(String[] args) {
		new GraphicTest2();

	}

}
