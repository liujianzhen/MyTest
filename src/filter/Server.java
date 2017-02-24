package filter;

/**
 * 此类的 getMsg() 方法就是和 CSCallback 耦合了
 * 
 * @author liujianzhen
 *
 */
public class Server
{
	private Request req;

	private Response res;

	private FilterChain filterChain;

	private Servlet servlet = new LoginServlet();

	public void getMsg(CSCallback caller, String url)
	{
		System.out.println("服务器：接受到客户端的请求 " + url);
		resolveUrl(url);
		if (filterChain == null)
		{
			servlet.service(req, res);
		} else
		{
			filterChain.doFilter(req, res);
		}
		System.out.println("服务器：数据处理成功，返回成功状态 200");
		String status = "200";
		caller.process(status);
	}

	// 解析 url 并封装成 Request
	private void resolveUrl(String url)
	{
		String protocol = url.substring(0, url.indexOf(":"));
		String host = url.substring(url.indexOf("//") + 2, url.indexOf("/", url.indexOf("//") + 2));
		String action = url.substring(url.indexOf("/", url.indexOf("//") + 2) + 1, url.indexOf("?"));
		req.setAttribute("protocol", protocol);
		req.setAttribute("host", host);
		req.setAttribute("action", action);
		if (url.contains("?"))
		{
			String parameter = url.substring(url.indexOf("?") + 1);
			if (!url.contains("&"))
			{
				String paramKey = parameter.substring(0, parameter.indexOf("="));
				String prramValue = parameter.substring(parameter.indexOf("=") + 1);
				req.setAttribute(paramKey, prramValue);
			} else
			{
				String[] keyValues = url.split("&");
				for (int i = 0; i < keyValues.length; i++)
				{
					String[] keyValue = keyValues[i].split("=");
					req.setAttribute(keyValue[0], keyValue[1]);
				}
			}
		}
	}

	public void setFilterChain(FilterChain filterChain)
	{
		this.filterChain = filterChain;
	}
}
