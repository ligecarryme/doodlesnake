package com.snake;


import java.awt.Point;
import javax.swing.JFrame;

public class Window extends JFrame {
	Snake snake;
	Food food;
	OtherSnake otherSnake;
	MyPanel panel;
	Thread thread,thread2;
	public Window() {
		// TODO 自动生成的构造函数存根
		setTitle("贪吃蛇小游戏");
		setVisible(true);
		setSize(40*20, 30*20);
		//setLocation(0, 0);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		otherSnake=new OtherSnake();
		snake=new Snake(new Point(15, 15),otherSnake);
		food=new Food(snake);
		panel=new MyPanel(snake,food,otherSnake);
		thread=new Thread(panel);
		thread2=new Thread(otherSnake);
		thread.start();
		thread2.start();
		add(panel);
		addKeyListener(panel);
		this.validate();
	}
}