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
		return "(i = " + i+",j = "+j+",";
	}
}
class B extends A
{
	int m;
	int n;
	B(int i,int j,int m,int n)
	{
		super(i,j);
		this.m = m;
		this.n = n;
	}
	public String toString()
	{
		return super.toString() +",m = " + m+",n = "+n+")";
	}
}
class M7
{
	public static void main(String[] args) 
	{
		A a1 = new A(1,2);
		A a2 = new A(3,4);
		String s1 ="state of a1:"+ a1;
		String s2 ="state of a2:"+a2;
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(s1);
		System.out.println(s2);
		B b1 = new B(5,6,7,8);
		B b2 = new B(9,10,11,12);
		String s3 ="state of b1:"+ b1;
		String s4 ="state of b2:"+b2;
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(s3);
		System.out.println(s4);
	}
}