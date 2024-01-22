class M8
{
	static class A extends Thread
	{
		public void run()
		{
			for (int i = 0;i < 200 ;i++ )
			{
				System.out.println("A"+i);
			}
		}
	}
	static class B implements Runnable
	{
		public void run()
		{
			for (int i = 0;i < 200 ;i++ )
			{
				System.out.println("B"+i);
			}
		}
	}
	public static void main(String[] args) 
	{
		//M8 m = new M8();
		A a1 = m.new A();
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

