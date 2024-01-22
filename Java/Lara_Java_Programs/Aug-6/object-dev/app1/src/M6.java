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
class M6
{
	public static void main(String[] args) 
	{
		A a1 = new A(26,21);
		A a2 = new A(6,1);
		String s1 ="state of a1:"+a1
		//(automatically tostring() reference is returned);
		String s2 ="state of a1:"+a2;

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(s1);
		System.out.println(s2);
	}
}