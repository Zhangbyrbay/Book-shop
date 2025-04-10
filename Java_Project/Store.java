package Java_Project;

public class Store
{
    private Book[] availableBooks; // Array to store the available books in the store

    // Constructor to initialize the store and populate it with initial books
    public Store()
    {
        this.availableBooks = new Book[20000];

        // Add some predefined books to the store
        availableBooks[0] = new ChildrenBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 10.99);
        availableBooks[1] = new TeenBook("The Hunger Games", "Suzanne Collins", 8.99);
        availableBooks[2] = new AdultBook("The Great Gatsby", "F. Scott Fitzgerald", 12.99);
        availableBooks[3] = new AdultBook("1984", "George Orwell", 9.99);
        availableBooks[4] = new ChildrenBook("Charlie and the Chocolate Factory", "Roald Dahl", 6.99);
    }

    // Method to display all available books in a tabular format
    public void displayBooks()
    {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-40s | %-20s | %-8s | %-9s |\n", "No.", "Title", "Author", "Price", "Category");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i = 0; i < availableBooks.length; i++)
        {
            // Check if the book at the current index is not null
            if (availableBooks[i] != null)
            {
                // Print the book details in a formatted way
                System.out.printf("| %-3d | %-40s | %-20s | %-8.2f | %-9s |\n",
                        (i + 1), availableBooks[i].getTitle(), availableBooks[i].getAuthor(),
                        availableBooks[i].getPrice(), availableBooks[i].getCategory());
            }
        }

        System.out.println("------------------------------------------------------------------------------------------------");
    }

    // Method to get a specific book by its index
    public Book getBook(int index)
    {
        // Validate the index and check if a book exists at that position
        if (index >= 1 && index <= availableBooks.length && availableBooks[index - 1] != null)
        {
            return availableBooks[index - 1]; // Return the book if found
        }
        return null; // Return null if the index is invalid or no book exists
    }

    // Method to search for books based on a keyword (title or author)
    public void searchBooks(String keyword)
    {
        System.out.println("Search Results:");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-40s | %-20s | %-8s | %-9s |\n", "No.", "Title", "Author", "Price", "Category");
        System.out.println("-----------------------------------------------------------------------------------------------");

        boolean found = false; // Flag to track if any book matches the search keyword

        for (int i = 0; i < availableBooks.length; i++)
        {
            // Check if the current book is not null and matches the keyword in title or author
            if (availableBooks[i] != null &&
                    (availableBooks[i].getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                            availableBooks[i].getAuthor().toLowerCase().contains(keyword.toLowerCase())))
            {
                // Print the matching book details
                System.out.printf("| %-3d | %-40s | %-20s | %-8.2f | %-9s |\n",
                        (i + 1), availableBooks[i].getTitle(), availableBooks[i].getAuthor(),
                        availableBooks[i].getPrice(), availableBooks[i].getCategory());
                found = true; // Set the flag to true
            }
        }

        if (!found)
        {
            // If no books were found, display a message
            System.out.println("No books found matching the keyword.");
        }

        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}