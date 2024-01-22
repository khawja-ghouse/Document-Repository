class A extends Thread 
{
	public void run()
	{
		for (int i = 1;i <=10  ;i++ )
		{
			System.out.println(i + ":" + getName());
			//if no yield is there it uses complete time given by TS
			yield();//giving a chance for another thread shedular before completing provided time
		}
	}
}
class B extends Thread 
{
	public void run()
	{
		for (int i = 1;i <= 10  ;i++ )
		{
			System.out.println(i + ":" + getName());
			yield();
		}
	}
}
class M63
{
	public static void main(String[] args) 
	{
		
		A a1 =  new A();
		a1.start();
		B b1 =  new B();
		b1.start();
		
	} 
}