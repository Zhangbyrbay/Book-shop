package Java_Project;

public class Cart
{
    private Book[] books; // Array to store the books in the cart
    private int[] quantities; // Array to store the quantity of each book in the cart
    private int count; // Keeps track of the total number of unique books in the cart

    public Cart()
    {
        this.books = new Book[20000];
        this.quantities = new int[20000];
        this.count = 0;
    }

    // Method to add a book to the cart
    public void addBook(Book book)
    {
        int existingIndex = findBook(book); // Check if the book already exists in the cart
        if (existingIndex != -1)
        {
            quantities[existingIndex]++; // Increment the quantity if the book is already in the cart
        }
        else if (count < books.length)
        {
            books[count] = book; // Add the new book to the cart
            quantities[count] = 1; // Set the initial quantity to 1
            count++; // Increase the count of unique books
        }
        else
        {
            System.out.println("Your cart is full. Remove some items before adding more."); // Notify user if cart is full
        }
    }

    // Method to remove a book from the cart based on its index (1-based)
    public void removeBook(int index)
    {
        if (index >= 1 && index <= count) // Validate the index
        {
            int actualIndex = index - 1; // Convert 1-based index to 0-based
            if (quantities[actualIndex] > 1)
            {
                quantities[actualIndex]--; // Decrease the quantity if more than one exists
            }
            else
            {
                books[actualIndex] = null; // Remove the book from the cart
                quantities[actualIndex] = 0; // Set the quantity to 0
            }
        }
    }

    // Method to rearrange the cart after removing a book
    public void replace()
    {
        for (int i = 0; i < count; i++)
        {
            if (books[i] == null) // Check if there is an empty slot
            {
                for (int j = i + 1; j < count; j++)
                {
                    if (books[j] != null) // Find the next non-empty slot and move it to an empty cell
                    {
                        books[i] = books[j];
                        books[j] = null;
                        quantities[i] = quantities[j];
                        quantities[j] = 0;
                        break;
                    }
                }
            }
        }
        // Adjust the count to reflect the current number of unique books
        for (int i = 0; i < count; i++)
        {
            if (books[i] == null)
            {
                count = i;
                return;
            }
        }
    }

    // Method to find a book in the cart by comparing its title and author
    private int findBook(Book book)
    {
        for (int i = 0; i < count; i++)
        {
            if (books[i].getTitle().equals(book.getTitle()) && books[i].getAuthor().equals(book.getAuthor()))
            {
                return i; // Return the index if the book is found
            }
        }
        return -1; // Return -1 if the book is not found
    }

    // Method to calculate the total price of all books in the cart
    public double getTotalPrice()
    {
        double total = 0;
        for (int i = 0; i < count; i++)
        {
            total += books[i].getPrice() * quantities[i]; // Sum the price * quantity for each book
        }
        return total; // Return the total price
    }

    // Method to display the contents of the cart
    public void displayCart()
    {
        if (count == 0)
        {
            System.out.println("Your cart is empty."); // Notify if the cart is empty
        }
        else
        {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-40s | %-20s | %-8s | %-5s | %-9s |\n",
                    "No.", "Title", "Author", "Price", "Qty", "Category");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < count; i++)
            {
                System.out.printf("| %-3d | %-40s | %-20s | %-8.2f | %-5d | %-9s |\n",
                        (i + 1), books[i].getTitle(), books[i].getAuthor(), books[i].getPrice(),
                        quantities[i], books[i].getCategory());
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.printf("Total price: %.2f USD\n", getTotalPrice()); // Display the total price
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }
}