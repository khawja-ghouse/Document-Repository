class M13 
{
	static void test(D obj)
	{

	}
	public static void main(String[] args) 
	{
		A a1 = new E();
		test((D) a1);
		B b1 = (B) a1;
		test((D) b1);
		C c1 = (C) a1;
		test((D) c1);
		System.out.println("Hello World!");
	}
}
