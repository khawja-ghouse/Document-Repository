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
	Node first;

	void add(int data)
	{
		if (first == null)
		{
			first = new Node(data);
		}
		else
		{
			Node newNode = new Node(data);
			newNode.next = first;
			first = newNode;
		}
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


class M17
{
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.add(21);
		list.add(10);
		list.add(40);
		list.add(35);
		list.read();
	}
}