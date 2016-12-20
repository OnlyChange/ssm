package com.ssm.tests;

import com.ssm.threads.MyThread01;
import static java.lang.System.*;
public class TestMyThread01 {
	public static void main(String[] args) {
		MyThread01 mt = new MyThread01();
		mt.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.cancel();
	}
}
