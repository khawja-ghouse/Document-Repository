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
	Shared s1 ;
	B(Shared s1)
	{
		this.s1 = s1;
	}
	public void run()
	{
		s1.test();
	}
}
class M37
{
	public static void main(String[] args) 
	{
		Shared s1 = new Shared();
		A a1 = new A(s1);
		B b1 = new B(s1);
		a1.start();
		b1.start();
		s1.test();
	}
}
//thread can not enter into the sycro.. method stright away 
//it requires object lock to enter into syncr... method
//every object ill have one object lock(no matter to which class your are creating an object)
//3 thread sharing the same S1 ==> 
// alll three thread waiting for s1 object lock initially
//if a1 thread gets s1 object then b1 and main thread is keep on waithing for the s1 
//==>after the completion of the a1 then s1 ill be available for the b1 or main thread
//==>then if its available for b1 then main ill be waithing for the s1 
//=>at last s1 object is available for main thread