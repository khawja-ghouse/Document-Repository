class B
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		test();//propagated exc object -> this will be propaget to the caller of the main method that is javac
		System.out.println(2);
	}

public static void test()
{
	System.out.println(3);
	int i = 10 / 0;
	System.out.println(4);
}
}
/*
1
3
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at B.test(B.java:13)
        at B.main(B.java:6)
*/