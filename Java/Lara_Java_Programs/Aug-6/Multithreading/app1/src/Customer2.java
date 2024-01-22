class Customer2 extends Thread 
{
	private ThreadPoolManager tp;
	Customer2(ThreadPoolManager tp )
	{
		this.tp = tp;
	}
	public void run()
	{
		while(true)
		{
			GenericThread t1 = tp.checkout();
			synchronized(t1)
			{
				t1.notify();
			}
			synchronized(t1)
			{
				try
				{
					t1.wait();
				}
				catch (InterruptedException ex)
				{

				}
			}
			tp.checkIn(t1);
			Util.sleep(10000);
		}
	}
}