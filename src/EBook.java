public class EBook extends Book{

    EBook(){super();}
    EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN){
        super(title,description, author,subject,copies,genre,releaseYear, stars,comingSoon,ISBN);
    }
   @Override
    public String toStringList() {
        return "EBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + ISBN;
    }
}
