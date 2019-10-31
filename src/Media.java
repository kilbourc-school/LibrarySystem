import java.util.LinkedList;

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
    private LinkedList<Long> currentBorrowerID;
    private LinkedList<Long> waitListBorrowerIDs;


    public Media() {
    }

    public Media(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon) {
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

    public void checkOutBook(Media media, Long iD) {
        if (isAllCheckedOut(media)) {
            System.out.println("Sorry, book is currently checked out.");
            addToWaitListBorrowerIDs(iD);
        }
        else {
            currentBorrowerID.add(iD);
            copies--;
        }

    }

    public void setWaitListBorrowerIDs(LinkedList waitListBorrowerIDs) {
        this.waitListBorrowerIDs = waitListBorrowerIDs;
    }

    public void setCurrentBorrowerID(Long currentBorrowerID) {
        this.currentBorrowerID.add(currentBorrowerID);
    }

    public boolean isAllCheckedOut(Media media) {
       if (copies == 0)
          return true;
       else
           return false;

    }
public void checkInMedia(Media media, Long iD){
        media.currentBorrowerID.remove(iD);
        media.assignFromWaitList();
}
    private void assignFromWaitList() {
        if (waitListBorrowerIDs.peek() != null) {
            currentBorrowerID.add(waitListBorrowerIDs.pop());
        }
        else
            copies++;
    }

    public void addToWaitListBorrowerIDs(Long borrowerID) {
        if (waitListBorrowerIDs.size() <= 10) {
            this.waitListBorrowerIDs.add(borrowerID);
            System.out.println("you have been placed on the waitlist");
        } else
            System.out.println("wait list is full. you were not placed on the waitlist");
    }

    /*
       Getters
        */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

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

    public boolean isComingSoon() {
        return comingSoon;
    }

    public void setComingSoon(boolean comingSoon) {
        this.comingSoon = comingSoon;
    }

    //Modifier method to mark book as unavailable.
    public void makeBorrowed() {
        if (copies < 1) {
            System.out.println("No copies for you to checkout.");
        } else {
            copies--;
        }
    }

    //Modifier method to mark a media as available.
    public void makeReturned() {
        copies++;
    }


    //Accessor for title.
    public Boolean getAvailability() {
        return copies >= 1;
    }

    public String toStringList() {
        String wait = "";
        for (int i = 0; i < waitListBorrowerIDs.size(); i++) {
            wait = wait + waitListBorrowerIDs.pop();
        }
        if (wait.equals(""))
            return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + "fillme" + "," + currentBorrowerID;

        else
            return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + wait + "," + currentBorrowerID;
    }
}
