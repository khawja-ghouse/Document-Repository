interface A
{
	 void test();
}
class  B implements A
{
	public void test()
	{
		System.out.println("from B.test()");
	}
}
class C implements A
{
	public void test()
	{
		System.out.println("from C.test()");
	}

}
class M5
{
	public static void main(String[] args) 
	{
		
		A a1 = new B();
		A a2 = new C();
		A[] elements = {a1,a2};
		for (A element:elements)
		{
			element.test();//same statement executing many times resulting different value 
		}
	}
}