package com.snake;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyPanel extends JPanel implements KeyListener, Runnable {
	private static final int BODY_SIZE=20;
	private static final int UP=0;
	private static final int DOWN=1;
	private static final int LEFT=2;
	private static final int RIGHT=3;
	int speed=300;
	Snake snake;
	Food food;
	OtherSnake otherSnake;
	public MyPanel(Snake snake,Food food,OtherSnake otherSnake) {
		// TODO 自动生成的构造函数存根
		this.snake=snake;	
		this.food=food;
		this.otherSnake=otherSnake;
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.GRAY);
		for (int i = 0; i <39; i++) {
			g.fill3DRect(i*BODY_SIZE, 0, BODY_SIZE, BODY_SIZE, true);
			g.fill3DRect(0, i*BODY_SIZE, BODY_SIZE, BODY_SIZE, true);
			g.fill3DRect(i*BODY_SIZE, 543, BODY_SIZE, BODY_SIZE, true);
			g.fill3DRect(762, i*BODY_SIZE, BODY_SIZE, BODY_SIZE, true);
			}
		g.setColor(Color.YELLOW);
		for(Point it:otherSnake.body)
			g.fill3DRect(it.x*BODY_SIZE, it.y*BODY_SIZE, BODY_SIZE,BODY_SIZE,true);
		g.setColor(Color.BLUE);
		g.fill3DRect(otherSnake.body.getFirst().x*BODY_SIZE, otherSnake.body.getFirst().y*BODY_SIZE, BODY_SIZE, BODY_SIZE, true);
		g.setColor(Color.GREEN);
		g.fill3DRect(food.x* BODY_SIZE, food.y*BODY_SIZE, BODY_SIZE,BODY_SIZE, true);
		for(Point it:snake.body)
			g.fill3DRect(it.x*BODY_SIZE,it.y*BODY_SIZE,BODY_SIZE, BODY_SIZE, true);
		g.setColor(Color.RED);
		g.fill3DRect(snake.head.x*BODY_SIZE, snake.head.y*BODY_SIZE, BODY_SIZE, BODY_SIZE, true);
		
	}
	public void move(int dir){
		//System.out.println("moving");
		dir=snake.dir;
		switch (dir) {
		case UP:
			snake.head.y--;
			if (snake.head.y<0) {
				snake.head.y=27;
			}
			break;
		case DOWN:
			snake.head.y++;
			if (snake.head.y>27) {
				snake.head.y=0;
			}
			break;
		case LEFT:
			snake.head.x--;
			if (snake.head.x<0) {
				snake.head.x=38;
			}
			break;
		case RIGHT:
			snake.head.x++;
			if (snake.head.x>38) {
				snake.head.x=0;
			}
			break;
		}
		Point p=new Point(snake.head);
		snake.body.addFirst(p);
		if(snake.isEat(food)){
			food = new Food(snake);
		}else 
			snake.body.removeLast();
		if (snake.isOut()) {
			JOptionPane.showMessageDialog(this,"YOU DEAD!!!"+"你的长度: "+snake.body.size(),"死亡窗口",JOptionPane.WARNING_MESSAGE);
			System.out.println("YOU DEAD!!!");
			snake.Dead(0);
		}
		if (snake.isCrash()) {
			JOptionPane.showMessageDialog(this,"YOU DEAD HAHAHA!!!"+"你的长度: "+snake.body.size(),"死亡窗口",JOptionPane.WARNING_MESSAGE);
			System.out.println("YOU DEAD HAHAHA!!!");
			snake.Dead(0);
		}
		if (snake.isCollide()) {
			JOptionPane.showMessageDialog(this,"YOU DEAD HAHA!!!"+"你的长度: "+snake.body.size(),"死亡窗口",JOptionPane.WARNING_MESSAGE);
			System.out.println("YOU DEAD HAHA!!!");
			snake.Dead(0);
		}
		if (snake.isWin()==1) {
			int m=JOptionPane.showConfirmDialog(this,"      你的长度: "+snake.body.size()+"  YOU WIN!!! 是否继续？","胜利窗口",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);	
			if (m==JOptionPane.NO_OPTION || m==JOptionPane.CLOSED_OPTION) {
					snake.Dead(0);
				}
			}
		speed+=10;	
		//System.out.println("你的长度:"+snake.body.size()+"  YOU WIN!!!");
		repaint();
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			move(snake.dir);
			//otherSnake.move();
		//System.out.println("+++"+otherSnake.body);
			//otherSnake2.move(RIGHT);
			//otherSnake3.move(DOWN);
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
				// TODO: handle exception
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		speed-=12;
		//speed+=10;
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			 snake.dir=LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			snake.dir=RIGHT;
			break;
		case KeyEvent.VK_UP:
			snake.dir=UP;
			break;
		case KeyEvent.VK_DOWN:
			snake.dir=DOWN;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

}
