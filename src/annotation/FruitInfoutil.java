package annotation;

import java.lang.reflect.Field;

/**
 * 注释解释器
 * @author liujianzhen
 *
 */
public class FruitInfoutil {

	public static void printFruitInfo(Class<?> clazz){
		
		//获取类的所有成员变量
		Field[] fields = clazz.getDeclaredFields();
		String fruitName = "水果的名字：";
		String fruitColor = "水果的颜色：";
		String fruitProvider = "水果的供应商信息：";
		
		//遍历类的所有成员变量
		for (Field field : fields) {
			
			//判断该成员变量上是否有@FruitName注解
			if(field.isAnnotationPresent(FruitName.class)){
				//有则取该注解的信息
				fruitName += field.getAnnotation(FruitName.class).value();
			
			//判断该成员变量上是否有@FruitColor注解
			}else if(field.isAnnotationPresent(FruitColor.class)){
				fruitColor += field.getAnnotation(FruitColor.class).fruitColor();
			
			//判断该成员变量上是否有@FruitProvider注解
			}else if(field.isAnnotationPresent(FruitProvider.class)){
				String id = (-1)==field.getAnnotation(FruitProvider.class).id()?"":""+field.getAnnotation(FruitProvider.class).id();
				if("-1".equals(id))id = "";
				fruitProvider += "\n供应商编号："+id
						+"\n供应商名称："+field.getAnnotation(FruitProvider.class).name()
						+"\n供应商地址："+field.getAnnotation(FruitProvider.class).address();
			}
		}
		System.out.println(fruitName);
		System.out.println(fruitColor);
		System.out.println(fruitProvider);
	}
}
