class C
{
	private void test()
	{
		System.out.println("from test");
	}
	public static void main(String[] args) 
	{
		C c1 = new C();
		c1.test();
		System.out.println("done");
	}
}
/*

from test
done

*/