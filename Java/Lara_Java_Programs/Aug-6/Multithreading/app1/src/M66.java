class A extends Thread
{
	A(ThreadGroup tg, String name)
	{
		super(tg,name);
	}
	public void run()
	{
		for (int i = 1;i<= 100 ;i++ )
		{
		System.out.println(getName()+":"+i);
		}
	}
}

class B implements  Runnable
{
	Thread t1= Thread.currentThread();
	public void run()
	{
		for (int i = 1;i<= 100 ;i++ )
		{
		System.out.println(t1.getName()+":"+i);
		}
	}
}
class M66
{
	public static void main(String[] args) 
	{
		ThreadGroup  tg = new ThreadGroup("my first group");
		
		A a1 = new A(tg,"first Thread");
		A a2 = new A(tg,"Second Thread");
		A a3 = new A(tg,"Third Thread");
		B b1 =new B();
		Thread t1 = new Thread(tg,b1);
		Thread t2 = new Thread(tg,b1);
		Thread t3 = new Thread(tg,b1);
		a1.start();
		a2.start();
		a3.start();
		t1.start();
		t2.start();
		t3.start();
		Util.sleep(1);
		tg.stop();
	}
}//altogether 6 thread under one group name tg
//all thread are independent start separetly