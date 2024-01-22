class C
{
	C()
	{
		System.out.println("C()");
	}
	public static void main(String[] args) 
	{
		System.out.println("main begin");
		C c1 = new C();
		System.out.println("................");
		C c2 = new C();	
		System.out.println("................");
		C c3 = c1;
		System.out.println("main end");
	}
}
