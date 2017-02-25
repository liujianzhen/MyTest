package algorithm.sort.util;

import algorithm.sort.HeapSort;
import algorithm.sort.MaoPao;
import algorithm.sort.MaoPaoOptimization;
import algorithm.sort.Quick;
import algorithm.sort.SelectDirect;
import algorithm.sort.Sort;
import algorithm.sort.SortProxy;

public class Compare
{
	public static void main(String[] args) throws Exception
	{
		int[] nums = NumsArray.getNumsArray();
		int[] numsCopy = NumsArray.getNumsArray();
		Sort maopao = new SortProxy(new MaoPao(nums));
		Sort maopaooptimization = new SortProxy(new MaoPaoOptimization(nums));
		Sort quick = new SortProxy(new Quick(nums));
		Sort selectDirect = new SortProxy(new SelectDirect(nums));
		Sort heapSort = new SortProxy(new HeapSort(nums));
		maopao.sort();
		maopaooptimization.sort();
		quick.sort();
		selectDirect.sort();
		heapSort.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}
}
