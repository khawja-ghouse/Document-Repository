class A 
{
	int i;
	int j;
	int k;
	double m;
	A(int i,int j,int k,double m)
	{
		this.i = i;
		this.j = j;
		this.k = k;
		this.m = m;
	}
	public int hashCode()  // over riding hashcode()
	{
		String s1 = Integer.toString(i);
		String s2 = Integer.toString(j);
		String s3 = Integer.toString(k);
		String s4 = Double.toString(m);
		int hash = s1.hashCode();
		hash += s2.hashCode();
		hash += s3.hashCode();
		hash += s4.hashCode();
		return hash;
	}
}
// use wrapper class to convert attribute into string 
class M5
{
	public static void main(String[] args)
	{
		A a1 = new A(90,80,70,100.8);
		A a2 = new A(90,80,70,100.8);
		A a3 = new A(90,80,70,100.8);
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a3.hashCode());
	}
}
// inside a string class hashcode is over rided