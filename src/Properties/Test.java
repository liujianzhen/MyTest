package Properties;

import java.io.FileInputStream;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("G:/ifm workspace/Test/src/Properties/dbConfigure");
		prop.load(fis);
		System.out.println("���ݿ⣺"+prop.getProperty("dbName"));
		System.out.println("�û�����"+prop.getProperty("dbUserName"));
		System.out.println("���룺"+prop.getProperty("dbPassword"));
		System.out.println("����û�е����ԣ�"+prop.getProperty("test"));
	}
}
