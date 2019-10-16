

public class Media {
    String title;
    String description;
    String author;
    String subject;
    int copies;
    String genre;
    int releaseYear;
    int stars;
    boolean comingSoon;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public int getCopies() {
        return copies;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getStars() {
        return stars;
    }

    public boolean isComingSoon() {
        return comingSoon;
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

    //Modifier method to mark a media as availible.
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
}
