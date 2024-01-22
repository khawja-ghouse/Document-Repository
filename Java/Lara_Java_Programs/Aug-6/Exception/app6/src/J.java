class J 
{
	public static void main(String[] args) 
	{
		try
		{
			System.out.println("try-begin");
			int i = 10/0;//exception 
			System.out.println("try-end");

		}
		catch (ArithmeticException ex)//handeling the exception 
		{
			System.out.println("from catch"+ex);
			throw new ArithmeticException(ex.getMessage());//rethrow the same exception
		}
		System.out.println("main end!");
	}
}
