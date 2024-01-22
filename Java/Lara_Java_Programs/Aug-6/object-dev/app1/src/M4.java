class A
{
	int i;
	public String toString()
	{
		return "i = " + i;
	}
}
class M4
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.i = 10;
		System.out.println(a1);
	}
}
//in any entity class always try to override the "toString()" to get the attribute values