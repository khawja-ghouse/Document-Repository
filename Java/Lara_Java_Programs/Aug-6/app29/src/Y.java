class A
{
}
class B extends A
{
}
class C extends B
{
}
class P
{
	 B test()
	{
		 return null;
	}
}
class Q extends P
{
	 C test()// co - variant (JDK1.5)
	{
		 return null;
	}
}
class  Y
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
