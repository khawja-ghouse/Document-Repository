class M6 
{
	public static void main(String[] args) 
	{
		String s1 = "10.1";
		Double obj1 = new Double(s1);      //boxing
		Double obj2 =  Double.valueOf(s1);//boxing
		double j = obj1.doubleValue(); //un-boxing
		double k = obj2.doubleValue();//un-boxing
		System.out.println(k);
		System.out.println(j);
		System.out.println("done");
	}
}
