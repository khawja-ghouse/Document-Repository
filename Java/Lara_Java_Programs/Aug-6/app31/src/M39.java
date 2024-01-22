class M39
{
	public static void main(String[] args) 
	{
		A b1 = new B();
		b1.test1();
		System.out.println(b1.i);
		//b1.test2();
		//System.out.println(b1.j);
		B b2 = b1;
		b2.test2();
		System.out.println(b2.i);
	}
}
