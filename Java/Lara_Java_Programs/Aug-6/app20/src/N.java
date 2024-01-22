class N
{
	int i;
	public static void test()
	{
		N n1 = new N();
		System.out.println("test:"+n1.i);
	}
	public static void main(String[] args) 
	{

		N n1 = new N();
		System.out.println("main:"+n1.i);
		//N n1 = new N();
		test();//static method can call directly
	}
}
