class G
{
	class B
	{
	}
	static class C
	{
	}
	public static void main(String[] args) 
	{
		
		B b1 = new G().new B();
		C c1 = new G.C();
		//AS C is static there is no proplem in using G class name ;to refer the c v are using G. class name 
		System.out.println("Hello !");
	}
}