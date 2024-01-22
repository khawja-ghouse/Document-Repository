class K
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		test();
		System.out.println(2);
	}
	public static void test() throws ClassNotFoundException
	{
	System.out.println(3);
	Class.forName("");
	System.out.println(4);
	}
}
/*
K.java:6: error: unreported exception ClassNotFoundException; must be caught or declared to be thrown
                test();
                    ^
1 error
*/