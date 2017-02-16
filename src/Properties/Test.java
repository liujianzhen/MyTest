package Properties;

import java.io.FileInputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("G:/ifm workspace/Test/src/Properties/dbConfigure");
		prop.load(fis);
		System.out.println("数据库："+prop.getProperty("dbName"));
		System.out.println("用户名："+prop.getProperty("dbUserName"));
		System.out.println("密码："+prop.getProperty("dbPassword"));
		System.out.println("测试没有的属性："+prop.getProperty("test"));
	}
}
