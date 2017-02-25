/**
 * ѡ������
 * �ŵ㣺�ȶ����Ƚϴ�����ð������һ�����������ƶ�������ð����
 * ȱ�㣺����ٶȻ��ǱȽ���
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
		//����ѡ����С�ġ��ڶ�С��
		for (int i = 0; i < nums.length; i++) {
			int tempIndex = i;
			//�����ÿһ��Ԫ�رȽϣ��ҳ���С��Ԫ�����ڵ�λ��
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[tempIndex]){
					tempIndex = j;
				}
			}
			//����С��Ԫ�غ�Ŀǰ�Ƚϵ�Ԫ�ؽ���λ��
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
