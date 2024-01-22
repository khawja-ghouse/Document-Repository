class G
{
	static int x;
	public static void test()
	{
		System.out.println("test:"+x);		
		System.out.println("test:"+G.x);		
	}
	static
	{
		System.out.println("from G class");
		System.out.println("G-SIB:"+x);
	}
}
class H
{
	static
	{
		System.out.println("H-SIB:");
	}
	public static void main(String[] args) 
	{
		//System.out.println("from main");
		System.out.println("main"+ G.x);
		G.test();
	}
}
