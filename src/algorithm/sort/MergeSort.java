/**
 * 归并排序
 * 分治法的典型应用
 * 合并两个有序数列的方法：先比较两个数列的第一个数字，取出最小的那个，并删除数列中取出的数
 * 如何实现两个有序的数列：一直分解到只有一个数据的数列认为是有序数列
 * 先通过递归分解数列，再通过合并数列完成归并排序
 * 时间复杂度：O(nlogn)
 * 稳定排序
 */
package algorithm.sort;

import algorithm.sort.util.NumsArray;

public class MergeSort implements Sort
{
	private int left;

	private int right;

	private int[] nums;

	public MergeSort(int left, int right, int[] nums)
	{
		this.nums = nums;
		this.left = left;
		this.right = right;
	}

	@Override
	public void sort()
	{
		_sort(nums, left, right);
	}

	private void _sort(int[] nums, int left, int right)
	{
		if (left < right)
		{
			int mid = (left + right) / 2;
			_sort(nums, left, mid);
			_sort(nums, mid + 1, right);
			mergeArray(nums, left, mid, right);
		}
		return;
	}

	private void mergeArray(int[] nums, int left, int mid, int right)
	{
		int i,j, k;
		i = left;
		j = mid + 1;
		k = 0;
		int[] tmp = new int[right - left + 1];
		while (i <= mid && j <= right)
		{
			if (nums[i] < nums[j])
			{
				tmp[k++] = nums[i++];
			} else
			{
				tmp[k++] = nums[j++];
			}
		}
		
		while (i <= mid)
		{
			tmp[k++] = nums[i++];
		}
		
		while (j <= right)
		{
			tmp[k++] = nums[j++];
		}

		for (int l = 0; l < tmp.length; l++)
		{
			nums[left+l] = tmp[l];
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort mergeSort = new SortProxy(new MergeSort(0, nums.length-1, nums));
		mergeSort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+"    ");
		}
	}
}
