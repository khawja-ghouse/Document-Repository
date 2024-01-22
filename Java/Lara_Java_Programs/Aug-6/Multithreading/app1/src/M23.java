class A extends Thread 
{
	public void run()
	{
		System.out.println("from child:");
		System.out.println("id:"+ getId());
		System.out.println("name:"+ getName());
		System.out.println("demon:"+ isDaemon());
		System.out.println("priority:"+ Thread.currentThread().getPriority());
	}
}
class M23
{
	public static void main(String[] args) 
	{
		//Thread.currentThread().setPriority(10);
		A a1 = new A();
		a1.setName("FIRST CHILD THREAD");
		a1.start();
		System.out.println("priority:"+ Thread.currentThread().getPriority());

	}
}
