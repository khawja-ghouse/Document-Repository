class I
{
	int x;
	public static void main(String[] args) 
	{
		I ref1 = new I();
		I ref2 = ref1;
		ref1.x=10;
		System.out.println(ref2.x);		
		ref2.x=20;
		System.out.println(ref1.x);		
	}
}
