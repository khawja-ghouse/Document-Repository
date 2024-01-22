class A extends Thread
{
	public void run()
	{
		System.out.println("run begin");
		Util.sleep(10000);//sleeping state name is TIME_WAITING
		System.out.println("run end");
	}
}

class  M59
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.start();
		Util.sleep(5000);
		System.out.println("a:" + a1.getState());
	}
}
//