package algorithm.sort;
/**
 * ֱ�Ӳ�������
 * �������еļ�¼"��������",�� n ��Сʱ�������������
 * ��˳�������������򷽷������һ��ʹ��
 * ����Ĭ���������ʵ��
 * @author liujianzhen
 *
 */
public class InsertDirect extends AbstractInserDirect
{
	private int[] nums;
	
	public InsertDirect(){}
	
	public InsertDirect(int[] nums)
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

	protected void moveAndInsert(int initPos, int pos)
	{
		int num = nums[initPos];
		for (int i = initPos; i > pos; i--)
		{
			nums[i] = nums[i-1];
		}
		nums[pos] = num;
	}

	protected int findInsertPos(int initPos)
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

	public void setNums(int[] nums)
	{
		this.nums = nums;
	}

	public static void main(String[] args)
	{
		int[] nums = {7,9,3,5,2,0,3};
		InsertDirect sort = new InsertDirect(nums);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
}
