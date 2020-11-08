
package app;

public class BookList {
    
    	private BookNode list;
	// 9685
//	LinkedList <BookNode>list;

	BookList() // This constructor creates an empty list.
	{
		list = null; //new LinkedList<BookNode>();
	}

	void add(Book b)// pre-pending
	{
		BookNode temp = new BookNode(b);
	
		try
		{
		//	list.add(0, temp);
		temp.next = list;
			list = temp;
		}
		catch(NullPointerException e)
		{

		}
	}
/*
	public String toString()
	{
		String result = "";
		BookNode current = list;

		while (current != null)
		{
			result += current.book.getTitle() + ",  ";
			current = current.next;
		}
		return result;
	}*/
    
   
    
}
