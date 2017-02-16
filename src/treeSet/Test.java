package treeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test
{
	public static void main(String[] args)
	{
		Set<Integer> ints= new TreeSet<Integer>();
		ints.add(9);
		ints.add(3);
		ints.add(7);
		ints.add(7);
		Iterator<Integer> it1 = ints.iterator();
		while (it1.hasNext())
		{
			System.out.println(it1.next());
		}
		System.out.println("自定义类放入TreeSet中排序：");
		Teacher t1 = new Teacher(0, "Lily");
		Teacher t2 = new Teacher(1, "Amy");
		Teacher t3 = new Teacher(1, "Bob");
		Set<Teacher> teachers = new TreeSet<Teacher>();
		teachers.add(t2);
		teachers.add(t3);
		teachers.add(t1);
		Iterator<Teacher> it= teachers.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("Teacher2 Test");
		Teacher2 t4 = new Teacher2(0, "Lily");
		Teacher2 t5 = new Teacher2(1, "Amy");
		Teacher2 t6 = new Teacher2(1, "Bob");
		Set<Teacher2> teacher2s= new TreeSet<>(new Teacher2.TeacherComparator());
		teacher2s.add(t5);
		teacher2s.add(t6);
		teacher2s.add(t4);
		Iterator<Teacher2> it2 = teacher2s.iterator();
		while (it2.hasNext())
		{
			System.out.println(it2.next());
		}
	}
}
