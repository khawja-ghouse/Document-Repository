class A extends Thread 
{
	public void run()
	{
		System.out.println("from child:");
		System.out.println("id:"+ getId());
		System.out.println("name:"+ getName());
		System.out.println("demon:"+ isDaemon());
		System.out.println("priority:"+ getPriority());
		Thread.currentThread().setPriority(6+1);
		System.out.println("priority:"+ getPriority());
	}
}
class M22
{
	public static void main(String[] args) 
	{
		Thread.currentThread().setPriority(9);
		A a1 = new A();//this is the user thread that is not depending on the parent 
		a1.start();
		System.out.println(""+ Thread.currentThread().getPriority());
	}
}
