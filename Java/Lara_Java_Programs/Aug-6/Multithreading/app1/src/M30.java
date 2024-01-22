class A extends Thread 
{
	public void run()
	{
		for (int i =0 ;i < 300 ;i++ )
		{
			System.out.println("child:"+i);
			Util.sleep(3000);
		}
	}
}
class M30
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.start();
		for (int i = 1;i < 10;i++ )
		{
			System.out.println(i);
			Util.sleep(3000);
		}		
	}
}
