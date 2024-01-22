class A
{
	int i;
	A(int i)
	{
		this.i =i;
	}
	// here we are not using object class equals method
	public boolean equals(Object obj) 
	{
		return(i == ((A)obj).i);
		// downcasting 
	}
}
class M3
{

	public static void main(String[] args) 
	{
		A a1 = new A(90);
		A a2 = new A(90);
		
		System.out.println(a1.equals(a2));//true
	}
}

