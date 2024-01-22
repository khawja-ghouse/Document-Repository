class M40
{
	public static void main(String[] args) 
	{
		A b1 = new B();
		b1.test1();
		System.out.println(b1.i);
		//b1.test2();
		//System.out.println(b1.j);
		if (b1 instanceof B)
		{
		B b2 = (B) b1;
		b2.test2();
		System.out.println(b2.i);
		}
	}
}
