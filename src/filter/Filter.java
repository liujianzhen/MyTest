package filter;

public interface Filter
{
	public void doFilter(Request req,Response res,FilterChain filterChain);
}
