class M14
{
	public static void main(String[] args)
	{

		 new Thread(
				() ->
				{	
					for (int i = 0;i < 200 ;i++ )
					{
						System.out.println("A"+i);
					}
				}).start();
		for (int i = 0;i < 200 ;i++ )
		{
			System.out.println("main"+i);
		}
	}
}
//here even if v are creating child thread ;v are not achiving multithreading 
//bec a1 thread is not registred with TS
