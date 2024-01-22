class A < X >
{
	X obj;
}
class M34 
{
	public static void main(String[] args) 
	{
		A< ? > a1 = null;	
		a1 = new A<Integer>();		
		
		a1.obj = 30;
		//CTE compiler is checking what is a1 rather where a1 is pointing 
		//what  a1 is ? a1 can be (String|Double|Byte....) then how can you assign integer 30
		//hence obj datatype cannot be decided
		/*
		if reference is a whildcard type then v cannot assign value to generic datatype like at Line no 10
		*/

		System.out.println("Hello...ADC");
	}
}
