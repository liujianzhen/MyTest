package algorithm.sort;

/**
 * ԭ���Ƚ������ɴ󶥶ѣ��ٽ��������һ��Ҷ�ӽڵ㽻���������Ѿ������˵�Ҷ�ӽڵ���(��ʱ�Ѿͱ��ֳ�����������������������)
 * ��ʱ��Ϊ�������ˣ��ѿ��ܲ��ٷ��ϴ󶥶ѵĹ�����˽�����������ͬ���ķ����ٴα�ɴ󶥶ѡ�
 * ��������ʵҲ��һ��ѡ��������һ������ѡ������
 * ֻ����ֱ��ѡ�������У�Ϊ�˴�R[1...n]��ѡ������¼����Ƚ�n-1�Σ�Ȼ���R[1...n-2]��ѡ������¼��Ƚ�n-2�Ρ�
 * ��ʵ����n-2�αȽ����кܶ��Ѿ���ǰ���n-1�αȽ����Ѿ�������
 * ������ѡ������ǡ���������ε��ص㱣���˲���ǰ��ıȽϽ������˿��Լ��ٱȽϴ�����
 * ������ʱ�临�Ӷ�ΪO(nlogn)
 * Ϊ���ȶ�����
 * @author liujianzhen
 *
 */
public class HeapSort implements Sort
{
	private int nums[];
	/*
	 * �����������һ��Ԫ�ص�λ��
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
		//ֻҪ�������л���һ�����ϵ�Ԫ�أ���Ҫ�����ɴ󶥶ѣ�Ȼ����н���
		while(pos > 0)
		{
			buildMaxHeap();
			//�������������е����һ��Ԫ�ؽ���
			swap(0,pos);
			//������������������������
			--pos;
		}
	}

	/**
	 * �������������ɴ󶥶�
	 * ����Ե��Ǹ��ڵ������������������ģ�
	 * Ҫ�����Ľڵ�ֵһ��һ��ð�����ڵ�
	 */
	private void buildMaxHeap()
	{
		//���������е�����һ����Ҷ�ӽڵ㿪ʼ���Ƚ��������Һ��ӵĴ�С��
		int startIndex = (pos-1)/2;
		for (int i = startIndex; i >= 0; i--)
		{
			adjustHeap(i);
		}
	}

	/**
	 * �����������˵��ӽڵ����ڵ�����
	 * ����Ե��Ǹ��ڵ������������󶥶ѣ����߸��ڵ�����ֻ��һ�����ӣ��������Һ��Ӷ��У��ֻ��߸��ڵ�����ʲô��û��
	 * ����ø��ڵ���亢�ӽڵ��ֵ���󣬾Ͳ��õ�����
	 * �����Ҫ���ø��ڵ�һ��һ�����³�ֱ������������󶥶ѵĹ���
	 * @param childRoot �����ĸ��ڵ�����
	 */
	private void adjustHeap(int childRoot)
	{
		int l_index = 2*childRoot+1;
		int r_index = 2*childRoot+2;
		if (r_index > pos)
		{
			if (l_index > pos)//���Һ��Ӷ�û�У��Ͳ��õ�����
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
	 * ��������Ԫ�ص�λ��
	 * @param i Ԫ��λ��
	 * @param j Ԫ��λ��
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
