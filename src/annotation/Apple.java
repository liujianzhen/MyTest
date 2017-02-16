package annotation;

import annotation.FruitColor.Color;
/**
 * 苹果类
 * @author liujianzhen
 *
 */
public class Apple {

	/**
	 * 苹果名字
	 */
	@FruitName("Apple")
	private String appleName;
	
	/**
	 * 苹果颜色
	 */
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	/**
	 * 苹果供应商
	 */
	@FruitProvider(id=1,name="红富士集团",address="陕西省西安市延安路89号红富士大厦")
	private String appleProvider;

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}
	
}
