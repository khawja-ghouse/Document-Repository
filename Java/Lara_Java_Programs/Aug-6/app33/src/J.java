class J
{
	static void test(int x ,final int y)//callers of test meth ill be supplying the initial value 
	{
		x = 10;
		y = 10;//  this is reinitialization  CTE
		System.out.println("..............");
		x = 10;
		y = 10;
	}
}
