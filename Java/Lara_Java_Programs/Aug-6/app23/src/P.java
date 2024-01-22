class P
{
	P()
	{
		System.out.println("P()");
	}

	{
		System.out.println("P-IIB4");
		System.out.println("P-IIB5");
		System.out.println("P-IIB6");
	}

	{
		System.out.println("P-IIB1");
		System.out.println("P-IIB2");
		System.out.println("P-IIB3");
	}
	public static void main(String[] args)
	{
		P p1 = new P();
			System.out.println("...................");	
		P p2 = new P();
			System.out.println("...................");
	}
}