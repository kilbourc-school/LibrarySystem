import java.util.Scanner;

public abstract class Media {
    Scanner keyboard = new Scanner(System.in);

    String title;
    String description;
    String author;
    String subject;
    int copies;
    String genre;
    int releaseYear;
    int stars;
    boolean comingSoon;

    Media(){
        setTitle();
        setDescription();
        setAuthor();
        setSubject();
        setCopies();
        setGenre();
        setReleaseYear();
        setStars();
        comingSoon = true;
    }
     /*
       Getters
        */

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }

    /*
           Setters
            */
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDescription(){
        System.out.print("Description: ");
        this.setDescription(keyboard.nextLine());
    }



    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAuthor(){
        System.out.print("Author: ");
        this.setAuthor(keyboard.nextLine());
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTitle() {
        System.out.print("Title: ");
        this.setTitle(keyboard.nextLine());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setSubject() {
        System.out.print("Subject: ");
        this.setSubject(keyboard.nextLine());
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        int x = 1;
        try {
            x = Integer.parseInt(copies);
        } catch (Exception e) {
            System.out.println("Input not of type int, copies set to 1");
        }
        this.copies = x;
    }
    public void setCopies(){
        System.out.print("Number of Copies: ");
        this.setCopies(keyboard.nextLine());
    }


    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setGenre(){
        System.out.print("Genre: ");
        this.setGenre(keyboard.nextLine());}

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        int x = 0;
        try {
            x = Integer.parseInt(releaseYear);
        } catch (Exception e) {
            System.out.println("Input not of type int, year set to 0");
        }
        this.releaseYear = x;
    }
    public void setReleaseYear(){
        System.out.print("Release Year: ");
        this.setReleaseYear(keyboard.nextLine());
    }

    public int getStars() {
        return stars;
    }

    public void setStars(String stars) {
        int x = 0;
        try {
            x = Integer.parseInt(stars);
        } catch (Exception e) {
            System.out.println("Input not of type int, stars set to 0");
        }
        this.stars = x;
    }
    public void setStars(){
        System.out.print("Rating: ");
        this.setStars(keyboard.nextLine());
    }

    //Modifier method to mark book as unavailable.
    public void makeBorrowed() {
        if (copies < 1) {
            System.out.println("No copies for you to checkout.");
        } else {
            copies--;
        }
    }

    //Modifier method to mark a media as availible.
    public void makeReturned() {
        copies++;
    }


    //Accessor for title.
    public Boolean getAvailability() {
        return copies >= 1;
    }

    public String toStringList(){ return " ";}
}
