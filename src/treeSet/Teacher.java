/**
 * 自定义类要放入TreeSet中要实现Comparable接口;
 * 或者自定义一个comparator传入TreeSet中，见Teacher2
 */
package treeSet;

@SuppressWarnings("rawtypes")
public class Teacher implements Comparable
{
	/**
	 * 教师编号
	 */
	private int no;
	/**
	 * 教师姓名
	 */
	private String name;
	
	public Teacher(int no, String name)
	{
		this.no = no;
		this.name = name;
	}

	@Override
	public int compareTo(Object o)
	{
		Teacher teacher = (Teacher)o;
		int result = no < teacher.no ? -1 : (no == teacher.no ? 0 : 1); //升序
		if (result == 0)
		{
			result = name.compareTo(teacher.name);
		}
		return result;
	}

	@Override
	public String toString()
	{
		return "no: " + no + ", name: " + name;
	}
	
}
