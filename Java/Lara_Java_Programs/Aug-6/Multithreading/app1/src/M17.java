class M17 
{
	public static void main(String[] args) 
	{
		Thread t1 = Thread.currentThread();
		
		System.out.println("domain:"+ t1.isDaemon());
		t1.setDaemon(true);
		System.out.println("name:"+ t1.isDaemon());
	}
}//we canot convert main thread into demon 
//we can convert thread into daemon but before starting 
//here main thread was started hence v can not convert into Daemon