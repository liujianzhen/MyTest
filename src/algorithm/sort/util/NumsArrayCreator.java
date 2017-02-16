package algorithm.sort.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * �ı�n���Ե������ɵ������������ĳ���
 * �������������飬�������numsArray.txt�ļ���
 * @author liujianzhen
 *
 */
public class NumsArrayCreator {

	public static void main(String[] args) throws Exception {

		int n = 5000;//��������ĳ���
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = (int)(Math.random()*n);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(String.valueOf(nums[i])+",");
		}
		String filepath = "G:/eclipseJavaEE/MyTest/src/algorithm/sort/numsArray.txt";
		File file = new File(filepath);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.close();
		fw.close();
	}
}
