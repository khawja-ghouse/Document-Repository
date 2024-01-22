class Test
{
	int i;
}
class A extends Thread
{
	Test t1;
	A(Test t1)
	{
		this.t1 = t1;
	}
	public void run()
	{
		System.out.println("1:"+t1.i);
		t1.i =10;
		Util.sleep(500);
		System.out.println("2:"+t1.i);
		t1.i =20;
		Util.sleep(500);
		System.out.println("3:"+t1.i);
		t1.i =30;
		Util.sleep(500);
		System.out.println("4:"+t1.i);
		t1.i =40;
	}
}

class B extends Thread
{
	Test t1;
	B(Test t1)
	{
		this.t1 = t1;
	}
	public void run()
	{
		System.out.println("5:"+t1.i);
		t1.i =100;
		Util.sleep(500);
		System.out.println("6:"+t1.i);
		t1.i =200;
		Util.sleep(500);
		System.out.println("7:"+t1.i);
		t1.i =300;
		Util.sleep(500);
		System.out.println("8:"+t1.i);
		t1.i =400;
	}
}
class M64
{
	public static void main(String[] args) 
	{
		Test  t1 = new Test();
		t1.i = 500;
		A a1 = new A(t1);
		a1.start();
		Util.sleep(250);
		B b1 = new B(t1);
		b1.start();
		Util.sleep(50000);
		System.out.println("9:"+t1.i);
	}
}
