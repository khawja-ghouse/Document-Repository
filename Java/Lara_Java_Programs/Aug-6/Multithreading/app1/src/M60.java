class A extends Thread
{
	public void run()
	{
		System.out.println("run begin");
		synchronized(this)
		{
			try
			{
				wait();
			}
			catch (InterruptedException ex)
			{

			}
		}
		System.out.println("run end");
	}
}


class  M60
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.start();
		Util.sleep(5000);
		System.out.println("a:" + a1.getState());
		synchronized(a1)
		{
			a1.notify();
		}
	}
}
//