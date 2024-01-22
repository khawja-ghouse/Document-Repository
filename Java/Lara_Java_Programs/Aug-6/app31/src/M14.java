class M14 
{
	static B test(A obj)
	{
		return obj;
	}
	public static void main(String[] args) 
	{
		Object obj1 = new E();
		C obj2 = test(obj1);
		System.out.println("Hello World!");
	}
}
