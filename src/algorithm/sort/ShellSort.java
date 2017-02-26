package algorithm.sort;
/**
 * ϣ������
 * ԭ��ϣ������ʵ�ʾ��Ƿ�������ѡȡĳ���������з��飬��ÿ��ʹ��ֱ�Ӳ�������
 * �𽥼�С����ֱ������Ϊ1��
 * ��Ϊֱ�Ӳ���������Ԫ�ػ�������������Ч���Ǻܸߵġ�
 * ��ϣ������ʼʱ�����ϴ󣬷���϶࣬ÿ��ļ�¼��Ŀ�٣��ʸ�����ֱ�Ӳ���Ͽ죬��������di����С���������𽥼��٣�
 * ������ļ�¼��Ŀ�����࣬�������Ѿ���di-1��Ϊ�����Ź���ʹ�ļ��Ͻӽ�������״̬�������µ�һ���������Ҳ�Ͽ졣
 * ������ѡȡ��
 * 1��ѡȡ������֮�䲻Ҫ�б�����ϵ
 * 2�����һ������ҪΪ 1
 * ϣ�������ʱ�临�Ӷ�ȡ����������ѡȡ�����õ���ϣ������{N/2, (N / 2)/2, ..., 1}ʱ�临�Ӷ�Ϊ��O(n^2)�� 
 * ����Hibbard����{1, 3, ..., 2^(k-1)}��ʱ�临�Ӷ�Ϊ��O(n^(2/3))��
 * �����ܵ���˵����ʱ�临�ӶȽ��� O(n^2)�� O(nlogn)֮��  
 * ר�����ᳫ�������κ��������ڿ�ʼʱ��������ϣ����������ʵ��ʹ����֤���������죬�ٸĳɿ��������������߼��������㷨.
 * @author liujianzhen
 *
 */
public class ShellSort implements Sort
{
	private int[] nums;
	
	/**
	 * ��������
	 * 
	 */
	private IncrementType type;
	
	public ShellSort(int[] nums)
	{
		this.nums = nums;
		this.type = IncrementType.SHELL;
	}
	
	/**
	 * 
	 * @param nums
	 * @param type �������� {@link algorithm.sort.ShellSort.IncreasementType}
	 */
	public ShellSort(int[] nums,IncrementType type)
	{
		this.nums = nums;
		this.type = type;
	}
	
	@Override
	public void sort()
	{
		InsertDirect2 insertDiect = new InsertDirect2(nums);
		int increment = nums.length;
		while(increment > 1)
		{
			//���ݲ�ͬ���������ͼ����Ӧ����һ������
			switch (type)
			{
			case SHELL:
				
				increment = increment/2;
				break;

			case HIBBARD:
				
				increment = increment - (increment%2 + 1);
				break;
				
			default:
				break;
			}
			insertDiect.setIncrement(increment);
			//��ÿһ�����ֱ�Ӳ�������
			for (int i = 0; i < increment; i++)
			{
				insertDiect.setStart(i);
				insertDiect.sort();
			}
		}
	}

	/**
	 * ϣ��������������
	 * <ul>
	 * <li>SHELL    ϣ������</li>
	 * <li>HIBBARD  Hibbard ����</li>
	 * </ul>
	 * @author liujianzhen
	 *
	 */
	public static enum IncrementType
	{SHELL,HIBBARD}
	
	public static void main(String[] args)
	{
		int[] nums = {3,9,7,1,4,6,2,0};
		Sort sort = new ShellSort(nums);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
	}
}
