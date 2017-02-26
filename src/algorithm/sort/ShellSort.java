package algorithm.sort;
/**
 * 希尔排序：
 * 原理：希尔排序实质就是分组排序，选取某个增量进行分组，对每组使用直接插入排序。
 * 逐渐减小增量直至增量为1。
 * 因为直接插入排序在元素基本有序的情况下效率是很高的。
 * 在希尔排序开始时增量较大，分组较多，每组的记录数目少，故各组内直接插入较快，后来增量di逐渐缩小，分组数逐渐减少，
 * 而各组的记录数目逐渐增多，但由于已经按di-1作为距离排过序，使文件较接近于有序状态，所以新的一趟排序过程也较快。
 * 增量的选取：
 * 1）选取的增量之间不要有倍数关系
 * 2）最后一个增量要为 1
 * 希尔排序的时间复杂度取决于增量的选取。常用的是希尔增量{N/2, (N / 2)/2, ..., 1}时间复杂度为（O(n^2)） 
 * 还有Hibbard增量{1, 3, ..., 2^(k-1)}，时间复杂度为（O(n^(2/3))）
 * 不过总的来说，其时间复杂度介于 O(n^2)与 O(nlogn)之间  
 * 专家们提倡，几乎任何排序工作在开始时都可以用希尔排序，若在实际使用中证明它不够快，再改成快速排序这样更高级的排序算法.
 * @author liujianzhen
 *
 */
public class ShellSort implements Sort
{
	private int[] nums;
	
	/**
	 * 增量类型
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
	 * @param type 增量类型 {@link algorithm.sort.ShellSort.IncreasementType}
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
			//根据不同的增量类型计算对应的下一个增量
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
			//对每一组进行直接插入排序
			for (int i = 0; i < increment; i++)
			{
				insertDiect.setStart(i);
				insertDiect.sort();
			}
		}
	}

	/**
	 * 希尔排序增量类型
	 * <ul>
	 * <li>SHELL    希尔增量</li>
	 * <li>HIBBARD  Hibbard 增量</li>
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
