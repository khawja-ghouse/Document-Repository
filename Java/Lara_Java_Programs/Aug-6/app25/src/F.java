class A
{
	private  A()
	{
		System.out.println("A()");
	}
}
class F
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		System.out.println("done");
	}
}
/*

F.java:12: error: A() has private access in A
                A a1 = new A();
                       ^
1 error

*/