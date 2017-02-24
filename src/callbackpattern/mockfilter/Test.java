package callbackpattern.mockfilter;

public class Test
{
	public static void main(String[] args)
	{
		Servlet servlet = new Servlet();
		Filter filter1 = new MyFilter1();
		Filter filter2 = new MyFilter2();
		FilterChainImpl filterChain = new FilterChainImpl();
		filterChain.setServlet(servlet);
		filterChain.addFilter(filter1);
		filterChain.addFilter(filter2);
		String msg = "hello";
		filterChain.doFilter(msg);
	}
}
