package algorithm.sort;

import java.util.ArrayList;

public class Test
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("2");
		list.add("1");
		Object[] array = list.toArray();
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		String[] array1 = list.toArray(new String[0]);
		for (int i = 0; i < array1.length; i++)
		{
			System.out.println(array1[i]);
		}
	}
}
