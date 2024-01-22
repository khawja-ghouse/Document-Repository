class A
{
	void test(Integer arg,String arg1)
	{

	}
}
class M7
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.test(20,"abc");
		a2.test(40,"hello");
		a3.test(60,"hiii");
		System.out.println("done");
	}
}