class W
{
	W() throws ClassNotFoundException
	{
		System.out.println("W()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		try
		{
			W w1 = new W();
		}
		catch (ClassNotFoundException ex)
		{

		}
		System.out.println("main end");
	}
}
