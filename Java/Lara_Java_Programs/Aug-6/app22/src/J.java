class J
{
	 int counter;
	J()
	{
		System.out.println("J()");
	}
	J(int i)
	{
		this();
		System.out.println("J int");
	}	
	J(int i,int j)
	{
		this(10);
		System.out.println("J int, int");
	}
	{
		counter++;
		System.out.println("JJB");
	}
	public static void main(String[] arJs) 
	{
		System.out.println("M....B....");
		J i1 = new J();		
		J i2 = new J(10);	
		J i3 = new J(1,2);		
		System.out.println(i1.counter);
		System.out.println(i2.counter);
		System.out.println(i3.counter);
	}
}
//proJram used to count tJe number of object created for a Jiven class