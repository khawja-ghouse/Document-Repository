class F
{
	static int counter;
	F()
	{
		counter++;
	}
	public static void main(String[] args) 
	{
		System.out.println("M....B....");
		F f1 = new F();
		F f2 = new F();
		F f3 = new F();
		F f4 = new F();
		System.out.println(F.counter);
	}
}	
//program used to count the number of object created for a given class