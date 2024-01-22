class A
{
	String test()
	{
		return null;
	}
}
class M8
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		String s1 = a1.test();
		String s2 = a2.test();
		System.out.println("done");
	}
}