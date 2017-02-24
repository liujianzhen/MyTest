package filter;
/**
 * 回调机制中的回调接口
 * @author liujianzhen
 *
 */
public interface FilterChain
{
	/**
	 * 定义回调方法,filter 处理完后，将处理完的 Request 和 Response 传回给 FilterChain 使其再调用下一个 filter
	 */
	public void doFilter(Request req,Response res);
}
