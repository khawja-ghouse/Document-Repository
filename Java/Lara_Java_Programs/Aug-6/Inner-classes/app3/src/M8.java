class M8 
{
	public static void main(String[] args) 
	{
		B b1= new B()
		{
			{
				System.out.println("AIN_IIB");
			}

		};//In the body of the AIN v cannot develop constructor bec AIN does not have name 
		b1.test1();
		System.out.println("done");
	}
}
//