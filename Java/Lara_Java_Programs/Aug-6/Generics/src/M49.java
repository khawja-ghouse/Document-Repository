class A <T> 
{
	T obj;
}
class M49
{

	static void test(A <? extends Number > arg)
	{
			arg.obj = 10;
	}
}

