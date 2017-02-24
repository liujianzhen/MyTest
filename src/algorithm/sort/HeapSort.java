package algorithm.sort;

import algorithm.sort.util.NumsArray;

/**
 * ԭ���Ƚ������ɴ���ѣ��ٽ��������һ��Ҷ�ӽڵ㽻���������Ѿ������˵�Ҷ�ӽڵ��⣬�ٽ�����Ԫ���ٴα�ɴ����
 * ��������ʵҲ��һ��ѡ��������һ������ѡ������
 * ֻ����ֱ��ѡ�������У�Ϊ�˴�R[1...n]��ѡ������¼����Ƚ�n-1�Σ�Ȼ���R[1...n-2]��ѡ������¼��Ƚ�n-2�Ρ�
 * ��ʵ����n-2�αȽ����кܶ��Ѿ���ǰ���n-1�αȽ����Ѿ�������
 * ������ѡ������ǡ���������ε��ص㱣���˲���ǰ��ıȽϽ������˿��Լ��ٱȽϴ�����
 * ������ʱ�临�Ӷ�Ϊnlogn
 * Ϊ���ȶ�����
 * @author liujianzhen
 *
 */
public class HeapSort implements Sort
{
	private int nums[];
	@Override
	public void sort()
	{
		//���������
		buildMaxHeapify();
	}
	
	/**
	 * ���������
	 */
	private void buildMaxHeapify()
	{
		//ֻ�����ӽڵ�Ľڵ����Ҫ��������Ѵ����һ����Ҷ�ӽڵ㿪ʼ
		int startIndex = (nums.length-1) >> 2;
		for (int i = startIndex; i >= 0; i--)
		{
			maxHeapify(nums,nums.length,i);
		}
	}

	/**
	 * ����
	 * @param nums
	 * @param len ��Ҫ��������ѵĴ�С
	 * @param index
	 */
	private void maxHeapify(int[] nums,int len,int index)
	{
		
	}
}
