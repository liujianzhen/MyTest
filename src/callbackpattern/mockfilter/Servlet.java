package callbackpattern.mockfilter;

public class Servlet
{
	public String service(String msg)
	{
		System.out.println("Servlet service getMsg");
		System.out.println(msg);
		msg = msg + "Servlet";
		System.out.println("After Servlet Service");
		System.out.println(msg);
		return msg;
	}
}
