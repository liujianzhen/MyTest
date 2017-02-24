package callbackpattern.mockfilter;

public class FilterChainImpl implements FilterChain
{
	private Filter[] filters;
	private int position = 0;
	private Servlet servlet;
	
	public void addFilter(Filter filter)
	{
		if (filters == null)
		{
			filters = new Filter[1];
			filters[0] = filter;
		}else
		{
			Filter[] newFilters = new Filter[filters.length + 1];
			System.arraycopy(filters, 0, newFilters, 0, filters.length);
			newFilters[filters.length] = filter;
			filters = newFilters;
		}
	}
	
	public void setServlet(Servlet servlet)
	{
		this.servlet = servlet;
	}
	
	@Override
	public String doFilter(String msg)
	{
		if (position == filters.length)
		{
			return servlet.service(msg);
		}
		return filters[position++].doFilter(msg, this);
	}

}
