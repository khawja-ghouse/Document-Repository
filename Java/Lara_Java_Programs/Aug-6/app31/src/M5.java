class M5
{
	public static void main(String[] args) 
	{
		A a1 = new D();
		Object obj = new B();
		C c1 = new D();
		B b1 = new E();// B b1 = (B) new E();
		D d1 = new E();
		A a3 = new B();
		A a2 = new C();  // A a2 = (A) new C();
		System.out.println("done");
	
	}
}
