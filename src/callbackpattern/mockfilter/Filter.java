package callbackpattern.mockfilter;

public interface Filter
{
	public String doFilter(String msg,FilterChain filterChain);
}
