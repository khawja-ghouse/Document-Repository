class A extends Thread 
{
	A(String name)
	{
		super(name);
	}
	public void run()
	{
		System.out.println("from child:");
		System.out.println("id:"+ getId());
		System.out.println("name:"+ getName());
		System.out.println("demon:"+ isDaemon());
		System.out.println("priority:"+ getPriority());
	}
}
class M24
{
	public static void main(String[] args) 
	{
		//Thread.currentThread().setPriority(10);
		A a1 = new A("FIRST CHILD THREAD");
		//A a2 = new A("nadeem");
		//a1.setName();
		a1.start();
	}
}
