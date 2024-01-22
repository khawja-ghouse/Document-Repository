class A < X >
{
	void test(X arg)
	{
	}
}
class M35
{
	public static void main(String[] args) 
	{
		A< ? > a1 = null;	
		a1 = new A<P>();////a1 is whildcard
		a1.test(new p());//ambiguity

		A<Integer> a2 = null;//a2 is fixed for Integer
		a2 = new A<Integer>();
		a2.test(90);
		System.out.println("Hello...");
	}
}
