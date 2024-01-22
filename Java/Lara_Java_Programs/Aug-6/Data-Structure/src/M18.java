//Stack implementation
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

	void readTop()
	{
		Node element = last;
		System.out.println(element.data);
	}
	void Remove()
	{
		if (first == null)
		{
			return;
		}
		Node element = first;
		if (element.next == null)
		{
			first = last = null;
			return;
		}
		while (element.next != last)
		{
			element = element.next;
		}
		element.next = null;
		last = element;
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


class M18
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
		list.Remove();
		list.read();

	}
}