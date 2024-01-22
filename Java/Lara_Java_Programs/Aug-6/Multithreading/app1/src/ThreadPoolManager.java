import java.util.*;
class ThreadPoolManager
{
	private ArrayList list = new ArrayList();
	public void init()//required no of generic thread here v are using 10 GT
	{
		GenericThread t1 = null;
		for (int i = 1;i <= 10; i++)//for every itiration with its own object going to 
		//start and geting new thread
		{
			t1 = new GenericThread();
			t1.start();
			list.add(t1);
		}
	}
	public GenericThread checkout()
	{
		GenericThread t1 = null;
		if (list.size() > 0)
		{
			t1 = (GenericThread) list.remove(0);//removing from the list 0-9
			//first thread is removed
			//for the next customer the thread ill be new thread 0-8 
			//automatically suffeling of indexvalue
		}
		else//for 11th customer this generic method is executed
		//and sending 
		{
				t1 = new GenericThread();
				t1.start();
		}
		return t1;
	}
  public void checkIn(GenericThread t1)
	{//customer returning the used thread for using for other customer
	   if (list.size() < 10)
		{
			list.add(t1);
		}
		else//stop adding 
		{		
				t1.stop();
		}
	}
	public void release()//relasing every generic thread
	{
		GenericThread t1;
		for (int i =0; i < list.size(); )
		{
			t1 = (GenericThread) list.remove(i);
			t1.stop();
		}
	}
}
		