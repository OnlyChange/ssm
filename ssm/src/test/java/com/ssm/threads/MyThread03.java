package com.ssm.threads;
/**
 * 手动处理异常不易，使用线程池（Executors）简化工作
 * {@link http://www.jianshu.com/p/536b0df1fd55}
 * @author limn
 * @since  2016年12月20日 下午3:43:27
 */
public class MyThread03 extends Thread {
	@Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {   
            try {
                System.out.println("count");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupt");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("thread stop");
    }

    public void cancel() {
        interrupt();
    }
}
