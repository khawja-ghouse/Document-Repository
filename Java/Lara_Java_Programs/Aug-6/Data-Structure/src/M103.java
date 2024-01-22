import java.util.Arrays;
class Node
{
	int data;
	Node ref;

	Node(int data)
	{
		this.data = data;
	}
}

class LinkedList
{
	Node first,last;

	void add(int data)
	{
		if (first == null)
		{
			first = new Node(data);
			last = first;
		}
		else
		{
			last.ref = new Node(data);
			last = last.ref;
		}
	}

	void read()
	{
		Node element = first;
		while (element != null)
		{
			System.out.println(element.data+", ");
			element = element.ref;
		}
	}

	int size()
	{
		int count = 0;
		Node element = first;
		while (element != null)
		{
			count++;
			element = element.ref;
		}
		//System.out.println("the size of the DS is::"+count);
		return count;
	}

	boolean contains(int data)
	{
		boolean status = false;
		Node element = first;
		while (element != null)
		{
			if (data == element.data)
			{
				status = true;
				break;
			}
			element = element.ref;
		}
		return status;
	}

	int  order(int size,int data)
	{
		int[] x = new int[size];
		int  i = 0;
		Node element = first;
		while (element != null)
		{
			x[i] = element.data;
			element = element.ref;
			i++;
		}
		System.out.println(Arrays.toString(x));
		for (int j = 0;j < x.length ;j++ )
		{
			if (x[j] == data)
			{
				return j + 1;
			}
		}
		return -1;
	}
}


class M103
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
		list.size();
		
		System.out.println(list.contains(40));
		int x = list.order(list.size(),3);
		System.out.println("the index of the element is::"+x);
	}
}