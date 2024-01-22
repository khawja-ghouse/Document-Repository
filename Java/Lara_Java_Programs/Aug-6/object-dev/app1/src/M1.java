class A
{
	int i;
}
class M1 
{
	public static void main(String[] args) 
	{
		A a1 = new A();
		a1.i = 10;
		System.out.println(a1);
	}
}
//while printing a reference variable v are  internally calling object class
//toString() then printing the address of memmory wher a1 is pointing in the hexadecimal format