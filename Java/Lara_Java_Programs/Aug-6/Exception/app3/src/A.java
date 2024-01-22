class A 
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		int i = 10 / 0;
		System.out.println(2);
	}
}
/*
1
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at A.main(A.java:6)
	
		
	-> main method is removed forcefully from the stack memory due to exception int line 6
	->this is happening bec this exception is unchecked (the exception is not handled with try and catch block)
	->

*/