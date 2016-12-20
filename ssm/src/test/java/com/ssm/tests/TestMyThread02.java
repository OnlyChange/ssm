package com.ssm.tests;

import com.ssm.threads.MyThread02;

public class TestMyThread02 {
	public static void main(String[] args) {
		MyThread02 myThread02 = new MyThread02();
		myThread02.start();
		try {
			Thread.sleep(3000);
			myThread02.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
