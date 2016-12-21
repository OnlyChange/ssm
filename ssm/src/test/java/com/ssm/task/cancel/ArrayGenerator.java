package com.ssm.task.cancel;

import java.util.Random;

/**
 * ArrayGenerator
 * 
 * @author Charlie
 * @since 2016年12月21日 下午10:11:13
 */
public class ArrayGenerator {

	public int[] generateArray(int size) {
		int array[] = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}
}
