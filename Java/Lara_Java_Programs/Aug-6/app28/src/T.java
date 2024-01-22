interface A
{
	void test1();
}

abstract class T implements A
{
	public void test1(int i)
	{
		System.out.println("from test1(int)!");
	}
}

//cmp successful bec class T is also abstract class