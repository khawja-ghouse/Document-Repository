class A 
{
	static A obj;
	protected void finalize()
	{
		obj = this;
		System.out.println(" from finalize()");
	}
}
class M3
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("1:" + A.obj);//obj is a static here
		A a1 = new A();
		System.out.println("a1:" + a1);//a1 address
		a1 = null;//making abbandant 
		Runtime.getRuntime().gc();
		Thread.sleep(10);
		System.out.println("2:" + A.obj);
		//object geting a re life
		A.obj = null;
		Runtime.getRuntime().gc();//here finaize method is not called
		Thread.sleep(10);
		System.out.println("3:" + A.obj);
	}
}
//demonstration for the resurrection 