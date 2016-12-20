package com.ssm.threads;
import static java.lang.System.*;
/**
 * 通过标志位结束线程
 * {@link http://www.jianshu.com/p/536b0df1fd55}
 * @author limn
 * @since  2016年12月20日 下午3:23:01
 */
public class MyThread01 extends Thread {
	private volatile boolean isCancelled;

	public void run() {
		while (!isCancelled) {
			out.println("doing...");// do something
		}
	}

	public void cancel() {
		isCancelled = true;
	}
	
	public boolean getFlag()
	{
		return isCancelled;
	}
}
