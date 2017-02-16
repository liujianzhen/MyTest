/**
 * �鲢����
 * ���η��ĵ���Ӧ��
 * �ϲ������������еķ������ȱȽ��������еĵ�һ�����֣�ȡ����С���Ǹ�����ɾ��������ȡ������
 * ���ʵ��������������У�һֱ�ֽ⵽ֻ��һ�����ݵ�������Ϊ����������
 * ��ͨ���ݹ�ֽ����У���ͨ���ϲ�������ɹ鲢����
 * ʱ�临�Ӷȣ�O(nlogn)
 * �ȶ�����
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
