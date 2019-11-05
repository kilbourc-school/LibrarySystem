public class EBook extends Media implements Medium {

    private int ISBN;
    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator
       super: title, description, author, subject, copies, genre, releaseYear, stars, comingSoon (calls from borrower)
     */
    public EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN) {
        this.title = title;
        this.description=description;
        this.author=author;
        this.subject=subject;
        this.copies=copies;
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.stars=stars;
        this.comingSoon=comingSoon;
        this.ISBN = ISBN;

    }
    public EBook(){
        setTitle();
        setDescription();
        setAuthor();
        setSubject();
        setCopies();
        setGenre();
        setReleaseYear();
        setStars();
        comingSoon = true;
        setISBN();
    }

    /*
    Returns narrator string
     */
    public void setISBN(String ISBN) {
        int x = 0;
        try {
            x = Integer.parseInt(ISBN);
        } catch (Exception e) {
            System.out.println("Input not of type int, ISBN set to 0");
        }
        this.ISBN = x;
    }
    public void setISBN() {
        System.out.print("ISBN: ");
        this.setISBN(keyboard.nextLine());
    }
    /*
    Returns ISBN Value
     */
    public int getISBN() {
        return ISBN;
    }

    /*
    Converts objects into strings
     */
    public String toStringList() {
        return "EBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + ISBN;
    }

    @Override
    public boolean isComingSoon() {
        return false;
    }

    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }


}
