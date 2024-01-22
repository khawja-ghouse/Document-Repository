class A
{
	int i;
	A(int i)
	{
		this.i = i;
	}
}
class  M1
{
	public static void main(String[] args) 
	{
		A a1 =new A(20);
		A a2 = a1.clone();
		System.out.println("done");
	}
}
/*
->Object class containing clone() method:
protected Object clone() throws CloneNotSupportedException

->even though m1 also containg clone method that clone method v are not using
we are using class A clone method

*/