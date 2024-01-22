class M8 
{
	static B test(C c1)
	{
		return c1; //return (B) c1;
	}
	public static void main(String[] args) 
	{
		A a1 = test(new E());//A a1 = (A) test((C)) new E());
		System.out.println("Hello World!");
	}
}
