class A
{
	void test()
	{
		System.out.println("froom A.test");
	}
}
class P extends A 
{
	void test()
	{
		System.out.println("from P.test");
	}
	public static void main(String[] args) 
	{
		P p1 = new P();
		p1.test();
		System.out.println("done");
	}
}
//while over riding a method same signature same return type and the super class has that coressponding method to override