class A implements Runnable//now A class is not a thread   
{
	public void run()
	{
		for (int i= 0;i < 10 ;i++ )
		{
			System.out.println(Thread.currentThread().getName()+";"+i);
		}
	}
}
class M7
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		t1.start();
		t2.start();
		for (int i = 300;i < 310 ;i++ )
		{
			System.out.println(Thread.currentThread().getName()+";"+i);
		}
	}
}
//here even if v are creating child thread ;v are not achiving multithreading 
//bec a1 thread is not registred with TS
