package algorithm.sort.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FormatPrint {

	public static void formatPrint(int numssortedBefore[],int numsHassorted[]) throws Exception{
		
		result2File(numsHassorted);
		System.out.println("结果已写入文件");
	}
	
	public static void result2File(int[] nums) throws IOException{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(String.valueOf(nums[i])+",");
		}
		String filepath = "G:/eclipseJavaEE/MyTest/src/algorithm/sort/sortedNumsArray.txt";
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
