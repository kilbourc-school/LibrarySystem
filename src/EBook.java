public class EBook extends Media implements Medium {
        String narrator;
        /*
         * Constructor.
         * Params: Strings ISBN, title, author, genre.
         */
        public EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator){
            super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
            this.narrator = narrator;
        }

        public String getOrator() {
            return narrator;
        }

        public String toStringList(){
            return "EBook,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + narrator;
        }

        @Override
        //Converts object to String.
        public String toString(){
            return title + " by: " + author + " genre: " + genre + " narrator: " + narrator + " copies: " + copies;
        }


    }
