/**
 * Ŀǰ���������㷨
 * �ŵ㣺���죬�ƶ�������
 * ȱ�㣺���ȶ�
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
	 * ��һ������ֳ��������飬ǰһ������ȫ��base�󣬺�һ������ȫ��baseС
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
	 * �ҳ�base��Ӧ���ڵ�λ�ã�����ǰ�����ȫ��С��������������ȫ��������
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
			// �����һ��Ԫ����ǰ��base�Ƚϣ�ֱ���ҵ���һ����С��base��Ԫ��
			while (start < end && nums[end] > base)
			{
				end--;
			}
			if (start < end)
			{
				// ���ҵ����Ǹ�Ԫ�طŵ���һ��Ԫ�ص�λ��
				nums[start] = nums[end];
				start++;
			}
			// �ӵڶ���Ԫ��������base�Ƚϣ�ֱ���ҵ���һ��
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
