class A
{
	A() throws ClassNotFoundException
	{
	}
}

class Y extends A
{
	Y()
	{
		try
		{
			super();
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("ex");
		}
	}
	public static void main(String[] args)
	{
		System.out.println("done");
	}
}
/*
Y.java:14: error: call to super must be first statement in constructor
                        super();
                             ^
1 error
*/