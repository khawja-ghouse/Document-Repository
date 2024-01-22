class A 
{
	protected void finalize()
	{
		System.out.println(" from finalize()");
	}
}
class M1
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1 = null;
		//System.gc();
		//Runtime.getRuntime().gc();
		System.out.println("done");
	}
}

//you can class finalize() method anyno of time :: you can do that bec u are having the 
//reference then that object is still Live
//only when that object became the abbundant the finalize() is called last step;