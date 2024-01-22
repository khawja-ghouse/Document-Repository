class M19
{
	public static void main(String[] args) 
	{
		int i = 10;
		double j = 10.5;
		j = i;


		Double obj1 = new Double(20);
		Integer obj2 = new Integer(20);
		obj1 = obj2;//interger waper cannot be asigned to double  wraper

		System.out.println("done");
	}
}
//one wrapper cannot be converter to another 
//only auto upcasting 
//Integer is wrapper class and derived datatype