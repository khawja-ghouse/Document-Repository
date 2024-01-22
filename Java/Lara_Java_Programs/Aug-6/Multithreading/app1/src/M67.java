class Employee 
{
	// several mmbrs
}
class A extends Thread
{
	//several attributes
	public void run()
	{
		// some task
	}
}
class B extends Employee implements Runnable
{
	//several attributes
	public void run()
	{
		// some task
	}
}
class M67
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.start();
		a2.start();
		a3.start();

		B b1 = new B();
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b1);
		Thread t3 = new Thread(b1);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Hello World!");
	}
}
//main differene 
/*

