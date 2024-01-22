class A extends Thread
{
	public void run()
	{
		synchronized (this)
		{
			System.out.println(getName()+"going to wait");
			try
			{
				wait();
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}		
			System.out.println(getName()+"returned from wait");
		}
	}
}

class B extends Thread
{
	
	public void run()
	{
		synchronized (this)
		{
			System.out.println(getName()+"going to wait");
			try
			{
				wait();
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}		
			System.out.println(getName()+"returned from wait");
		}
	}
}
class M53
{
	public static void main(String[] args) 
	{		
		A a1 = new A();
		B b1 = new B();
		a1.start();
		b1.start();
		Util.sleep(10000);
		System.out.println("after sleep");
		synchronized(a1)
		{
			a1.notify();
		}
		synchronized(b1)
		{
			b1.notify();
		}
	}
}
	