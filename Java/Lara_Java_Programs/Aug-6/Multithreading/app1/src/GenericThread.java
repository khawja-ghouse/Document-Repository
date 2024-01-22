import java.util.Properties;
class GenericThread extends Thread
{
	public void run()
	{
		while (true)
		{
			//1.going to wait
			synchronized(this)
			{
				try
				{
					wait();
				}
				catch (InterruptedException ex)
				{

				}
			}
			//2.main task
			//Properties pr = System.getProperties();
			//pr.list(System.out);
			//common task to every customer
			for (int i = 1;i< 5 ;i++ )
			{
				System.out.println(getName() + ":" + i);
				Util.sleep(100);
			}
			Util.sleep(1000);

			//3.sending a notification 
			synchronized(this)
			{
				notify();
			}

		}
    } 
}
