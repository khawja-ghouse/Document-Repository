class X
{
	void test()
	{
		System.out.println(this);
	}
	public static void main(String[] args)
	{
		X x1 = new X();
		System.out.println(x1);//object address is printed
		x1.test();
	}
}