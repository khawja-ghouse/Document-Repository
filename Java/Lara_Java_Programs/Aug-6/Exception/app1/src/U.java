class U
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
			System.out.println(1);
			int[] x = new int[99999999999];
			System.out.println(2);
		}
		catch (OutOfMemoryError ex ) //Throwable
		{
			ex.printStackTrace();
		}
		System.out.println("main end");
	}
}
/*
main begin!
1
java.lang.OutOfMemoryError: Java heap space
        at U.main(U.java:9)
main end
*/