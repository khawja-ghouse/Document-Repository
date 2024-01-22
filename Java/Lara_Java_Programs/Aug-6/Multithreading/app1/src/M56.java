class A extends Thread 
{
	public void run()
	{
		System.out.println("run beging");
		Util.sleep(3000);
		synchronized (this)
		{
			System.out.println("child is in synchronized block");
		}
		System.out.println("run end");
	}
}
class M56
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		A a1 = new A();
		a1.start();
		Util.sleep(1000);
		synchronized(a1)
		{
			try
			{
				a1.join();//when ever join method is executed lock is released
			}
			catch (InterruptedException ex)
			{

			}
			System.out.println("main in synchronized block");
		}
		System.out.println("main end!");
	}
}