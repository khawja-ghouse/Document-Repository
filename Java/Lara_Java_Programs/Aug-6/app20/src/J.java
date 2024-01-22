class J
{
	int i;
	public static void main(String[] args) 
	{
		J j1 = new J();
		System.out.println("a:"+j1.i);	
		J j2 = j1;
		j1.i = 10;
		System.out.println("b:"+j1.i);
		System.out.println("c:"+j2.i);
		J j3 = j2;
		j3.i += 10;
		System.out.println("d:"+j1.i);
		System.out.println("e:"+j2.i);
		System.out.println("f:"+j3.i);
			
	}
}
