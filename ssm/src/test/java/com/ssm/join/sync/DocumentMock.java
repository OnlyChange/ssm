package com.ssm.join.sync;

import java.util.Random;

/**
 * DocumentMock
 * 
 * @author limn
 * @since 2016年12月20日 下午5:39:46
 */
public class DocumentMock {

	private String words[] = { "the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main" };

	/**
	 * 产生文档
	 * @param numLines	行数
	 * @param numWords	每一行词的个数
	 * @param word		准备要查找的词
	 * @return
	 * @author limn
	 * @since  2016年12月21日 下午4:36:27
	 */
	public String[][] generateDocument(int numLines, int numWords, String word) {
		int counter = 0;
		String document[][] = new String[numLines][numWords];
		Random random = new Random();
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numWords; j++) {
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if (document[i][j].equals(word)) {
					counter++;
				}
			}
		}
		System.out.println("DocumentMock: The word appears " + counter + " times in the document");
		return document;
	}
}
