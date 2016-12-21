package com.ssm.task.cancel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * TaskManager
 * @author Charlie
 * @since  2016年12月21日 下午10:31:03
 */
public class TaskManager {
	private List<ForkJoinTask<Integer>> tasks;
	public TaskManager(){
	    tasks=new ArrayList<ForkJoinTask<Integer>>();
	}
	public void addTask(ForkJoinTask<Integer> task){
	    tasks.add(task);
	}
	public void cancelTasks(ForkJoinTask<Integer> cancelTask){
	    for (ForkJoinTask<Integer> task :tasks) {
	        if (task!=cancelTask) {
	            task.cancel(true);
	            ((SearchNumberTask)task).writeCancelMessage();
	        }
	    }
	}
	
}
