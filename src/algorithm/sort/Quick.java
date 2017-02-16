/**
 * Ŀǰ���������㷨
 * �ŵ㣺���죬�ƶ�������
 * ȱ�㣺���ȶ�
 */
package algorithm.sort;

import algorithm.sort.util.FormatPrint;
import algorithm.sort.util.NumsArray;

public class Quick implements Sort{

	private int[] nums;
	private int start;
	private int end;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort quick = new SortProxy(new Quick(0,nums.length-1,nums));
		quick.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}
	
	private int getBasePosition(int start,int end,int[] nums){
		int base = nums[start];
		while (start < end){
			//�����һ��Ԫ����ǰ��base�Ƚϣ�ֱ���ҵ���һ����С��base��Ԫ��
			while(start < end && nums[end] > base){
				end--;
			}
			if(start < end){
				//���ҵ����Ǹ�Ԫ�طŵ���һ��Ԫ�ص�λ��
				nums[start] = nums[end];
				start++;
			}
			while(start < end && nums[start] < base){
				start++;
			}
			if(start < end){
				nums[end] = nums[start];
				end--;
			}
		}
		nums[start] = base;
		return start;
	}
	
	public void sort(){
		_sort(start,end,nums);
	}
	
	private void _sort(int start,int end,int[] nums){
		if(start >= end){
			return;
		}
		int basePosition = getBasePosition(start,end,nums);
		_sort(start,basePosition-1,nums);
		_sort(basePosition+1,end,nums);
	}

	public Quick(int start, int end, int[] nums){
		this.start = start;
		this.end = end;
		this.nums = nums;
	}

}
