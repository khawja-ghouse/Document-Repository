class A
{
	static 
	{
		System.out.println("from A.SIB");
	}
	 public static void test()
	{
		System.out.println("from A.test()");
	}
}
class  B extends A
{
	static 
	{
		System.out.println("from B.SIB");
	}
}
class M7
{
	public static void main(String[] args) 
	{	
	  B.test();//A.test();
	}
}