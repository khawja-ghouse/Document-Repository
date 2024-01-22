class L
{
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		try
		{
			System.out.println("try begin");
			System.out.println("''''''''''''''");
			int i= Integer.parseInt(args[0]);
			System.out.println("''''''''''''''");
			int k = i / (i-9);
			System.out.println("''''''''''''''");
			System.out.println("try end");
		}
		catch (RuntimeException ex)
		{
			System.out.println("from catch "+ ex);
		}
		System.out.println("main end");
	}
}
