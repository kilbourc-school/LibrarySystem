
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

    this.title = title;
    this.description = description;
    this.author = author;
    this.subject = subject;
    this.copies = copies;
    this.genre = genre;
    this.releaseYear = releaseYear;
    this.stars = stars;
    this.comingSoon = comingSoon;
    this.ISBN = ISBN;
  }


  public int getISBN() {
    return ISBN;
  }



  public String toStringList(){
    return "book,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + ISBN;
  }

  @Override
  //Converts object to String.
  public String toString(){
    return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
  }


  }
