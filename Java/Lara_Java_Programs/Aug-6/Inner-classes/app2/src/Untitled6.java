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
		
		H.B b1 = new H().new B();//when ever u are going for inner classs for reference you should for outer.inner
		H.C c1 = new H.C();// 
		System.out.println("Hello !");
	}
}