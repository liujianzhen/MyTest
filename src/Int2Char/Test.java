package Int2Char;

public class Test {

	public static void main(String[] args) {
		int a = 73;
		int c = 1;
		char b = (char)a;
		char d = (char)c;
		int e = (int)b;
		System.out.println("整形与字符的相互强制类型转换是根据字符的ASCII值进行相互转换的");
		System.out.println("-------------------d--------------------开始");
		System.out.println(d);
		System.out.println("-------------------d--------------------结束");
		System.out.println("-------------------b--------------------开始");
		System.out.println(b);
		System.out.println("-------------------b--------------------结束");
		System.out.println("-------------------a--------------------开始");
		System.out.println(a);
		System.out.println("-------------------a--------------------结束");
		System.out.println("-------------------e--------------------开始");
		System.out.println(e);
		System.out.println("-------------------e--------------------结束");
	}
}
