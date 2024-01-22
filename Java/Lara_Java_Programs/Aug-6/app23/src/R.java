class R
{
	R()
	{
		//super calling stmt
		//all iib stms
		System.out.println("R()");
	}
	{
		System.out.println("R-IIB4");
		System.out.println("R-IIB5");
		System.out.println("R-IIB6");
	}
	R(int i)
	{
		this();
		System.out.println("R(int)");
	}
	{
		System.out.println("R-IIB1");
		System.out.println("R-IIB2");
		System.out.println("R-IIB3");
	}
	public static void main(String[] args)
	{
		R r1 = new R();
			System.out.println("...................");	
		R r2 = new R(10);
			System.out.println("...................");
	}
}