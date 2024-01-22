class I
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		test();
		System.out.println(2);
	}
	public static void test()
	{
	System.out.println(3);
	Class.forName("");
	System.out.println(4);
	}
}
/*
I.java:12: error: unreported exception ClassNotFoundException; must be caught or declared to be thrown
        Class.forName("");
                     ^
1 error
*/