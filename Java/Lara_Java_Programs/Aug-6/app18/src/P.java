class O
{
	public static  void main(String[] args)
	{
		System.out.println("O.main");			
	}
	static
	{
		System.out.println("O-SIB:");
	}
}
class P
{
	static
	{
		System.out.println("P-SIB:");
	}
	public static void main(String[] abc) //can supply any thing p or args
	{
		System.out.println("P.main begin");
		O.main(null);
		System.out.println("............");
		O.main(abc);
		System.out.println("P.main end");

	}
}
