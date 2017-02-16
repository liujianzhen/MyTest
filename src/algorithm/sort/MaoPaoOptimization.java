/**
 * ����ð�ݵĸĽ�
 * �����һ�ֱȽ�֮��û��λ�ý����ͱ�ʾ�Ѿ��ź�����
 * ��ֹͣѭ��
 * @author liujianzhen
 *
 */
package algorithm.sort;

import algorithm.sort.util.FormatPrint;
import algorithm.sort.util.NumsArray;

public class MaoPaoOptimization implements Sort{

	private int[] nums;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort maopao = new SortProxy(new MaoPaoOptimization(nums));
		maopao.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}

	public void sort() {
		for (int j = 0; j < nums.length-1; j++) {
			boolean flag = true;
			for (int i = nums.length-1; i > j; i--) {
				if(nums[i]<nums[i-1]){
					int tmp = nums[i-1];
					nums[i-1] = nums[i];
					nums[i] = tmp;
					flag = false;
				}
				
			}
			if(flag == true){
				break;
			}
		}
	}

	public MaoPaoOptimization(int[] nums){
		this.nums = nums;
	}
}
