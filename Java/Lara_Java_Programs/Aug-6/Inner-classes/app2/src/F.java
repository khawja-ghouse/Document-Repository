class F
{
	class B
	{
	}
	static class C
	{
	}
	public static void main(String[] args) 
	{
		
		B b1 = new F().new B();//similar to prev but here v are using object reference 
		C c1 = new C();
		System.out.println("Hello !");
	}
}