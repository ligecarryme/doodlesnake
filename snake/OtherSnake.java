package com.snake;


import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class OtherSnake implements Runnable{
	LinkedList<Point> body;
	Random r;
	Point point;
	int x,y,n;
	int length;
	String string;
	Snake snake;
	Food food;
	public OtherSnake() {
		//this.hand=hand;
		body=new LinkedList<Point>();
		r=new Random();
		x=r.nextInt(30)+5;
		y=r.nextInt(20)+5;
		string=JOptionPane.showInputDialog(null,"输入敌蛇的整数长度(1~50 easy;51~999 hard):","",JOptionPane.PLAIN_MESSAGE);
			if(string==null || string.equals("0"))System.exit(0);
			length=Integer.valueOf(string);
		for(int j=0;j<length;j++){
			Point point=new Point(x+j, y);
			body.add(point);
			}
		}
	/*boolean isEat(Food food){
		if(x==food.x && y==food.y) return true;
		return false;
	}*/
	
	public void move(){
		int dir;
		r=new Random();
		int[] a=new int[]{0,1,1,1,1,1,1,1,1,1,1,2,2,2,3};
		dir=a[r.nextInt(15)];
		if ((n==0 && dir==1)||(n==1 && dir==0)||(n==2 && dir==3)||(n==3 && dir==2)) {
			return;	
		}
		/*System.out.println("1"+dir);*/
		switch (dir) {
		case 0:
			y--;
			if (y<1) {
				y=26;
			}
			break;
			
		case 1:
			y++;
			if (y>26) {
				y=1;
			}
			break;
		case 2:
			x--;
			if (x<1) {
				x=37;
			}
			break;
		case 3:
			x++;
			if (x>37) {
				x=1;
			}
			break; 
		}
		n=dir;
		//System.out.println("2"+n);
		Point point=new Point(x,y);
		//if (body.size()<=20) {
		body.addFirst(point);
		body.removeLast();
		
	//System.out.println("x="+x+"y="+y);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			move();
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
			}
		}
	}
}
	/*	for(int i=0;i<5;i++){
		x=r.nextInt(36);
		y=r.nextInt(27);
		for(int j=0;j<3;j++){
		Point point=new Point(x+j, y);
		body.add(point);}
		}
		// TODO 自动生成的构造函数存根
	}*/
	

