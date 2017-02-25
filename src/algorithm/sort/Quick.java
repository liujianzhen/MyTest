/**
 * 目前最快的排序算法
 * 优点：极快，移动数据少
 * 缺点：不稳定
 */
package algorithm.sort;

public class Quick implements Sort
{
	private int[] nums;

	public Quick(int[] nums)
	{
		this.nums = nums;
	}

	public void sort()
	{
		_sort(0, nums.length-1);
	}

	/**
	 * 将一个数组分成两个数组，前一个数组全比base大，后一个数组全比base小
	 * 
	 * @param start
	 * @param end
	 */
	private void _sort(int start, int end)
	{
		if (start >= end)
		{
			return;
		}
		int basePosition = getBasePosition(start, end);
		_sort(start, basePosition - 1);
		_sort(basePosition + 1, end);
	}

	/**
	 * 找出base所应该在的位置，即其前面的数全部小于它，其后面的数全部大于它
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private int getBasePosition(int start, int end)
	{
		int base = nums[start];
		while (start < end)
		{
			// 从最后一个元素往前与base比较，直到找到第一个不小于base的元素
			while (start < end && nums[end] > base)
			{
				end--;
			}
			if (start < end)
			{
				// 将找到的那个元素放到第一个元素的位置
				nums[start] = nums[end];
				start++;
			}
			// 从第二个元素往后与base比较，直到找到第一个
			while (start < end && nums[start] < base)
			{
				start++;
			}
			if (start < end)
			{
				nums[end] = nums[start];
				end--;
			}
		}
		nums[start] = base;
		return start;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		int[] nums = {7,3,5,8,2,0,8,4,1};
		Quick sort = new Quick(nums);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}

}
