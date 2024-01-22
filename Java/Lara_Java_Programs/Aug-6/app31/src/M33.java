class M33
{
	public static void main(String[] args) 
	{
		A a1 = new C();
		if (a1 instanceof B)
		{
			B b1 = (B)a1;
			System.out.println("converting to B type");
		}	
		if (a1 instanceof C)
		{
			C c1 = (C)a1;
			System.out.println("converting to c type");
		}	
		if (a1 instanceof D)
		{
			D d1 = (D)a1;
			System.out.println("converting to d type");
		} 
		System.out.println("Hello World!");
	}
}
