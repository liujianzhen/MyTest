package filter;

public class LoginServlet implements Servlet
{
	@Override
	public void service(Request req, Response res)
	{
		String userName = (String)req.getAttribute("userName");
		String password = (String)req.getAttribute("password");
		//模拟数据库中只有 root 用户，且密码为 root
		if (userName != "root")
		{
		}
	}
}
