class A extends Thread
{
	ThreadLocal t1;
	A(ThreadLocal t1)
	{
		this.t1 = t1;
	}
	public void run()
	{
		System.out.println("1:"+t1.get());
		t1.set(10);
		Util.sleep(500);
		System.out.println("2:"+t1.get());+
		t1.set(20);
		Util.sleep(500);
		System.out.println("3:"+t1.get());
		t1.set(30);
		Util.sleep(500);
		System.out.println("4:"+t1.get());
		t1.set(40);
	}
}

class B extends Thread
{
	ThreadLocal t1;
	B(ThreadLocal t1)
	{
		this.t1 = t1;
	}
	public void run()
	{
		System.out.println("5:"+t1.get());
		t1.set(100);
		Util.sleep(500);
		System.out.println("6:"+t1.get());
		t1.set(200);
		Util.sleep(500);
		System.out.println("7:"+t1.get());
		t1.set(300);
		Util.sleep(500);
		System.out.println("8:"+t1.get());
		t1.set(400);
	}
}
class M65
{
	public static void main(String[] args) 
	{
		ThreadLocal  t1 = new ThreadLocal();
		t1.set(500);
		A a1 = new A(t1);
		a1.start();
		Util.sleep(250);
		B b1 = new B(t1);
		b1.start();
		Util.sleep(50000);
		System.out.println("9:"+t1.get());
	}
}
//ThreadLocal class  maintain a value local to thread
//the value seting by A thread it is not visiple to main or B thread even though 
// they are maintaing the one local object 