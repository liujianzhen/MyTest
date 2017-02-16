package algorithm.sort;

import java.util.Date;

public class SortProxy implements Sort {

	private Sort algorithm;
	/**
	 * 执行算法前记录时间
	 */
	public Date beforeSort(){
		return new Date();
	}
	/**
	 * 执行算法后记录时间
	 */
	public Date afterSort(){
		return new Date();
	}
	public void sort() {
		Date start = beforeSort();
		algorithm.sort();
		Date end = afterSort();
		System.out.println(this.algorithm.getClass().getSimpleName()+"排序花费的时间："+ (end.getTime()-start.getTime())+"ms");
	}
	public SortProxy(Sort algorithm){
		this.algorithm = algorithm;
	}
}
