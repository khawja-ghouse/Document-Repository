class A extends Thread 
{
	public void run()
	{
		for (int i =0 ;i < 5 ;i++ )
		{
			System.out.println("child:"+i);
		}
	}
}
class M25
{
	public static void main(String[] args) 
	{
		A a1 = new A();//thread is created (UT)
		a1.start();
		System.out.println("main end");
	}
}
