class E
{
	static int i;
	public static void test()
	{
		System.out.println("test"+i);		
		System.out.println("test"+E.i);		
	}
}
class F
{
	public static void main(String[] args) 
	{
		System.out.println("main"+ E.i);
		E.test();
	}
}
