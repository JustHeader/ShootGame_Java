package com.util;
/**
 * 奖励接口：双倍活力和增加性命
 * @author Ling_丶
 *
 */
public interface Award {
	int DOUBLE_FIRE = 0;// 双倍火力
	int LIFE = 1;// 1条命
	/**
	 * 获取奖励类型
	 * @return
	 */
	int getType();
}
