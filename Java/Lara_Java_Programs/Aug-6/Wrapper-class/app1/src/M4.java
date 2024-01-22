class M4 
{
	public static void main(String[] args) 
	{
		boolean flag = false;
		Boolean obj1 = new Boolean(flag);      //boxing
		Boolean obj2 =  Boolean.valueOf(flag);//boxing
		boolean j = obj1.booleanValue(); //un-boxing
		boolean k = obj2.booleanValue();//un-boxing
		System.out.println(k);
		System.out.println(j);
		System.out.println("done");
	}
}
//storing primitive inside a object is boxing 
//retriving a value from the reference of the wrapper class is called as unboxing 