//Queue implementation
class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
	}
}

class LinkedList
{
	Node first,last,prev;

	void add(int data)
	{
		if (first == null)
		{
			first = new Node(data);
			last = first;
		}
		else
		{
			last.next = new Node(data);
			prev = last;
			last = last.next;
		}
	}

	int  readFirst()
	{
		if (first == null)
		{
			//throw exception
		}	
		return first.data;
	}
	void removeFirst()
	{
		if (first == null)
		{
			return;
		}
		
		if (first.next == null)
		{
			first = last = null;
		}
		first = first.next;
	}
	void read()
	{
		Node element = first;
		while (element != null)
		{
			System.out.println(element.data+", ");
			element = element.next;
		}
	}
}


class M19
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		//list.readTop();
		list.read();
		System.out.println();
		list.removeFirst();
		list.read();

	}
}