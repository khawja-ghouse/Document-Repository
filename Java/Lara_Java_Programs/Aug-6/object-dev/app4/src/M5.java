class A
{
}
class M5
{
	public static void main(String[] args) 
	{
		A a1 = new A(),a2 = new A(),a3 = new A();
		a1 = null;
		//only one object is becoming Abbandant
		System.out.println("Hello World!");
	}
}
