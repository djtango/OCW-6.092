class Library {
    String address;
    ArrayList<Book> books;

    static final String openingTimes = "9 AM to 5 PM daily.";

    public Library(String libraryAddress) {
        address = libraryAddress;
        books = new ArrayList<Book>();
    }

    public static void printOpeningHours() {
        System.out.println(Library.openingTimes);
    }
    public void printAddress() {
        System.out.println(address);
    }

    public void addBook(Book book) {
        books.add(book);
    }
    private Boolean isLibraryStocked() {
        return books.size() > 0;
    }
    public void printAvailableBooks() {
        if(isLibraryStocked()){
            int i;
            for (i=0;i<books.size();i++) {
                Book currentBook = books.get(i);
                if (!currentBook.isBorrowed()){
                    System.out.println(books.get(i).getTitle());
                }
            }
        } else {
            System.out.println("Apologies, this library does not have any books yet.");
        }
    }
    private int searchFor(String bookTitle) {
        int i;
        int bookIndex = -1;
        for (i=0;i<books.size();i++) {
            if (books.get(i).getTitle() == bookTitle) {
                bookIndex = i;
                return bookIndex;
            }
        }
        return bookIndex;
    }
    private Boolean isBookFound(int bookIndex) {
        return bookIndex >= 0;
    }
    private void checkout(Book book) {
        if(!book.isBorrowed()) {
            book.borrow();
            System.out.println(book.getTitle() + " has been checked out.");
        } else {
            System.out.println("I'm sorry, " + book.getTitle() + " is unavailable at this point in time.");
        }
    }

    public void borrowBook(String bookTitle) {
        int bookIndex = searchFor(bookTitle);
        if(isBookFound(bookIndex)) {
            Book book = books.get(bookIndex);
            checkout(book);
        } else {
            System.out.println("I'm sorry we do not have that book in this Library");
        }

    }

    private void checkin(Book book) {
        if (book.isBorrowed()) {
            book.returned();
            System.out.println(book.getTitle() + " has been checked in.");
        } else {
            System.out.println("This book is already checked in.");
        }
    }
    public void returnBook(String bookTitle) {
        int bookIndex = searchFor(bookTitle);
        if(isBookFound(bookIndex)) {
            Book book = books.get(bookIndex);
            checkin(book);
        } else {
            System.out.println("I'm sorry we do not have that book in this Library");
        }
    }

    public static void main(String[] args) {
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
