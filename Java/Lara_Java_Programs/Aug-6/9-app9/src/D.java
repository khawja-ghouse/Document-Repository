class D

{
	public static void main(String[] args) 
	{
		int i = 20;
		int j = 40;
		int k = i > 10 ? (j < 40 ? 1: 2) : (j > 40 ? 3:4);
		System.out.println(k);
	}
}
