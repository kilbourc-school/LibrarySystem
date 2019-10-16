package csce247.LibraryCatalogSystem;

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
  public Book(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN){

    title = title;
    description = description;
    author = author;
    subject = subject;
    copies = copies;
    genre = genre;
    releaseYear = releaseYear;
    stars = stars;
    comingSoon = comingSoon;
    ISBN = iSBN;
  }

  public int getISBN() {
    return ISBN;
  }

  //Modifier method to mark book as unavailible.
  public void makeBorrowed(){
    if (copies < 1){
      System.out.println("No copies for you to checkout.");
    }
    else{
      copies--;
    }
  }
  
  //Modifier method to mark a book as availible.
  public void makeReturned(){
    copies++;
  }
  

  //Accessor for title.
  public Boolean getAvailability(){
    if (copies < 1){
      return false;
    }
    return true;
  }
  
  public String toStringList(){
    return title + ", " + description +  ", " + author +  ", " + subject +  ", " + copies + ", " + genre + ", " + releaseYear + ", " + stars + ", " +comingSoon + ", " + ISBN;
  }

  @Override
  //Converts object to String.
  public String toString(){
    return title + " by: " + author + "; " + "genre: " + genre + ", ISBN: " + ISBN + ", copies: " + copies;
  }


  }
