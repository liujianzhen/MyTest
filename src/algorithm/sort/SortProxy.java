package algorithm.sort;

import java.util.Date;

public class SortProxy implements Sort {

	private Sort algorithm;
	/**
	 * ִ���㷨ǰ��¼ʱ��
	 */
	public Date beforeSort(){
		return new Date();
	}
	/**
	 * ִ���㷨���¼ʱ��
	 */
	public Date afterSort(){
		return new Date();
	}
	public void sort() {
		Date start = beforeSort();
		algorithm.sort();
		Date end = afterSort();
		System.out.println(this.algorithm.getClass().getSimpleName()+"���򻨷ѵ�ʱ�䣺"+ (end.getTime()-start.getTime())+"ms");
	}
	public SortProxy(Sort algorithm){
		this.algorithm = algorithm;
	}
}
