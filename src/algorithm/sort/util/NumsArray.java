package algorithm.sort.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class NumsArray {

	/**
	 * 从numsArray.txt文件中读取整形数组
	 * @return
	 * @throws Exception
	 */
	public static int[] getNumsArray() throws Exception{
		String filepath = "G:/eclipseJavaEE/MyTest/src/algorithm/sort/numsArray.txt";
		FileInputStream fis = new FileInputStream(filepath);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String numsString = br.readLine();
		br.close();
		isr.close();
		fis.close();
		String[] stringArray= numsString.split(",");
		int[] nums = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			nums[i] = Integer.parseInt(stringArray[i]);
		}
		return nums;
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] nums = getNumsArray();
		for (int i = 0; i < nums.length; i++) {
			System.out.print("["+i+"]	");
		}
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"	");
		}
	}
}
