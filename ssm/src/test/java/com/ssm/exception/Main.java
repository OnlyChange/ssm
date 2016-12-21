package com.ssm.exception;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 在任务中抛出异常
 * {@link <a>http://blog.csdn.net/coslay/article/details/45542853</a>}
 * @author Charlie
 * @since  2016年12月21日 下午9:46:33
 */
public class Main {

	public static void main(String[] args) {
		int array[]=new int[100];
		//RecursiveTask：任务具有返回值
		//RecursiveAction：任务没有返回值
		Task task=new Task(array,0,100);
		ForkJoinPool pool=new ForkJoinPool();
		//执行任务
		pool.execute(task);
		//关闭线程池
		pool.shutdown();
		try {
			//关闭请求、超时或当前线程发生中断后阻塞直到所有的任务执行完毕
		    pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		//判断任务是否抛出异常或取消
		if (task.isCompletedAbnormally()) {
		    System.out.printf("Main: An exception has ocurred\n");
		    System.out.printf("Main: %s\n",task.getException());
		}
		//得到任务执行结果
		System.out.printf("Main: Result: %d",task.join());
	}
}
