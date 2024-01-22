class M19 
{
	public static void main(String[] args) 
	{
		Thread t1 = Thread.currentThread();
		
		System.out.println("priority:"+ t1.getPriority());
		t1.setPriority(11);
		System.out.println("priority:"+ t1.getPriority());
	}
}
