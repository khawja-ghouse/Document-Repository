class M13
{
	public static void main(String[] args)
	{

		Thread t1 = new Thread(
							() ->
							{	
								for (int i = 0;i < 200 ;i++ )
								{
									System.out.println("A"+i);
								}
							});
		t1.start();
		for (int i = 0;i < 200 ;i++ )
		{
			System.out.println("main"+i);
		}
	}
}
//here even if v are creating child thread ;v are not achiving multithreading 
//bec a1 thread is not registred with TS
