package com.entity;


import java.awt.image.BufferedImage;

import com.control.ShootGame;
import com.util.FlyingObject;

/**
 * 英雄机
 * @author Ling_丶
 *
 */
public class Hero extends FlyingObject{
	
	private int doubleFire;//双倍火力
	private int life;//生命
	protected BufferedImage[] images = {};//英雄机的2张图片
	protected int index = 0;//英雄机2张图交换的计数
	
	
	public Hero() {
		life = 3;
		doubleFire = 0;
		this.image = ShootGame.hero0;
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};//记得数组是用{}
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
	}


	@Override
	public void step() {//实现英雄机图片轮换
		if(images. length>0){
			image = images[index++/10%images. length];
		}
	}
	
	public Bullet[] shoot() { // 发射子弹
		int xStep = width / 4;
		int yStep = 20;
		if (doubleFire>0) {
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(x + xStep, y - yStep);
			bullets[1] = new Bullet(x + 3 * xStep, y - yStep);
			doubleFire -= 2;
			return bullets;
		}else{
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(x + 2 * xStep, y - yStep);
			return bullets;
		}
	}
	
	/**
	 * 当前物体移动了一下，相对距离， x,y 鼠标位置
	 */
	public void moveTo(int x, int y) {
		this. x = x - width / 2;
		this. y = y - height / 2;
	}
	
	public void addDoubleFire(){
		doubleFire += 40;
	}
	
	public void addLife() { // 增命
		life++;
	}
	
	public int getLife() {
		return life;
	}


	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	public void subtractLife() { // 减命
		life--;
	}
	public void setDoubleFire(int doubleFire) {
		this. doubleFire = doubleFire; 
	}
	
	public boolean hit(FlyingObject other) { // 碰撞算法
		int x1 = other.getX() - this. width / 2;
		int x2 = other.getX() + other.getWidth() + this. width / 2;
		int y1 = other.getY() - this. height / 2;
		int y2 = other.getY() + other.getHeight() + this. height / 2;
		return this. x + this. width / 2 > x1 && this. x + this. width / 2 < x2&& this. y + this. height / 2 > y1&& this. y + this. width / 2 < y2;
	}
}
