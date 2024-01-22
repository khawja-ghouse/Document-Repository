class I extends Object
{
	I()
	{
		super();
       System.out.println("I()");
	}
}
class  J extends I
{
	J()
	{
		super();//calling is going to super class constructor with no arg
		System.out.println("J()!");
	}
	public static void main(String[] args) 
	{
		J j1 = new J();
		System.out.println("'''''''''''");
		J j2 = new J();
	}
}
