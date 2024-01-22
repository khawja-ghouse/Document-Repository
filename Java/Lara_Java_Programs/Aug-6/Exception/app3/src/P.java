class P
{
	public static void main(String[] args)
	{
		System.out.println("main begin");
		try
		{
			Class.forName("");
			Class.forName("");
			Class.forName("");
			Class.forName("");
			Class.forName("");
			System.out.println("done");
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
		System.out.println("main end");
	}
}
/*
for n no of exception in the try block there can be one catch exception
*/