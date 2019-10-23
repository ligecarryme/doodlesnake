package com.snake;


import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;
public class Snake {
	private static final int UP=0;
	private static final int DOWN=1;
	private static final int LEFT=2;
	private static final int RIGHT=3;
	//int length=2;
	int dir=RIGHT;
	int n=0;
	//int direction;
	LinkedList<Point> body;
	Point head;
	Food food;
	private OtherSnake otherSnake;
	//OtherSnake otherSnake;
	public Snake(Point head,OtherSnake otherSnake) {
		// TODO 自动生成的构造函数存根
			this.head=head;
			this.otherSnake=otherSnake;
			body=new LinkedList<Point>();
			//for(int i=0;i<3;i++){
			Point point=new Point(head.x,head.y);
			body.add(point);
			//}	
			
	}
	
	boolean isEat(Food food){
		if(head.x==food.x && head.y==food.y) return true;
		return false;
	}
	boolean isOut(){
		if (head.x<=0 || head.x>=38 || head.y<=0 || head.y>=27) {
			return true;
		}
		return false;
	}
	boolean isCrash(){
		//System.out.println(head+" sss "+otherSnake.body+"oooo"+otherSnake.y);
		for (int i = 0; i < otherSnake.body.size(); i++) {
			if (otherSnake.body.get(i).equals(head)) {
				return true;
			}
		}
		return false;
		
	}
	boolean isCollide(){
		for (int i = 0; i < body.size(); i++) {
		if (body.get(i).equals(otherSnake.body.getFirst())) {
			return true;
			}
		}
		return false;
	}
	public int isWin(){
		if (body.size()==20) {
			n+=1;
		}
		return n;
		
		
	}
	void Dead(int dead){
		System.exit(dead);
		//Thread.interrupted();
	}
}
class Food{
	 Snake snake;
	 int x,y;
	 boolean flag;
	//private OtherSnake otherSnake;
	public Food(Snake snake) {
		this.snake=snake;
		int x=0;
		int y=0;
		Random random=new Random();
		flag=true;
		while (flag) {
			flag=false;
			x=random.nextInt(35)+2;
			y=random.nextInt(25)+2;
			if (snake.head.x==x && snake.head.y==y) flag=true;
			for(Point it:snake.body) if(it.x==x && it.y==y) flag = true;
			//for(Point its:otherSnake.body) if(its.x==x && its.y==y) flag=true;
		}
		
		this.x = x;
		this.y = y;
	}
}

	
