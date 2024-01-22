class C
{
	public static void main(String[] args) 
	{
		System.out.println(1);
		if (true)
		{
			System.out.println("from if");
			throw new OutOfMemoryError("Some thing went wrong");
		}
		System.out.println(2);
	}
}
/* 
1
from if
Exception in thread "main" java.lang.OutOfMemoryError: Some thing went wrong
        at C.main(C.java:9)

*/