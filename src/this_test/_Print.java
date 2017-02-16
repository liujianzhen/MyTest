package this_test;

public class _Print
{
	private String className;
	
	public _Print(Foo foo){
		this.className = foo.getClass().getName();
	}
	
	public void printClassName(){
		System.out.println(this.className);
	}
}
