package algorithm.sort;
/**
 * 直接插入排序的更灵活的实现
 * 可以传入一个数组，然后设置要进行排序的起始位置，元素间隔
 * 如数组 {4,1,7,1,5,1,9,1,0}
 * 现在只想对下标为 0,2,4,6,8 的元素进行排序，就可以设置
 * start = 0;
 * increment = 2
 * @author liujianzhen
 *
 */
public class InsertDirect2 extends AbstractInserDirect
{
	private int[] nums;
	
	private int increment;
	
	private int start;
	
	public InsertDirect2(){}
	
	public InsertDirect2(int[] nums)
	{
		this.nums = nums;
	}

	@Override
	public void sort()
	{
		for (int i = start+increment; i < nums.length; i += increment)
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

	protected void moveAndInsert(int initPos, int pos)
	{
		int num = nums[initPos];
		for (int i = initPos; i > pos; i -= increment)
		{
			nums[i] = nums[i-increment];
		}
		nums[pos] = num;
	}

	protected int findInsertPos(int initPos)
	{
		for (int i = start; i < initPos; i += increment)
		{
			if (nums[i] > nums[initPos])
			{
				return i;
			}
		}
		return initPos;
	}

	public void setNums(int[] nums)
	{
		this.nums = nums;
	}
	
	public void setIncrement(int increment)
	{
		this.increment = increment;
	}
	
	public void setStart(int start)
	{
		this.start = start;
	}

	public static void main(String[] args)
	{
		int[] nums = {4,1,3,1,2,1,5};
		InsertDirect2 sort = new InsertDirect2(nums);
		sort.setStart(0);
		sort.setIncrement(2);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
