class Book {
    String title;
    boolean borrowed;

    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
    }

    public void borrow() {
        borrowed = true;
    }
    public void returned() {
        borrowed = false;
    }

    public Boolean isBorrowed() {
        return borrowed;
    }
    public String getTitle() {
        return title;
    }

    public static void main(String[] arguments) {
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title: " + example.getTitle());
        System.out.println("Borrowed?: " + example.isBorrowed());
        example.borrow();
        System.out.println("Borrowed?: " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed?: " + example.isBorrowed());
    }
}
