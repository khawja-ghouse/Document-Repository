class Q
{
	Q()
	{
		//super calling stmt
		//all iib stms
		System.out.println("Q()");
	}
	{
		System.out.println("Q-IIB4");
		System.out.println("Q-IIB5");
		System.out.println("Q-IIB6");
	}
	Q(int i)
	{
		//super calling stmts
		//all iib statements
		System.out.println("Q(int)");
	}
	{
		System.out.println("Q-IIB1");
		System.out.println("Q-IIB2");
		System.out.println("Q-IIB3");
	}
	public static void main(String[] args)
	{
		Q q1 = new Q(10);
			System.out.println("...................");	
		Q q2 = new Q();
			System.out.println("...................");
	}
}