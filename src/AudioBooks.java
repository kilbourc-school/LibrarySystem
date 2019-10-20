/*
     * This is a class for book objects, which have unique
     * attributes like titles, authors, physical states,
     * and availibility.
     */

    public class AudioBooks extends Media implements Medium{
        private int ISBN;


/*
 * Constructor.
 * Params: Strings ISBN, title, author, genre.
 */
public AudioBooks(String title,String description,String author,String subject,int copies,String genre,int releaseYear,int stars,boolean comingSoon,int iSBN){

        this.title=title;
        this.description=description;
        this.author=author;
        this.subject=subject;
        this.copies=copies;
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.stars=stars;
        this.comingSoon=comingSoon;
        this.ISBN=iSBN;
        }

public int getISBN(){
        return ISBN;
        }


        public String toStringList(){
            return "AudioBooks,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + ISBN;
        }
@Override
//Converts object to String.
public String toString(){
        return title+" by: "+author+" genre: "+genre+" ISBN: "+ISBN+" copies: "+copies;
        }
        }

