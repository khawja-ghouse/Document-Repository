class Shared 
{
	synchronized void test()
	{
		Thread t1 = Thread.currentThread();
		for (int i = 0;i < 10 ;i++ )
		{
			System.out.println("test:"+i+","+t1.getName());
		}
	}
}
class A extends Thread
{
	Shared s1 ;
	A(Shared s1)
	{
		this.s1 = s1;
	}
	public void run()
	{
		s1.test();
	}
}
class B extends Thread
{
	Shared s2 ;
	B(Shared s2)
	{
		this.s2 = s2;
	}
	public void run()
	{
		s2.test();
	}
}
class M38
{
	public static void main(String[] args) 
	{
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		A a1 = new A(s1);
		B b1 = new B(s2);
		a1.start();
		b1.start();
		//s1.test();
	}
}
//for one s1 object data threads should not executing simultaniously 