class A 
{
	A obj;
	protected void finalize()
	{
		System.out.println(" from finalize()");
	}
}
class M2
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.obj = a2;
		a2.obj = a3;
		a3.obj = a1;
		a1 = a2 = a3= null;
		System.gc();
		System.out.println("done");
	}
}
