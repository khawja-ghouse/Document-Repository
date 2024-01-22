class A extends Thread
{
	public void run()
	{
		for (int i= 0;i < 10 ;i++ )
		{
			System.out.println(i);
		}
	}
}
class M3 
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		//a new thred is created but the thread shedular is not known about this thread
		//the current thread main thread is known2
		a1.start();//a1 thread is registering to thread schedular and allocating to execute the run method()
		//once the a1 thread is known to the thread shedular => from here both the main thread and a1 thread 
		//is known then it gives processor time to  for both a1 and mainthread 
		for (int i = 200;i < 210 ;i++ )
		{
			System.out.println(i);
		}
	}
}

