class M42 
{
	public static void main(String[] args) 
	{
		B b1 = new D();
		System.out.println(b1.i);
		System.out.println(b1.j);
		if (b1 instanceof D)
		{
		D d1 = (D)b1;
		System.out.println(d1.k);
		System.out.println(d1.l);
		}
	}
}
