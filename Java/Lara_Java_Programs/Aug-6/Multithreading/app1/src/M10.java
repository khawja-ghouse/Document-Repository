class M10
{
	public static void main(String[] args)
	{

	    Thread t1 = new Thread()
		{
			public void run()
			{
				for (int i = 0;i < 200 ;i++ )
				{
					System.out.println("A"+i);
				}
			}
		};
	    Runnable r1 = new Runnable()
		{
			public void run()
			{
				for (int i = 0;i < 200 ;i++ )
				{
					System.out.println("B"+i);
				}
			}
		};
		t1.start();
		Thread t2 = new Thread(r1);
		t2.start();
		for (int i = 0;i < 200 ;i++ )
		{
			System.out.println("main"+i);
		}
	}
}