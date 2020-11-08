package app;

public class Library {

    public static void main(String[] args) {
                
        // Create a book list object.
	BookList books = new BookList();

	// Create booknodes and add them to the list.
		
	long startTime = System.nanoTime();
		
	for (int i = 1; i <=1000000; i ++)
	{
            books.add( new Book("Danger on the Waters"));
            books.add( new Book("Paradise Lost"));
            books.add( new Book("Building Bridges"));
            books.add( new Book("Hall Mark of Fame"));
	}
		
        long finish = System.nanoTime();
	System.out.println("Time elapse when unbuffered "  + (finish - startTime)/1000000 + " msec");
	//System.out.println(books);
    }
    
}
