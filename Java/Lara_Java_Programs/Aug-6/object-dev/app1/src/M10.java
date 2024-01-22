class M10 
{
	public static void main(String[] args) 
	{
		Integer obj1 = new Integer(900000);
		System.out.println(obj1);
		Double obj2 = new Double(900000.9);
		System.out.println(obj2);
	}
}
//in every Wrapper class the toString() method is overridded
//hence when ur printing the obj1 the content is printed