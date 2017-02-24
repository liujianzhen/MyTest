package filter;

public class ApplicationFilterChain implements FilterChain
{
	//该过滤器链上的过滤器集合
	private Filter[] filters;
	
	//指向下一个过滤器的位置的指针
	private int position = 0;
	
	//请求的 servlet
	private Servlet servlet;
	
	public void setServlet(Servlet servlet)
	{
		this.servlet = servlet;
	}

	public ApplicationFilterChain()
	{
		this.filters = new Filter[0];
	}
	
	public void addFilter(Filter filter)
	{
		if (filters.length == 0)
		{
			filters = new Filter[1];
			filters[1] = filter;
		}
		Filter[] newFilters = new Filter[filters.length + 1];
		System.arraycopy(filters, 0, newFilters, 0, filters.length);
		newFilters[filters.length] = filter;
		filters = newFilters;
	}
	
	@Override
	public void doFilter(Request req, Response res)
	{
		//所有的过滤器都执行完了则执行 servlet
		if(position > filters.length)
		{
			servlet.service(req, res);
		}
		//否则执行下一个过滤器
		filters[position++].doFilter(req, res,this);
	}
}
