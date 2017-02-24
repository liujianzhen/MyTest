package filter;

import java.util.HashMap;
import java.util.Map;

public class Request
{
	/**
	 * 封装请求的信息
	 */
	private Map<String, Object> requestInfo = new HashMap<String, Object>();
	
	public Object getAttribute(String key)
	{
		return requestInfo.get(key);
	}
	
	public void setAttribute(String key,Object value)
	{
		requestInfo.put(key, value);
	}
}
