class G
{
	public static void test()
	{
		System.out.println("test()");
	}
	protected final int  test()
	{
		System.out.println("test()");
		System.out.println("test()");
		System.out.println("test()");
		System.out.println("test()");
		System.out.println("test()");
		return 20;
	}
}
/*
:\Aug-6\app29\src>javac -d ../classes G.java
G.java:7: error: method test() is already defined in class G
        protected final int  test()//even final method can be overloaded
                             ^
1 error
*/
