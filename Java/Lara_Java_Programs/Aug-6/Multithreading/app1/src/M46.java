class Shared 
{
	void test1(Shared obj)
	{
		Thread t1 = Thread.currentThread();
		System.out.println("test1 begin by "+ t1.getName());
		synchronized (this)
		{
			System.out.println("test1 synl begin by"+ t1.getName());
			Util.sleep(100);
			synchronized(obj)
			{
				System.out.println("test1 syn2 begin by "+ t1.getName());
			}
			System.out.println("test1 syn1 end by "+ t1.getName());
		}
		System.out.println("test1 end by "+ t1.getName());
	}
	void test2(Shared obj)
	{
		Thread t1 = Thread.currentThread();
		System.out.println("test2 begin by "+ t1.getName());
		synchronized (this)
		{
			System.out.println("test2 synl begin by"+ t1.getName());
			Util.sleep(100);
			synchronized(obj)
			{
				System.out.println("test2 syn2 begin by "+ t1.getName());
			}
			System.out.println("test2 syn1 end by "+ t1.getName());
		}
		System.out.println("test2 end by "+ t1.getName());
	}
}
class A extends Thread
{
	Shared s1,s2;
	A(Shared s1,Shared s2)
	{
		this.s1 = s1;
		this.s2 = s2;
	}
	public void run()
	{
		s1.test1(s2);
	}
}
class B extends Thread
{
	Shared s1,s2 ;
	B(Shared s1,Shared s2)
	{
		this.s1 = s1;
		this.s2 = s2;
	}
	public void run()
	{
		s2.test2(s1);
	}
}
class M46
{
	public static void main(String[] args) 
	{
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		A a1 = new A(s1,s2);
		B b1 = new B(s1,s2);
		a1.start();
		b1.start();
	}
}