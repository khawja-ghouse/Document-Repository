 class A
{
	private void test()
	{
	}
}
class I extends A
{
	public static void main(String[] args) 
	{
		I obj =new I();
		obj.test();
		System.out.println("done");
	}
}
/*

I.java:12: error: cannot find symbol
                obj.test();
                   ^
  symbol:   method test()
  location: variable obj of type I
1 error

*/\