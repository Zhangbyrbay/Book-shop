package Java_Project;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(); // Store object to manage the available books
        Cart cart = new Cart(); // Cart object to manage the user's shopping cart

        while (true)
        {
            System.out.println("\nOptions:");
            System.out.println("1. View available books");
            System.out.println("2. View cart");
            System.out.println("3. Add books to cart");
            System.out.println("4. Remove books from cart");
            System.out.println("5. Search for a book");
            System.out.println("6. Checkout and exit");
            System.out.print("Choose an option: ");

            String temp = scanner.next();
            int choice = 0;

            // Validate user input to ensure it's a valid number
            for (int i = 0; i < temp.length(); i++)
            {
                if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9') {
                    choice *= 10;
                    choice += ((int) (temp.charAt(i))) - 48;
                }
                else
                {
                    choice = -1;
                    break;
                }
            }

            scanner.nextLine(); // Consume the newline character

            switch (choice)
            {
                case 1:
                    store.displayBooks(); // Display all available books
                    break;

                case 2:
                    cart.displayCart(); // Display the books in the cart
                    break;

                case 3:
                    store.displayBooks(); // Show available books
                    System.out.print("Enter the book numbers to add to the cart: ");
                    String t = scanner.nextLine();
                    int bookNumber = 0;
                    int count = 0;
                    t += " ";
                    for (int i = 0; i < t.length(); i++)
                    {
                        if (t.charAt(i) >= '0' && t.charAt(i) <= '9')
                        {
                            bookNumber *= 10;
                            bookNumber += ((int) (t.charAt(i))) - 48;
                        }
                        else
                        {
                            Book selectedBook = store.getBook(bookNumber);
                            if (selectedBook != null)
                            {
                                cart.addBook(selectedBook); // Add book to cart
                            }
                            bookNumber = 0;
                            count++;
                        }
                    }
                    if (count > 1) System.out.println("Books added to your cart.");
                    else if (count == 1) System.out.println("Book added to your cart.");
                    else System.out.println("No book has been added to the cart");
                    break;

                case 4:
                    cart.displayCart(); // Show books in cart
                    System.out.print("Enter the book numbers to remove from cart: ");
                    String tt = scanner.nextLine();
                    int removeNumber = 0;
                    int removedCount = 0;
                    tt += " ";
                    for (int i = 0; i < tt.length(); i++)
                    {
                        if (tt.charAt(i) >= '0' && tt.charAt(i) <= '9')
                        {
                            removeNumber *= 10;
                            removeNumber += ((int) (tt.charAt(i))) - 48;
                        }
                        else
                        {
                            cart.removeBook(removeNumber); // Remove book from cart
                            removeNumber = 0;
                            removedCount++;
                        }
                    }
                    if (removedCount > 1) System.out.println("Books removed from your cart.");
                    else if (removedCount == 1) System.out.println("Book removed from your cart.");
                    else System.out.println("No book has been deleted from your cart.");
                    cart.replace(); // Rearrange cart after removal
                    break;

                case 5:
                    System.out.print("Enter a keyword to search for a book: ");
                    String keyword = scanner.nextLine();
                    store.searchBooks(keyword); // Search books by keyword
                    break;

                case 6:
                    System.out.println("Thank you for shopping with us!");
                    System.out.printf("Your total is: %.2f USD\n", cart.getTotalPrice());
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
