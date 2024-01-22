abstract class A
{
	abstract void test();
}
class R extends A 
{
	void test()//Abstract method got overrieded in the  R class
	{
		System.out.println("from subclass.test()");
	}
	public static void main(String[] args) 
	{
		R r1 = new R();
		r1.test();//overrideing
		System.out.println("done");
	}
}