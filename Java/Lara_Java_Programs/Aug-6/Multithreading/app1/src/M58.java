class A extends Thread
{
	public void run()
	{
		System.out.println("run begin");
		for (int i= 0;i < 10 ;i++ )
		{
			System.out.println(i);
		}
		System.out.println("run end");
	}
}

class  M58
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		System.out.println("a:" + a1.getState());
		a1.start();
		System.out.println("b:" + a1.getState());
		Util.sleep(1);
		System.out.println("c:" + a1.getState());
		Util.sleep(1000);
		System.out.println("d:" + a1.getState());
	}
}
//