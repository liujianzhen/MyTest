package algorithm.sort;
/**
 * ֱ�Ӳ�������ĸ�����ʵ��
 * ���Դ���һ�����飬Ȼ������Ҫ�����������ʼλ�ã�Ԫ�ؼ��
 * ������ {4,1,7,1,5,1,9,1,0}
 * ����ֻ����±�Ϊ 0,2,4,6,8 ��Ԫ�ؽ������򣬾Ϳ�������
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
