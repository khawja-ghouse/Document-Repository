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
	 V test()// cmp time error bec v are using the derived type of the superclass
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
