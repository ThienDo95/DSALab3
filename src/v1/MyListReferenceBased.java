package v1;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status: Complete and thouroughly tested
 * Last update: 02/08/2017
 * Submitted: 02/09/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.09
 */
public class MyListReferenceBased implements ListInterface 
{
	private Node head;
	
	public MyListReferenceBased()
	{
		head=null;
	}
	
	public MyListReferenceBased(Node head)
	{
		this.head = head;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}


	public int size()
	{
		int size = 0;
		
		for(Node curr = head; curr != null; curr = curr.getNext())
		{
			size++;
		}
		
		return size;
	}


	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < size() + 1) 
		{
			if (index == 0) 
			{
				Node newNode = new Node(item, head);
				head = newNode;
			} 
			else 
			{
				Node prev = find(index-1);
				Node newNode = new Node(item, prev.getNext());
				prev.setNext(newNode);
			} 
		} 
		else 
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		}
	}


	private Node find(int index)
	{
		Node curr = head;
		for (int skip = 0; skip < index; skip++)
		{
			curr = curr.getNext();
		}
		return curr;
	}

	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		
		if (index >= 0 && index < size())
		{
			Node curr = find(index);
			Object dataItem = curr.getItem();
			return dataItem;
		}
		else 
		{
			throw new ListIndexOutOfBoundsException( "List index out of bounds exception on get");
		} 
	}


	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < size())
		{
			if ( index == 0)
			{
				head = head.getNext();
			}
			else
			{
				Node prev = find(index - 1);
				Node curr = prev.getNext();
				prev.setNext(curr.getNext());
			}
		}
		
	}


	public void removeAll()
	{
		head = null;
	}
	
	public String toString()
	{
		String s = "";
		
		for(Node curr = head; curr != null; curr = curr.getNext())
		{
			s += curr.getItem() + " ";
		}
		return s;
	}
}
