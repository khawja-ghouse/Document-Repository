
class A extends Thread 
{
	public void run()
	{
		for (int i =0 ;i < 10 ;i++ )
		{
			System.out.println("child:"+i);
		}
	}
}
class M26
{
	public static void main(String[] args) 
	{
		A a1 = new A();

			a1.setDaemon(true);//when ever parent is leaving child is also leaving

		a1.start();
		System.out.println("main begin");
		for (int i =0 ;i < 4 ;i++ )
		{
			System.out.println("main:"+i);
		}

	}
}