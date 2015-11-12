package com.entity;

import com.control.ShootGame;
import com.util.Award;
import com.util.Enemy;
import com.util.FlyingObject;

/**
 * 敌飞机
 * @author Ling_丶
 *
 */
public class AirPlane extends FlyingObject implements Enemy{
	
	private int speed =2;
	
	public AirPlane(){
		this.image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		x = (int) (Math.random()*(ShootGame.WIDTH - width));
		y = -height;
//		x=100;y=200;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		y+=speed;
	}
	
	public int getScore(){
		return 5;
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return y>ShootGame. HEIGHT;
	}
}
