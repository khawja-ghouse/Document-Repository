class A
{
	private void test()
	{
		System.out.println("from test");
	}
}
class D
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.test();
		System.out.println("done");
	}
}
/*

D.java:13: error: test() has private access in A
                a1.test();
                  ^
1 error

*/