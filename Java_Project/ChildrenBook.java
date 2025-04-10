package Java_Project;

// A subclass of the Book class representing books for children
public class ChildrenBook extends Book
{
    // Constructor to initialize a Children's Book with title, author, and price
    public ChildrenBook(String title, String author, double price)
    {
        super(title, author, price); // Call the constructor of the superclass (Book) to set these properties
    }

    @Override
    public String getCategory()
    {
        return "Children"; // Always return "Children" as the category for books of this type
    }
}
