class A extends Thread
{
	Thread m1;
	A(Thread m1)
	{
		this.m1= m1;
	}
	public void run()
	{
		System.out.println("run begin");
		Util.sleep(1000);
		System.out.println("a:" + m1.getState());
		System.out.println("run end");
	}
}


class  M61
{
	public static void main(String[] args) 
	{
		Thread t1 = Thread.currentThread();
		A a1 = new A(t1);
		a1.start();
		try
		{
			a1.join();
		}
		catch (InterruptedException ex)
		{

		}
	}
}
