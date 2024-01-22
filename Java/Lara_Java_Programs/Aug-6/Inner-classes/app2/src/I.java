class I
{
	class B
	{
	}
	static class C
	{
	}
}
class J
{
	public static void main(String[] args) 
	{
		
		I.B b1 = new I().new B();
		I.C c1 = new I.C(); 
		System.out.println("Hello!");
	}
}
//if you are using in the other class 
//->for reference use outer . inner
//->for object non static use reference of outer or object of outer
//->for object static use just the class name 