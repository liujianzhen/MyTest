/**
 * ð������
 * �ŵ㣺�ȶ��Ƚϴ�����֪
 * ȱ�㣺����ÿ��ֻ�ƶ����ڵ���������
 */
package algorithm.sort;

import algorithm.sort.util.FormatPrint;
import algorithm.sort.util.NumsArray;

public class MaoPao implements Sort{

	private int[] nums;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort maopao = new SortProxy(new MaoPao(nums));
		maopao.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}

	public void sort() {
		for (int j = 0; j < nums.length-1; j++) {
			for (int i = nums.length-1; i > j; i--) {
				if(nums[i]<nums[i-1]){
					int tmp = nums[i-1];
					nums[i-1] = nums[i];
					nums[i] = tmp;
				}
			}
		}
	}

	public MaoPao(int[] nums){
		this.nums = nums;
	}
}
