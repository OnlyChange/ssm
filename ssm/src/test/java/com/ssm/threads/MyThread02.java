package com.ssm.threads;
/**
 * 使用interrupt()结束线程
 * {@link http://www.jianshu.com/p/536b0df1fd55}
 * @author limn
 * @since  2016年12月20日 下午3:40:02
 */
public class MyThread02 extends Thread {
	 @Override
     public void run() {
         while (!Thread.currentThread().isInterrupted()) {
             try {
                 System.out.println("test");
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 System.out.println("interrupt");
                 //抛出InterruptedException后中断标志被清除，标准做法是再次调用interrupt恢复中断
                 Thread.currentThread().interrupt();
             }
         }
         System.out.println("stop");
     }

     public void cancel(){
         interrupt();
     }
}
