class A extends Thread 
{
	public void run()
	{
			System.out.println("child:begin");
			Util.sleep(10000);
			System.out.println("child:end");
	}
}
class M34
{
	public static void main(String[] args) 
	{
			A a1 = new A();
			a1.start();
			int i = 10/0;
			System.out.println("main end")	;
	}
}
