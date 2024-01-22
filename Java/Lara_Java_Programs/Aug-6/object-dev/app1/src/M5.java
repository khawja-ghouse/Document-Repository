class A
{
	int i;
	int j;
	A(int i,int j)
	{
		this.i = i;
		this.j = j;
	}
	public String toString()
	{
		return "(i = " + i+",j = "+j+")";
	}
}
class M5
{
	public static void main(String[] args) 
	{
		A a1 = new A(26,21);
		A a2 = new A(6,1);

		System.out.println(a1);
		System.out.println(a2);
	}
}