public class EBook extends Media implements Medium {
        String orator;
        /*
         * Constructor.
         * Params: Strings ISBN, title, author, genre.
         */
        public EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String orator){

            this.title = title;
            this.description = description;
            this.author = author;
            this.subject = subject;
            this.copies = copies;
            this.genre = genre;
            this.releaseYear = releaseYear;
            this.stars = stars;
            this.comingSoon = comingSoon;
            this.orator = orator;
        }

        public String getOrator() {
            return orator;
        }

        public String toStringList(){
            return "ebook,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + "," + orator;
        }

        @Override
        //Converts object to String.
        public String toString(){
            return title + " by: " + author + " genre: " + genre + " orator: " + orator + " copies: " + copies;
        }


    }
