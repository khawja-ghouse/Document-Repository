class Shared 
{
	synchronized void test1()
	{
		Thread t1 = Thread.currentThread();
		System.out.println("test1 begin by "+ t1.getName());
		try
		{
			wait();//when ever a thread is calling wait()==>wait() internally checking 
			//a1 is a owner to call wait();
			//now a1 thread goes into to waiting stage and reasing the OL of s1 
			//s1 is available for b thread again b also goes for the waithing satge using s1 
			//again relase the s1 and b available for main  
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}		
		System.out.println("test1 end by "+ t1.getName());
	}
	synchronized void test2()
	{
		Thread t1 = Thread.currentThread();
		System.out.println("test2 begin by "+ t1.getName());
		notifyAll();//once the notify is called the s1 obj is not released 
		//once main thread calls the notifyAll it notify  A and  B object
		//it notify all the thread which went through s1 
		//randomly that comout of the waiting stage 
		//assume that b thread gets the notification 
		//after the completion of main completly then it releases s1 
		System.out.println("test2 end by "+ t1.getName());
	}
}
class A extends Thread
{
	Shared obj;
	A(Shared obj)
	{
		this.obj = obj;
	}
	public void run()
	{
		obj.test1();
	}
}
class B extends Thread
{
	Shared obj;
	B(Shared obj)
	{
		this.obj = obj;
	}
	public void run()
	{
		obj.test1();
	}
}
class M48
{
	public static void main(String[] args) 
	{
		Shared s1 = new Shared();
		
		A a1 = new A(s1);
		B b1 = new B(s1);
		a1.start();
		b1.start();
		Util.sleep(10000);
		System.out.println("after sleep");
		s1.test2();
	}
}