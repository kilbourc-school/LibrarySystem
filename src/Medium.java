public interface Medium {
    /*
    interface for all methods
     */
    void makeBorrowed();

    void makeReturned();

    Boolean getAvailability();

    String toString();

    String toStringList();

    String getTitle();

    String getDescription();

    String getAuthor();

    String getSubject();

    int getCopies();

    void setCopies(int copies);

    int getReleaseYear();

    int getStars();

    boolean isComingSoon();

    String getGenre();
}
