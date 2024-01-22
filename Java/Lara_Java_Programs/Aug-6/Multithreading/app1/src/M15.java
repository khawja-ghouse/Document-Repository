class M15 
{
	public static void main(String[] args) 
	{
		Thread t1 = Thread.currentThread();
		System.out.println("id:"+ t1.getId());//v cannot change the id of the thread
		System.out.println("name:"+ t1.getName());
		System.out.println("demon:"+ t1.isDaemon());
		System.out.println("priority:"+ t1.getPriority());
	}
}
//setDemon method use to convert a thread into demon
//priority is an integer number min :1 - max:10 5 is normal default pri of mainthread is 5
//through setpriority v can set the priority