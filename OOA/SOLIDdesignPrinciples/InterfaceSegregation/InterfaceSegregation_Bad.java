package InterfaceSegregation;

/*
 * The reason this violates ISP is because the interfaces are not separated but rather merged, perhaps to piss off ISP.
 */

 import java.util.*;

//> Program

public class InterfaceSegregation_Bad {
    public static void main(String[] args) {
        Book book = new Book();
        AudioBooks audioBook = new AudioBooks();
        DVD dvd = new DVD();

        book.borrowItem("Harry Potter", "J.K. Rowling");
        audioBook.borrowItem("Lord of the Rings", "J.R.R. Tolkien");
        dvd.borrowItem("The Godfather", "Francis Ford Coppola");
    }

}

//> Implementation (ik they should be in different files, but for sake of example i will place it here)

enum ItemType {
   Book,
   AudioBook,
   DVD
}

interface LibraryItems {
 public Map<ArrayList<String>, Boolean> items = new HashMap<ArrayList<String>, Boolean>();

 public void checkOut(ArrayList<String> item);
 public void checkIn(ArrayList<String> item);
 public void addItem(ArrayList<String> item);
 public void removeItem(ArrayList<String> item);
 public void updateItem(ArrayList<String> newItem, ArrayList<String> oldItem);
}

interface CheckOut {
   void checkOut(ArrayList<String> item);
}

interface CheckIn {
   void checkIn(ArrayList<String> item);
}

interface AddItem {
   void addItem(ArrayList<String> item);
}

interface RemoveItem {
   void removeItem(ArrayList<String> item);
}

interface UpdateItem {
   void updateItem(ArrayList<String> newItem, ArrayList<String> oldItem);
}

interface Borrowable extends CheckOut, CheckIn, AddItem, RemoveItem, UpdateItem {
   public ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
   public int daysAllowed = 3;
   public int lateFee = 20;

   public void borrowItem(String title, String author);

   default void filterItems(ItemType itemType) {
       items.clear();
       for (Map.Entry<ArrayList<String>, Boolean> entry : LibraryItems.items.entrySet()) {
           if (entry.getKey().get(3).equals(itemType.toString()) && entry.getValue()) {
               items.add(entry.getKey());
           }
       }
   }
}


class Book implements Borrowable {

    public void checkOut(ArrayList<String> book) {
        //> Once the book is returned it should be added back to the library items...meaning turning the false boolean for the book into true
        

    }

    public void checkIn(ArrayList<String> book) {
        //> Once a book has been borrowed we need to turn the boolean for the book into false
        LibraryItems.items.put(book, false);
    }

    public void addItem(ArrayList<String> book) {
        //> new entries
        LibraryItems.items.put(book, true);
    }

    public void removeItem(ArrayList<String> book) {
        //> remove entries
        LibraryItems.items.remove(book);
    }

    public void updateItem(ArrayList<String> newBook, ArrayList<String> oldBook) {
        //> update entries
        LibraryItems.items.remove(oldBook);
        LibraryItems.items.put(newBook, true);
    }

    public void borrowItem(String title, String author) {
        filterItems(ItemType.Book);
        for (ArrayList<String> book : items) {
            if (book.get(0).equals(title) && book.get(1).equals(author)) {
                checkIn(book);
                break;
            }
        }
    }

}

class AudioBooks implements Borrowable {

    public void checkOut(ArrayList<String> book) {
        LibraryItems.items.put(book, false);
    }

    public void checkIn(ArrayList<String> book) {
        LibraryItems.items.put(book, true);
    }

    public void addItem(ArrayList<String> book) {
        LibraryItems.items.put(book, true);
    }

    public void removeItem(ArrayList<String> book) {
        LibraryItems.items.remove(book);
    }

    public void updateItem(ArrayList<String> oldBook, ArrayList<String> newBook) {
        LibraryItems.items.remove(oldBook);
        LibraryItems.items.put(newBook, true);
    }

    public void borrowItem(String title, String author) {
        filterItems(ItemType.AudioBook);
        for (ArrayList<String> book : items) {
            if (book.get(0).equals(title) && book.get(1).equals(author)) {
                checkIn(book);
                break;
            }
        }
    }

}

class DVD implements Borrowable {

    public void checkOut(ArrayList<String> DVD) {
        LibraryItems.items.put(DVD, true);
    }

    public void checkIn(ArrayList<String> DVD) {
        LibraryItems.items.put(DVD, false);
    }

    public void addItem(ArrayList<String> DVD) {
        LibraryItems.items.put(DVD, true);
    }

    public void removeItem(ArrayList<String> DVD) {
        LibraryItems.items.remove(DVD);
    }

    public void updateItem(ArrayList<String> oldDVD, ArrayList<String> newDVD) {
        LibraryItems.items.remove(oldDVD);
        LibraryItems.items.put(newDVD, true);
    }

    public void borrowItem(String title, String author) {
        filterItems(ItemType.DVD);
        for (ArrayList<String> book : items) {
            if (book.get(0).equals(title) && book.get(1).equals(author)) {
                checkIn(book);
                break;
            }
        }
    }

}

