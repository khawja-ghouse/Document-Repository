import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
class A 
{
	int i,j ;
	A(int i,int j)
	{
		this.i = i;
		this.j = j;
	}
	public String toString()
	{

	return "(" + i + "," + j + ")";
	}
}
class M73
{

	public static void main(String[] args) 
   {
		ArrayList<A> list =  new ArrayList<>();
		list.add(new A(900,10));
		list.add(new A(10,20));
		list.add(new A(910,39));
		list.add(new A(9,54));
		list.add(new A(90,20));
		System.out.println(list);
		Collections.sort(list, (A a1 , A a2) -> a1.i - a2.i);	
		System.out.println(list);
		Collections.sort(list, (A a1 , A a2) -> a1.j - a2.j);	
	   System.out.println(list);
	}

}