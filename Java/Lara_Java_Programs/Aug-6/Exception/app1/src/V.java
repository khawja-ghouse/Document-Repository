class V
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		try
		{
			System.out.println(1);
			int[] x = new int[9];//No exception  has occure and catch is not executed
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
2
main end
*/