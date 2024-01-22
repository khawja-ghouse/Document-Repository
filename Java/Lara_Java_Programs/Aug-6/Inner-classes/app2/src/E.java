class E 
{
	class B
	{
	}
	static class C
	{
	}
	public static void main(String[] args) 
	{
		E e1  = new E();
		B b1 = e1.new B();//e1 is a reference to class E
		C c1 = new C();
		System.out.println("Hello !");
	}
}