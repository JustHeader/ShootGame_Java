package com.entity;

import com.control.ShootGame;
import com.util.FlyingObject;
/**
 * 子弹
 * @author Ling_丶
 *
 */
public class Bullet extends FlyingObject{
	
	private int speed = 3;
	
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}

	@Override
	public void step() {
		y-=speed;
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return y<-height;
	}
}
