

public abstract class Media {
    String title;
    String description;
    String author;
    String subject;
    int copies;
    String genre;
    int releaseYear;
    int stars;
    boolean comingSoon;

    public Media(){}

    public Media(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon){
        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.copies = copies;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stars = stars;
        this.comingSoon = comingSoon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setComingSoon(boolean comingSoon) {
        this.comingSoon = comingSoon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

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
    //Modifier method to mark book as unavailable.
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
        return copies >= 1;
    }

    public abstract String toStringList();
}
