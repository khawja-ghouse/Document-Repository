import java.util.ArrayList;
import java.util.Collections;
class A implements Comparable <A>
{
	int i;
	A(int i)
	{
	  this.i = i;
	}
	public String toString()
	{
		return "I = :"+i;
	}
	public int compareTo(A obj)
	{
		return i - obj.i;
	}
}
class M70
{
	public static void main(String[] args) 
	{
		ArrayList<A> list = new ArrayList<>();
		
		list.add( new A(910));
		list.add( new A(901));
		list.add( new A(9110));
		list.add( new A(9230));
		System.out.println(list);
		Collections.sort(list);
	    System.out.println(list);
	}
}
