package callbackpattern.mockfilter;

public class MyFilter1 implements Filter
{

	@Override
	public String doFilter(String msg, FilterChain filterChain)
	{
		System.out.println("Before myfilter1");
		msg = "aaa1" + msg;
		msg = filterChain.doFilter(msg);
		msg = msg + "1aaa";
		System.out.println("After myfilter1");
		System.out.println(msg);
		return msg;
	}

}
