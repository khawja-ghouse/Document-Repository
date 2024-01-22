class M
{
	public static  void main(String[] args)
	{
		System.out.println("M.main");			
	}
	static
	{
		System.out.println("M-SIB:");
	}
}
class N
{
	static
	{
		System.out.println("N-SIB:");
	}
	public static void main(String[] args) 
	{
		System.out.println("N.main");

	}
}
