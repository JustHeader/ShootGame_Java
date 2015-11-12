package com.entity;

import java.util.Random;

import com.control.ShootGame;
import com.util.Award;
import com.util.FlyingObject;
/**
 * 蜜蜂
 * @author Ling_丶
 *
 */
public class Bee extends FlyingObject implements Award{
	
	private int xSpeed =1;//x坐标移动速度
	private int ySpeed =2;//y坐标移动速度
	private int awardType;//奖励类型
	
	@Override
	public int getType() {
		return awardType;
	}
	
	public Bee(){
		this.image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;
		Random random = new Random();
		x = random.nextInt(ShootGame.WIDTH - width);
		awardType = random.nextInt(2);
//		x =120;y=230;
	}

	@Override
	public void step() {//可以斜飞
		x +=xSpeed;
		y +=ySpeed;
		if(x>ShootGame.WIDTH-width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return y>ShootGame. HEIGHT;
	}
}
