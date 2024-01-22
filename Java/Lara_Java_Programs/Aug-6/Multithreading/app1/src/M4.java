class A extends Thread
{
	public void run()
	{
		for (int i= 0;i < 50 ;i++ )
		{
			System.out.println(i);
		}
	}
}
class M4 
{
	public static void main(String[] args) 
	{
		A a1 = new A(); //new thread is created but not known to TS
		a1.run();//here mainthread is only executing run method
		for (int i = 200;i < 250 ;i++ )
		{
			System.out.println(i);
		}
	}
}
//here even if v are creating child thread ;v are not achiving multithreading 
//bec a1 thread is not registred with TS
