import java.time.LocalDate;
import java.util.LinkedList;
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
    LinkedList<iDandCopies> currentBorrowerID;
    LinkedList<iDandCopies> waitListBorrowerIDs;

    /**
     * Default constructor with all share variable for all media types
     */
    Media() {
        setTitle();
        setDescription();
        setAuthor();
        setSubject();
        setCopies();
        setGenre();
        setReleaseYear();
        setStars();
        isComingSoon(releaseYear);

        this.currentBorrowerID = new LinkedList<>();
        this.waitListBorrowerIDs = new LinkedList<>();
        currentBorrowerID.add(new iDandCopies((long) 0,0));
        waitListBorrowerIDs.add((new iDandCopies((long) 0,0)));
    }

    /**
     * Constructor for read in from toString .txt files
     *
     * @param title
     * @param description
     * @param author
     * @param subject
     * @param copies
     * @param genre
     * @param releaseYear
     * @param stars
     * @param comingSoon
     */
    Media(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.copies = copies;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stars = stars;
        this.comingSoon = comingSoon;
        this.currentBorrowerID = new LinkedList<>();
        this.waitListBorrowerIDs = new LinkedList<>();
        currentBorrowerID.add(new iDandCopies((long) 0, 0));
        waitListBorrowerIDs.add((new iDandCopies((long) 0, 0)));
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

    public void checkOutMedia(Media media, Borrower currentBorrower, int copies) {
        if (isAllCheckedOut(media)) {
            System.out.println("Sorry, book is currently checked out.");
            addToWaitListBorrowerIDs(currentBorrower.getID(), copies);

        } else if ((this.copies - copies) >= 0) {
if (currentBorrower.getBorrowLimit() < copies){
    System.out.println("that's too many copies! no media for you.");
    return;
}
if (currentBorrower.getFines() >0){
    System.out.println("you have to pay a fine. Want to pay your fines?");
    String input = keyboard.nextLine();
    if (input.equals("yes")){
        System.out.println("your fines have been cleared. continuing with checkout");
        currentBorrower.setFines(0);
    }
    else{
        System.out.println("well,if you dont want to pay them then you get no media");
        return;
    }
}
            if (currentBorrowerID == null)
                currentBorrowerID = new LinkedList<>();
            currentBorrowerID.add(new iDandCopies(currentBorrower.getID(), copies));
            this.copies = this.copies - copies;
        } else {
            if (waitListBorrowerIDs == null)
                waitListBorrowerIDs = new LinkedList<>();
            System.out.println("Sorry, not enough books are in right now. Being placed on waitlist.");
            addToWaitListBorrowerIDs(currentBorrower.getID(), copies);
        }

    }

    public void setWaitListBorrowerIDs(LinkedList waitListBorrowerIDs) {
        this.waitListBorrowerIDs = waitListBorrowerIDs;
    }

    public void setCurrentBorrowerID(Long currentBorrowerID, int copies) {
        this.currentBorrowerID.add(new iDandCopies(currentBorrowerID, copies));
    }

    public boolean isAllCheckedOut(Media media) {
        return media.getCopies() == 0;
    }

    public void checkInMedia(Media media, Long iD, int copies) {
        iDandCopies found = new iDandCopies(iD, copies);
        currentBorrowerID.remove(found);
        assignFromWaitList(copies);
        media.setCopies(media.getCopies() + copies);
    }

    private void assignFromWaitList(int copies) {
        if (waitListBorrowerIDs.peek() != null) {
            int extraCopies = waitListBorrowerIDs.peek().getCopies() - copies;
            currentBorrowerID.add(waitListBorrowerIDs.pop());
            this.copies += extraCopies;
        } else {
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

    public void setDescription() {
        System.out.print("Description: ");
        this.setDescription(keyboard.nextLine());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthor() {
        System.out.print("Author: ");
        this.setAuthor(keyboard.nextLine());
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

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setCopies() {
        System.out.print("Number of Copies: ");
        this.setCopies(keyboard.nextLine());
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGenre() {
        System.out.print("Genre: ");
        this.setGenre(keyboard.nextLine());
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

    public void setReleaseYear() {
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

    public void setStars() {
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

    private Boolean isComingSoon(int releaseYear) {
        LocalDate today = LocalDate.now();
        return ((releaseYear - today.getYear()) < 1);

    }

    public String toStringList() {

        String current = ".0/0";
        if (currentBorrowerID.peek() != null)
            if (!(currentBorrowerID.size() <= 1)) {
                current = "";
                for (int i = 0; i <= currentBorrowerID.size(); i++) {
                    current += currentBorrowerID.pop().toString();
                }
            }
        String wait = ".0/0";
        if (waitListBorrowerIDs.peek() != null)
            if (!(waitListBorrowerIDs.size() <= 1)) {
                wait = "";
                for (int i = 0; i <= waitListBorrowerIDs.size(); i++) {
                    wait += waitListBorrowerIDs.pop().toString();
                }
            }
        return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + current + "," + wait;
    }

    public boolean isComingSoon() {
        return comingSoon;
    }
}
