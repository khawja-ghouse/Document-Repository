class M5 
{
	public static void main(String[] args) 
	{
		String s1 = "10";

		Integer obj1 = new Integer(s1);      //boxing
		Integer obj2 =  Integer.valueOf(s1);//boxing
		int j = obj1.intValue(); //un-boxing
		int k = obj2.intValue();//un-boxing
		System.out.println(k);
		System.out.println(j);
		System.out.println("done");
	}
}
//storing primitive inside a object is boxing 
//retriving a value from the reference of the wrapper class is called as unboxing 