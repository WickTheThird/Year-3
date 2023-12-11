package InterfaceSegregation;

/*
 * The interface segregation principle states that a client should not be forced to implement an interface that it doesn't use.
 * 
 * Let's say that we have a interface called Library, that provides the basic utilities for how to rent an object from a library.
 * The interface will talk about how many days you are allowed to have a copy, how much you have to pay if you are late, etc.
 * 
 * But what if i have a DVD player...or an cassete disk...suddenly now all properties of the Library interface are applicable.
 * 
 * Thus the ISP states that we, instead of having a giant interface that covers everything and some of its methods are not applicable,
 * we should split the interface into multiple interfaces that satisfy the systems.
 */

 import java.util.*;

//> Program

public class InterfaceSegregation_Good {
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

interface Borrowable extends LibraryItems {
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

interface iAudioBooks extends Borrowable {
    public ArrayList<ArrayList<String>> audioBooks = new ArrayList<ArrayList<String>>();

    default void filterAudioBooks() {
        filterItems(ItemType.AudioBook);
    }
}

interface iDVDs extends Borrowable {
    public ArrayList<ArrayList<String>> DVDs = new ArrayList<ArrayList<String>>();

    default void filterDVDs() {
        filterItems(ItemType.DVD);
    }
}

interface iBooks extends Borrowable {
    public ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();

    default void filterBooks() {
        filterItems(ItemType.Book);
    }
}


class Book implements iBooks {

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
        filterBooks();
        for (ArrayList<String> book : books) {
            if (book.get(0).equals(title) && book.get(1).equals(author)) {
                checkIn(book);
                break;
            }
        }
    }

}

class AudioBooks implements iAudioBooks {

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
        filterAudioBooks();
        for (ArrayList<String> book : audioBooks) {
            if (book.get(0).equals(title) && book.get(1).equals(author)) {
                checkIn(book);
                break;
            }
        }
    }

}

class DVD implements iDVDs {

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
        filterDVDs();
        for (ArrayList<String> DVD : DVDs) {
            if (DVD.get(0).equals(title) && DVD.get(1).equals(author)) {
                checkIn(DVD);
                break;
            }
        }
    }

}

