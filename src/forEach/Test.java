/**
 * forEach + lambda 实现遍历
 * lambda表达式：x -> x * x;
 * x 表示输入参数
 * x * x 表示匿名函数的语句或语句块
 */
package forEach;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		List<Integer> list= new ArrayList<Integer>();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		
		//方式 1
		System.out.println("方式 1 ：");
		list.forEach(item -> System.out.println(item));
		//方式 2
		System.out.println("方式 2 ：");
		list.forEach(System.out::println);
		//执行语句块
		System.out.println("执行语句块 ：");
		list.forEach(item -> {
			item ++;
			System.out.println(item);
		});
		//进行过滤
		System.out.println("进行过滤 ：");
		list.stream().filter(item -> item == 0|item == 1).forEach(System.out::println);
	}
}
