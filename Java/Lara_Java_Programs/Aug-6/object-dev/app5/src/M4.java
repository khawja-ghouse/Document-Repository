class A
{
	int i;
	A(int i)
	{
		this.i = i;
	}
	void perfomClone()
	{
		try
		{
			A a2 = (A) clone();
			System.out.println(a2.i);	
		}
		catch (CloneNotSupportedException ex )
		{
			ex.printStackTrace();
		}
		
	}
}
class  M4
{
	public static void main(String[] args) 
	{
		A a1 = new A(20);
		 a1.perfomClone();
		System.out.println("done");
	}
}
//cloning cannot be done on any of the object by default 
//to do the cloning operation the object should be the type of clonable 
//clone() is called as marker interface(the interface that is not having any members)