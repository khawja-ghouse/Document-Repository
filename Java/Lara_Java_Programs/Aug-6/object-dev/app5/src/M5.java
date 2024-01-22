class A implements Cloneable
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
class  M5
{
	public static void main(String[] args) 
	{
		A a1 = new A(20);
		 a1.perfomClone();
		System.out.println("done");
	}
}
//clone:creating a duplicate object by taking the content of existing object

//1.prtected u shu cal the clone method in the subclass itself
//2.Downcasting is required bec the return type is object type 
//3.Clone() method requires CloneNotSupportedException eighter through try-catch /
//-> throws
//4.the object should be clonable type => hence implement Clonable