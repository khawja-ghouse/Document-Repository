class A
{
	private  A()
	{
		System.out.println("A()");
	}
}
class G extends A
{
	public static void main(String[] args) 
	{
		System.out.println("done");
	}
}
/*

G.java:8: error: A() has private access in A
class G extends A
^
1 error

*/