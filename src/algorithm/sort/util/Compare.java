package algorithm.sort.util;

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
		Sort quick = new SortProxy(new Quick(0, nums.length-1, nums));
		Sort selectDirect = new SortProxy(new SelectDirect(nums));
		maopao.sort();
		maopaooptimization.sort();
		quick.sort();
		selectDirect.sort();
		FormatPrint.formatPrint(numsCopy, nums);
	}
}
