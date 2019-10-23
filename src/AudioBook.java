/*
     * This is a class for book objects, which have unique
     * attributes like titles, authors, physical states,
     * and availibility.
     */

    public class AudioBook extends Media implements Medium{
        private int ISBN;


/*
 * Constructor.
 * Params: Strings ISBN, title, author, genre.
 */
public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN){
super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
        this.ISBN=iSBN;
        }

public int getISBN(){
        return ISBN;
        }


        public String toStringList(){
            return "AudioBook,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + ISBN;
        }

@Override
//Converts object to String.
public String toString(){
        return title+" by: "+author+" genre: "+genre+" ISBN: "+ISBN+" copies: "+copies;
        }
        }

