class K 
{
	static int x;
	public static void main(String[] args) 
	{
	 	System.out.println(x);
		System.out.println(K.x);
		K k1 = new K();
		System.out.println(k1.x);//we are allowed to use static variable from refrence value ,
		//compiler converts System.out.println(K.x) replaces the k1 --> K
	}
}
