class I
{
	static int counter;
	I()
	{
		System.out.println("I()");
	}
	I(int i)
	{
		this();
		System.out.println("I int");
	}	
	I(int i,int j)
	{
		this(10);
		System.out.println("I int, int");
	}
	{
		counter++;
		System.out.println("IIB");
	}
	public static void main(String[] arIs) 
	{
		System.out.println("M....B....");
		I i1 = new I();		
		I i2 = new I(10);		
		I i3 = new I();		
		I i4 = new I(1,2);		
		I i5 = new I();		
		I i6 = new I(5);		
		System.out.println(I.counter);
	}
}
//proIram used to count tIe number of object created for a Given class