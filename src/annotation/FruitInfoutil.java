package annotation;

import java.lang.reflect.Field;

/**
 * ע�ͽ�����
 * @author liujianzhen
 *
 */
public class FruitInfoutil {

	public static void printFruitInfo(Class<?> clazz){
		
		//��ȡ������г�Ա����
		Field[] fields = clazz.getDeclaredFields();
		String fruitName = "ˮ�������֣�";
		String fruitColor = "ˮ������ɫ��";
		String fruitProvider = "ˮ���Ĺ�Ӧ����Ϣ��";
		
		//����������г�Ա����
		for (Field field : fields) {
			
			//�жϸó�Ա�������Ƿ���@FruitNameע��
			if(field.isAnnotationPresent(FruitName.class)){
				//����ȡ��ע�����Ϣ
				fruitName += field.getAnnotation(FruitName.class).value();
			
			//�жϸó�Ա�������Ƿ���@FruitColorע��
			}else if(field.isAnnotationPresent(FruitColor.class)){
				fruitColor += field.getAnnotation(FruitColor.class).fruitColor();
			
			//�жϸó�Ա�������Ƿ���@FruitProviderע��
			}else if(field.isAnnotationPresent(FruitProvider.class)){
				String id = (-1)==field.getAnnotation(FruitProvider.class).id()?"":""+field.getAnnotation(FruitProvider.class).id();
				if("-1".equals(id))id = "";
				fruitProvider += "\n��Ӧ�̱�ţ�"+id
						+"\n��Ӧ�����ƣ�"+field.getAnnotation(FruitProvider.class).name()
						+"\n��Ӧ�̵�ַ��"+field.getAnnotation(FruitProvider.class).address();
			}
		}
		System.out.println(fruitName);
		System.out.println(fruitColor);
		System.out.println(fruitProvider);
	}
}
