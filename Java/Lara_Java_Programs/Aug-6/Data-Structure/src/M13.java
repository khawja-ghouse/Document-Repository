//Circular linked list
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
			//last.ref = first;
		}
		else
		{
			last.ref = new Node(data);
			 last = last.ref;	 
		}
		last.ref = first;
	}

	void read()
	{
		Node element = first;
		if (element != null)
		{
			System.out.println(element.data+", ");
		}
		element = element.ref;
		while (element != null && (element != first))
		{
			System.out.println(element.data+", ");
				element = element.ref;
		}
		System.out.println();
	}
	String leftToRight(int data)
	{
		Node element = first,prev = first,next = element.ref;
		if (element  != null)
		{
			if (element.data == data)
			{
				//throw an Exception
				return last.data+","+next.data;
			}
			element = element.ref;
			next = element.ref;
		}
		while (element != null && (element != first))
		{
			if (element.data == data)
		 	{
				break;
			}
			prev = element;
			element = element.ref;
			next = element.ref;
		}
		return prev.data+","+next.data;
	}
	int leftTo(int data)
	{
		Node element = first,prev = first;
		if (element  != null)
		{
			if (element.data == data)
			{
				//throw an Exception
				return last.data;
			}
			element = element.ref;
		}
		while (element != null && (element != first))
		{
			if (element.data == data)
			{
				break;
			}
			prev = element;
			element = element.ref;
		}
		return prev.data;
	}

	void ReplaceFromTo(int data,int data2)
	{
		Node element = first,prev = first;
		if (element  != null)
		{
			if (element.data == data)
			{
				//throw an Exception
				element.data = data2;
			}
			element = element.ref;
		}
		while (element != null && (element != first))
		{
			if (element.data == data)
			{
				element.data = data2;
			}
			element = element.ref;
		}
	
	}
	void Remove(int data)
	{
		Node element = first,prev = first;
		if (element  != null)
		{
			if (element.data == data)
			{
				//throw an Exception
				//element.data = data2;
				first = first.ref;
				last.ref = first;
				return;
			}
			element = element.ref;
		}
		while (element != null && (element != first))
		{
			if (element.data == data)
			{
				prev.ref = element.ref;
				break;
			}
			prev = element;
			element = element.ref;

		}
	
	}
}


class M13
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
		System.out.println(list.leftTo(21));
		System.out.println(list.leftToRight(21));
		System.out.println(list.leftToRight(40));
		list.ReplaceFromTo(40,41);
		list.Remove(21);
		list.read();
	}
}