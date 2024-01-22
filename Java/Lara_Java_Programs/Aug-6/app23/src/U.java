class A
{
	static
	{
		System.out.println("A-SIB");
	}
}
class  B extends A
{
	static
	{
		System.out.println("B-SIB");
	}
}
class X extends B
{
	static
	{
		System.out.println("X-SIB");
	}
	public static void main(String[] args) 
	{
		System.out.println("X-main");
	}
}
