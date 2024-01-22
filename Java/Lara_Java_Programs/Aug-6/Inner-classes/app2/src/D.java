class D 
{
	class B
	{

	}
	static class C
	{

	}
	public static void main(String[] args) 
	{
		//A a1 = null;
		B b1 = new B();//CTE bec v cannot  use not static member without reference  
		C c1 = new C();
		System.out.println("Hello !");
	}
}
/*
D.java:12: error: non-static variable this cannot be referenced from a static context
                B b1 = new B();//CTE bec v cannot  use not static member without reference
                       ^
1 error
*/