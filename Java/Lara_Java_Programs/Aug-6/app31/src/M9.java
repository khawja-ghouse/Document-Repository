class M9 
{
	static A test1(E e1)
	{
		return test2(e1);
	}	
	static B test2(D d1)
	{
		return test3(d1); ////return (B) test3(d1);
	}	
	static C test3(D d1)
	{
		return d1; //return (C) d1;
	}
	public static void main(String[] args) 
	{
		Object obj = test1(new E());//Object obj = (Object) test1(new E());
		System.out.println("Hello World!");
	}
}
