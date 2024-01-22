class A implements Runnable//now A class is not a thread   
{
	public void run()
	{
		for (int i= 0;i < 200 ;i++ )
		{
			System.out.println(i);
		}
	}
}
class M5
{
	public static void main(String[] args) 
	{
		A a1 = new A(); //creating an object to a thread is not creating bec its not a sub class to thread
		Thread t1 = new Thread(a1);//inside a thread class there is a single arg constructor 
		//that accepts runnable type as arg but still not registered
		t1.start();//now t1 thread is registered
		//we canot call a1.start bec there is no start() in A class 
		for (int i = 300;i < 500 ;i++ )
		{
			System.out.println(i);
		}
	}
}
