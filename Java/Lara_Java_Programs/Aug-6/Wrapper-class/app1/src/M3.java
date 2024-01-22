class M3 
{
	public static void main(String[] args) 
	{
		//char i = 10;
		Character obj1 = new Character('a');      //boxing
		Character obj2 =  Character.valueOf('a');//boxing
		char j = obj1.charValue(); //un-boxing
		char k = obj2.charValue();//un-boxing
		System.out.println(k);
		System.out.println(j);
		System.out.println("done");
	}
}
//storing primitive inside a object is boxing 
//retriving a value from the reference of the wrapper class is called as unboxing 