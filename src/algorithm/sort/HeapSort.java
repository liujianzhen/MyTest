package algorithm.sort;

import algorithm.sort.util.NumsArray;

/**
 * 原理：先将数组变成大根堆，再将根和最后一个叶子节点交换，除了已经交换了的叶子节点外，再将其他元素再次变成大根堆
 * 堆排序其实也是一种选择排序，是一种树形选择排序。
 * 只不过直接选择排序中，为了从R[1...n]中选择最大记录，需比较n-1次，然后从R[1...n-2]中选择最大记录需比较n-2次。
 * 事实上这n-2次比较中有很多已经在前面的n-1次比较中已经做过，
 * 而树形选择排序恰好利用树形的特点保存了部分前面的比较结果，因此可以减少比较次数。
 * 最坏情况下时间复杂度为nlogn
 * 为不稳定排序
 * @author liujianzhen
 *
 */
public class HeapSort implements Sort
{
	private int nums[];
	@Override
	public void sort()
	{
		//创建大根堆
		buildMaxHeapify();
	}
	
	/**
	 * 创建大根堆
	 */
	private void buildMaxHeapify()
	{
		//只有有子节点的节点才需要创建大根堆从最后一个非叶子节点开始
		int startIndex = (nums.length-1) >> 2;
		for (int i = startIndex; i >= 0; i--)
		{
			maxHeapify(nums,nums.length,i);
		}
	}

	/**
	 * 创建
	 * @param nums
	 * @param len 需要创建大根堆的大小
	 * @param index
	 */
	private void maxHeapify(int[] nums,int len,int index)
	{
		
	}
}
