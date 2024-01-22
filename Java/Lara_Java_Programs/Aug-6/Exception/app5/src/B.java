class B
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		if (true)
		{
			System.out.println("from if");
			throw new ArithmeticException("Some thing went wrong");
		}
		System.out.println(2);
	}
}
/* 
1
from if
Exception in thread "main" java.lang.ArithmeticException: Some thing went wrong
        at B.main(B.java:9)
*/