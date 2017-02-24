package filter;
/**
 * 这个接口和某个特定的被调用方法是参数耦合的。
 * 所有想要那个特定的方法（含有此接口作为参数）执行过程中会进行回调的类都要实现此接口，定义回调所要做的事情。
 * @author liujianzhen
 *
 */
public interface CSCallback
{
	/**
	 * 这里的回调方法明确了调用类想要从被调用对象当中获取的信息
	 * @param status
	 */
	public void process(String status);
}
