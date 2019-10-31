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
    LinkedList<iDandCopies> currentBorrowerID;
    LinkedList<iDandCopies> waitListBorrowerIDs;


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

    public Media(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.copies = copies;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stars = stars;
        this.comingSoon = comingSoon;
        this.currentBorrowerID = currentBorrowerID;
        this.waitListBorrowerIDs = waitListBorrowerIDs;
    }

    public void checkOutBook(Media media, Long iD, int copies) {
        if (isAllCheckedOut(media)) {
            System.out.println("Sorry, book is currently checked out.");
            addToWaitListBorrowerIDs(iD,copies);
        }
        else if ((this.copies - copies) > 0) {
                currentBorrowerID.add(new iDandCopies(iD, copies));
                this.copies = this.copies - copies;
            }
        else{
            System.out.println("Sorry, not enough books are in right now. Being placed on waitlist.");
            addToWaitListBorrowerIDs(iD,copies);
        }

    }

    public void setWaitListBorrowerIDs(LinkedList waitListBorrowerIDs) {
        this.waitListBorrowerIDs = waitListBorrowerIDs;
    }

    public void setCurrentBorrowerID(Long currentBorrowerID, int copies) {
        this.currentBorrowerID.add(new iDandCopies(currentBorrowerID,copies));
    }

    public boolean isAllCheckedOut(Media media) {
       if (media.getCopies() == 0)
          return true;
       else
           return false;

    }
public void checkInMedia(Media media, Long iD, int copies){
        if (currentBorrowerID.contains(new iDandCopies(iD, copies))) {
            currentBorrowerID.remove(new iDandCopies(iD, copies));
            assignFromWaitList(copies);
        }
}
    private void assignFromWaitList(int copies) {
        if (waitListBorrowerIDs.peek() != null) {
            int extraCopies = waitListBorrowerIDs.peek().getCopies() - copies;
            currentBorrowerID.add(waitListBorrowerIDs.pop());
            this.copies += extraCopies;
        }
        else{
            this.copies += copies;
        }
    }

    public void addToWaitListBorrowerIDs(Long borrowerID, int copies) {
        if (waitListBorrowerIDs.size() <= 10) {
            this.waitListBorrowerIDs.add(new iDandCopies(borrowerID, copies));
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
        String current = "";
        for (int i = 0; i < waitListBorrowerIDs.size(); i++) {
            wait += waitListBorrowerIDs.peek().toString();
            waitListBorrowerIDs.pop();
        }
        for (int i = 0; i < currentBorrowerID.size(); i++) {
            current += currentBorrowerID.peek().toString();
            currentBorrowerID.pop();
        }
        if (wait.equals("") && current.equals(""))
            return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + "x" + "," + 0;

        else if (wait.equals("") && !current.equals(""))
            return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + "x" + "," + current;
        else
            return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + wait + "," + current;
    }
}
