import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class PackmanT extends JFrame{
	Image img;
	MyCanvas mc;
	
	/////////////////////
	Dimension frameSize, canvasSize;
	int x,y;
	int p = 0;
	public PackmanT(){
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		mc = new MyCanvas();
		add(BorderLayout.CENTER, mc);
		setSize(500,500);
		getPackManSize();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mc.setBackground(Color.white);
		mc.addKeyListener(new CanvasKeyEvent());
		//JFrame, Canvas크기
		//시작좌표
		getPackManSize();
		x = (int)canvasSize.getWidth()/2-25;
		y = (int)canvasSize.getHeight()/2-25;
		
		mc.setFocusable(true);
		
		while(true) {
			try {Thread.sleep(200);}catch(Exception e) {}
			//이미지 변환
			if(p%2 ==0) {
				p++;
			}else {
				p--;
			}
			
			//방향바꾸기
			if(p==0 || p==1) {
				x -= 5;
				if(x<= -50){
					x=(int)canvasSize.getWidth();
				}
			}else if(p==2 || p==3) {
				x+=5;
				if(x>=(int)canvasSize.getWidth()) x=0;
			}else if(p ==4 || p==5) {
				y -=5;
				if(y <= -5 ) {
					y = (int)canvasSize.getHeight();
				}
			}else if(p==6 || p==7) {
				y+=5;
				if(y>=(int)canvasSize.getHeight()) y=-50;
			}
			
			mc.repaint();
			
		}
	}
	public class CanvasKeyEvent extends KeyAdapter{
		public void keyReleased(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				p=0;
			}else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				p=2;
			}else if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
				p=4;
			}else if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
				p=6;
			}
		}
	}
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(img, x, y, x+50, y+50, p*50, 0, p*50+50, 50, this);
		}
	}
	public void getPackManSize() {
		frameSize = getSize();
		canvasSize = mc.getSize();
	}
	public static void main(String[] args) {
		new PackmanT();

	}

}




















