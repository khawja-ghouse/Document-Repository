class A extends Thread
{
	public void run()
	{
		for (int i= 0;i < 100 ;i++ )
		{
			System.out.println(getName()+":"+i);
		}
	}
}
class M6 
{
	public static void main(String[] args) 
	{
		A a1 = new A(); //new thread is created but not known to TS
		A a2 = new A(); //new thread is created but not known to TS
		a1.start();
		a2.start();
		for (int i = 200;i < 300 ;i++ )
		{
			System.out.println(Thread.currentThread().getName()+";"+i);
		}
	}
}
//two threads to the main thread 
//1thread-0
//2thread-1
