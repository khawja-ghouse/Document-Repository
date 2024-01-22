class M28
{
	public static void main(String[] args) 
	{
		for (int i =1; i < 10 ;i++ )
		{
			System.out.println(i);
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
//join ,sleep and wait method requires a InterruptedException
//1000 milli sec is 1sec; for every iteration stops for 1 sec