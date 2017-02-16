package resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 测试 ResourceBundle 类实现国际化
 * 注意，使用这个类时，properties文件必须放在 src 目录下，或我们自己指定的 classpath 下 
 * @author liujianzhen
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		// 指定特定的语言、国家为中文、中国
		System.out.println("指定特定的语言、国家为中文、中国");
		Locale locale = new Locale("zh", "CN");
		ResourceBundle rb = ResourceBundle.getBundle("myres", locale);
		System.out.println(rb.getString("aaa"));

		// 使用默认的语言、国家
		System.out.println("使用默认的语言、国家");
		ResourceBundle rb1 = ResourceBundle.getBundle("myres", Locale.getDefault());
		System.out.println(rb1.getString("aaa"));

		// 指定特定的语言、国家为英语、美国
		System.out.println("指定特定的语言、国家为英语、美国");
		Locale locale2 = new Locale("en", "US");
		ResourceBundle rb2 = ResourceBundle.getBundle("myres", locale2);
		System.out.println(rb2.getString("aaa"));
	}
}
