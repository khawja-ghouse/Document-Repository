class A
{
	A() throws ClassNotFoundException
	{
	}
}

class X extends A
{
	X() //throws ClassNotFoundException
	{

	} 
	public static void main(String[] args)
	{
		System.out.println("done");
	}
}
// there is a super calling statement in X class constructor which is giving a call to  A class constructor which
//is throwing a exception which v are not handling