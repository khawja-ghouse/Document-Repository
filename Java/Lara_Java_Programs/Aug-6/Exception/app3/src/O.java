class O
{
	public static void main(String[] args)
	{
		try
		{
			int i =10;
			System.out.println(i);
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
	}
}
/*
try cannot be empty if catch is taking an exception*/