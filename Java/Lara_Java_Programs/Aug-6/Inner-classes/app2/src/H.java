class H
{
	class B
	{

	}
	static class C
	{

	}
	public static void main(String[] args) 
	{
		
		H.B b1 = new H().new B();
		//when ever u are going for inner classs for reference you should go  for outer.inner
		H.C c1 = new H.C();
		// no matter the class is static or non static 
		System.out.println("Hello !");
	}
}