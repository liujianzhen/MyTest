package treeSet;
/**
 * 通过自定义comparator传入TreeSet中，
 * 实现可以将自定义类添加到TreeSet中。
 */


import java.util.Comparator;

public class Teacher2
{
	/**
	 * 教师编号
	 */
	private int no;
	/**
	 * 教师姓名
	 */
	private String name;
	
	public Teacher2(int no, String name)
	{
		this.no = no;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return "no: " + no + ", name: " + name;
	}
	
	@SuppressWarnings("rawtypes")
	static class TeacherComparator implements Comparator
	{
		@Override
		public int compare(Object o1, Object o2)
		{
			Teacher2 t1 = (Teacher2)o1;
			Teacher2 t2 = (Teacher2)o2;
			int result = t1.no < t2.no ? -1 : (t1.no == t2.no ? 0 : 1);
			if (result == 0)
			{
				result = t1.name.compareTo(t2.name);
			}
			return result;
		}
	}
}
