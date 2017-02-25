package algorithm.sort;

public class InsertDiect implements Sort
{
	private int[] nums;
	
	public InsertDiect(int[] nums)
	{
		this.nums = nums;
	}

	@Override
	public void sort()
	{
		for (int i = 1; i < nums.length; i++)
		{
			int pos = findInsertPos(i);
			if (pos == i)
			{
				continue;
			}else
			{
				moveAndInsert(i,pos);
			}
		}
	}

	/**
	 * 将当前数插入到其在有序组中应该插入到的位置
	 * @param i
	 * @param pos
	 */
	private void moveAndInsert(int initPos, int pos)
	{
		int num = nums[initPos];
		for (int i = initPos; i > pos; i--)
		{
			nums[i] = nums[i-1];
		}
		nums[pos] = num;
	}

	/**
	 * 查找当前数应该插入有序组中的位置
	 * @param num
	 * @param initPos
	 * @return
	 */
	private int findInsertPos(int initPos)
	{
		for (int i = 0; i < initPos; i++)
		{
			if (nums[i] > nums[initPos])
			{
				return i;
			}
		}
		return initPos;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {7,9,3,5,2,0,3};
		InsertDiect sort = new InsertDiect(nums);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
