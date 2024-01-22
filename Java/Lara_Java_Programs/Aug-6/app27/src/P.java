abstract class A
{
	A()
	{
		System.out.println("A()");
	}
}
abstract class B extends A
{
   	B()
	{
		System.out.println("B()");
	}
}
class C extends B
{
	
}
class P 
{
	public static void main(String[] args)
	{
		C c1 = new C();
		System.out.println("..done..");
	}
}
/*
while creating the object to the C the empty constru is calling then the super() is executing goes to the B() then Again
super() in B()  calles to the constructor  of A() then the Object class constructor

*/