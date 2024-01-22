class A extends Thread 
{
	public void run()
	{
		System.out.println("run beging");
		synchronized (this)
		{
			System.out.println("sleep begin");
			Util.sleep(10000);
			System.out.println("sleep end");
		}
		System.out.println("run end");
	}
}
class M55
{
	public static void main(String[] args) 
	{
		System.out.println("main begin!");
		A a1 = new A();
		a1.start();
		Util.sleep(1000);
		synchronized(a1)
		{
			System.out.println("main in synchronized block");
		}
		System.out.println("main end!");
	}
}