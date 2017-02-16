package algorithm.sort.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 改变n可以调整生成的随机整形数组的长度
 * 运行以生成数组，并输出到numsArray.txt文件中
 * @author liujianzhen
 *
 */
public class NumsArrayCreator {

	public static void main(String[] args) throws Exception {

		int n = 5000;//整形数组的长度
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
