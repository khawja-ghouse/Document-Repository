class M9
{
	public static void main(String[] args)
	{

		class A extends Thread
		{
			public void run()
			{
				for (int i = 0;i < 200 ;i++ )
				{
					System.out.println("A"+i);
				}
			}
		}




		class B implements Runnable
		{
			public void run()
			{
				for (int i = 0;i < 200 ;i++ )
				{
					System.out.println("B"+i);
				}
			}
		}

		A a1 = new A();
		a1.start();

		B b1 = new B();
		Thread t1 = new Thread(b1);
		t1.start();
		for (int i = 0;i < 200 ;i++ )
		{
			System.out.println("main"+i);
		}
	}
}

