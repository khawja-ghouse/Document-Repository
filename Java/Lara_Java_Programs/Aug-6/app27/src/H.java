abstract class A
{

}
class H
{
	public static void main(String[] args)
	{
		A a1 = new A();
		System.out.println("DON");
	}
}
/*
H.java:9: error: A is abstract; cannot be instantiated
                A a1 = new A();
                       ^
1 error
*/