class A
{
	 public static void test()
	{
		System.out.println("from A.test()");
	}
}
class  B extends A
{
	 public static void test()
	{
		System.out.println("from A.test()");
	}
	public static  void test()
	{
		System.out.println("from B.test()");
	}
}
class M6
{
	public static void main(String[] args) 
	{
		
		A a1 = new A();
		A a2 = new B();
		A[] elements = {a1,a2};
		for (A element:elements)
		{
			element.test();//A.test()
		}
	}
}
//Static methods can not be overrided it cannot be modified 
//in class B there are both static test member of A and static test member of B
//static is not a member of object but polymorphysm is object orented programming concept