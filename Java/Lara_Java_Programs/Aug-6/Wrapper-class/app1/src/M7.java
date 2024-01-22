class M7
{
	public static void main(String[] args) 
	{
		String s1 = "true";
		Boolean obj1 = new Boolean(s1);      //boxing
		Boolean obj2 =  Boolean.valueOf(s1);//boxing
		boolean j = obj1.booleanValue(); //un-boxing
		boolean k = obj2.booleanValue();//un-boxing
		System.out.println(k);
		System.out.println(j);
		System.out.println("done");
	}
}
