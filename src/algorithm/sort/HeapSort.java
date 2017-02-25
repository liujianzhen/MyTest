package algorithm.sort;

/**
 * 原理：先将数组变成大顶堆，再将顶和最后一个叶子节点交换，除了已经交换了的叶子节点外(这时堆就被分成了有序区和无序区两部分)
 * 此时因为顶被换了，堆可能不再符合大顶堆的规则，因此将无序区依照同样的方法再次变成大顶堆。
 * 堆排序其实也是一种选择排序，是一种树形选择排序。
 * 只不过直接选择排序中，为了从R[1...n]中选择最大记录，需比较n-1次，然后从R[1...n-2]中选择最大记录需比较n-2次。
 * 事实上这n-2次比较中有很多已经在前面的n-1次比较中已经做过，
 * 而树形选择排序恰好利用树形的特点保存了部分前面的比较结果，因此可以减少比较次数。
 * 最坏情况下时间复杂度为O(nlogn)
 * 为不稳定排序
 * @author liujianzhen
 *
 */
public class HeapSort implements Sort
{
	private int nums[];
	/*
	 * 无序区的最后一个元素的位置
	 */
	private int pos;

	public HeapSort(int[] nums)
	{
		this.nums = nums;
		this.pos = nums.length-1;
	}

	@Override
	public void sort()
	{
		//只要无序区中还有一个以上的元素，就要将其变成大顶堆，然后进行交换
		while(pos > 0)
		{
			buildMaxHeap();
			//将大顶与无序区中的最后一个元素交换
			swap(0,pos);
			//有序区在扩大，无序区在缩减
			--pos;
		}
	}

	/**
	 * 将无序区创建成大顶堆
	 * 其面对的是根节点下面的子树都是无序的，
	 * 要将最大的节点值一点一点冒到根节点
	 */
	private void buildMaxHeap()
	{
		//从无序区中倒数第一个非叶子节点开始，比较其与左右孩子的大小。
		int startIndex = (pos-1)/2;
		for (int i = startIndex; i >= 0; i--)
		{
			adjustHeap(i);
		}
	}

	/**
	 * 调整被交换了的子节点所在的子树
	 * 其面对的是根节点下面是两个大顶堆，或者根节点下面只有一个左孩子，或者左右孩子都有，又或者根节点下面什么都没有
	 * 如果该根节点比其孩子节点的值都大，就不用调整，
	 * 否则就要将该根节点一点一点往下沉直到该子树满足大顶堆的规则
	 * @param childRoot 子树的根节点索引
	 */
	private void adjustHeap(int childRoot)
	{
		int l_index = 2*childRoot+1;
		int r_index = 2*childRoot+2;
		if (r_index > pos)
		{
			if (l_index > pos)//左右孩子都没有，就不用调整了
			{
				return;
			}
			if (nums[l_index] > nums[childRoot])
			{
				swap(l_index, childRoot);
				adjustHeap(l_index);
			}
		}else
		{
			if (nums[l_index] > nums[childRoot])
			{
				if (nums[r_index] > nums[l_index])
				{
					swap(r_index, childRoot);
					adjustHeap(r_index);
				}else
				{
					swap(l_index, childRoot);
					adjustHeap(l_index);
				}
			}else
			{
				if (nums[r_index] > nums[childRoot])
				{
					swap(r_index, childRoot);
					adjustHeap(r_index);
				}
			}
		}
	}

	/**
	 * 交换两个元素的位置
	 * @param i 元素位置
	 * @param j 元素位置
	 */
	private void swap(int i, int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {8,3,33,5,1,9,22,0,2,4,10,7,6};
		Sort sort = new HeapSort(nums);
		sort.sort();
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
	}
}
