package callbackpattern.mockfilter;

public class MyFilter2 implements Filter
{

	@Override
	public String doFilter(String msg, FilterChain filterChain)
	{
		System.out.println("Before myfilter2");
		msg = "bbb1" + msg;
		msg = filterChain.doFilter(msg);
		msg = msg + "1bbb";
		System.out.println("After myfilter2");
		System.out.println(msg);
		return msg;
	}

}
