class A
{
	int i;
	A(int i)
	{
		this.i = i;
	}
	void perfomClone()
	{
		A a2 = clone();
		//clone method return type is Object type v cannot access direcrly to 
		//A type 
		System.out.println(a2.i);
	}
}
class  M2
{
	public static void main(String[] args) 
	{
		A a1 = new A(20);
		A a2 = a1.perfomClone();
		System.out.println("done");
	}
}