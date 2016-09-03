package com.sae.express.util.commont;

import java.util.Random;

/**
 * 生成随机字符串
 * @author liuyuan
 *
 */
public class RandomUtil {

	private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	private static final Random RANDOM = new Random();

	public static String getRandomStr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
		}
		return sb.toString();
	}
	
	public static String getRandomNum(int num){
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < num; i++) {
			sb.append(r.nextInt(9));
		}
		return sb.toString();
	}
}
