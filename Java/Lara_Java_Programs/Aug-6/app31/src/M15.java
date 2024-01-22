class M15 
{
	static B test(A obj)
	{
		return (B)obj;
	}
	public static void main(String[] args) 
	{
		Object obj1 = new E();
		C obj2 = (C) test((A)obj1);
		System.out.println("Hello World!");
	}
}
