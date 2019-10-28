
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

public class Book extends Media implements Medium {
  int ISBN;
  /* 
   * Constructor. 
   * Params: Strings ISBN, title, author, genre.
   */ 
  public Book(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN){
    super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
    this.ISBN = ISBN;
  }

  /*
   returns ISBN value
   */
  public int getISBN() {
    return ISBN;
  }
  /*
  converts objects into strings
   */
  public String toStringList(){
    return "Book,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + ISBN;
  }

  @Override
  /*
  converts objects
   */
  public String toString(){
    return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
  }


  }
