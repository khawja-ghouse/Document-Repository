class A extends Thread 
{
	public void run()
	{
		for (int i =0 ;i < 300 ;i++ )
		{
			System.out.println("child:begin");
			Util.sleep(3000);
			System.out.println("child:end");
		}
	}
}
class M32
{
	public static void main(String[] args) 
	{
			A a1 = new A();
			a1.start();
			Util.sleep(3000);
			a1.interrupt();		
	}
}
