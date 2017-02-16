package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ˮ����Ӧ��ע��
 * @author liujianzhen
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

	/**
	 * ��Ӧ�̱��
	 * @return
	 */
	int id() default -1;
	
	/**
	 * ��Ӧ������
	 */
	String name() default "";
	
	/**
	 * ��Ӧ�̵�ַ
	 */
	String address() default "";
}
