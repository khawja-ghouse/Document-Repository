class K 
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
		catch (ArithmeticException ex)
		{
			System.out.println("from catch "+ ex);
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("from catch "+ ex);
		}
		catch (NumberFormatException ex)
		{
			System.out.println("from catch"+ ex);
		}
		System.out.println("main end");
	}
}
