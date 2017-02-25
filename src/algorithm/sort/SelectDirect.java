/**
 * 选择排序
 * 优点：稳定，比较次数与冒泡排序一样，但数据移动次数比冒泡少
 * 缺点：相对速度还是比较慢
 */
package algorithm.sort;

import algorithm.sort.util.FormatPrint;
import algorithm.sort.util.NumsArray;

public class SelectDirect implements Sort{

	private int[] nums;
	
	public SelectDirect(int[] nums) {
		this.nums = nums;
	}

	public void sort() {
		//依次选出最小的、第二小的
		for (int i = 0; i < nums.length; i++) {
			int tempIndex = i;
			//与后面每一个元素比较，找出最小的元素所在的位置
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[tempIndex]){
					tempIndex = j;
				}
			}
			//将最小的元素和目前比较的元素交换位置
			int temp = nums[i];
			nums[i] = nums[tempIndex];
			nums[tempIndex] = temp;
		}
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort selectDirect = new SortProxy(new SelectDirect(nums));
		selectDirect.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}
}
