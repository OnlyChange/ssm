package com.ssm.join.async;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * FolderProcessor
 * 
 * @author Charlie
 * @since 2016年12月21日 下午8:58:22
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = -4260300558499335560L;

	/**
	 * 文件夹路径
	 */
	private String path;

	/**
	 * 要查找的文件扩展名
	 */
	private String extension;

	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	protected List<String> compute() {
		List<String> list = new ArrayList<String>();
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		File file = new File(path);
		File content[] = file.listFiles();
		if (content != null) {
			for (int i = 0; i < content.length; i++) {
				if (content[i].isDirectory()) {
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
					task.fork();//fork()：异步执行，invokeAll()：同步执行
					tasks.add(task);
				} else {
					if (checkFile(content[i].getName())) {
						list.add(content[i].getAbsolutePath());
					}
				}
			}
			if (tasks.size() > 50) {
				System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
			}
			addResultsFromTasks(list, tasks);
		}
		return list;
	}

	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
		for (FolderProcessor item : tasks) {
			list.addAll(item.join());
		}
	}

	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}
}