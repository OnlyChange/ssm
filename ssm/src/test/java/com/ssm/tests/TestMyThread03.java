package com.ssm.tests;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ssm.threads.MyThread03;

public class TestMyThread03 {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<?> task = es.submit(new MyThread03());
		try {
			// 限定时间获取结果
			task.get(5, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// 超时触发线程中止
			System.out.println("thread over time");
		} catch (ExecutionException e) {
			throw e;
		} finally {
			boolean mayInterruptIfRunning = true;
			task.cancel(mayInterruptIfRunning);
//			es.shutdown();//关闭执行器
		}
	}
}
