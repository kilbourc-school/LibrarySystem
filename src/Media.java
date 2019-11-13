import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Media {
    Scanner keyboard = new Scanner(System.in);
    /*
    attributes
     */
    String title;
    String description;
    String author;
    String subject;
    int copies;
    String genre;
    int releaseYear;
    boolean comingSoon;
    LinkedList<iDandCopies> currentBorrowerID;
    LinkedList<iDandCopies> waitListBorrowerIDs;
    LinkedList<Ratings> ratings;

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
        isComingSoon(releaseYear);

        this.currentBorrowerID = new LinkedList<>();
        this.waitListBorrowerIDs = new LinkedList<>();
        this.ratings = new LinkedList<>();
        currentBorrowerID.add(new iDandCopies((long) 0, 0,LocalDate.now()));
        waitListBorrowerIDs.add((new iDandCopies((long) 0, 0,LocalDate.now())));
        ratings.add(new Ratings(0,""));
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
     * @param comingSoon
     */


    //file I/O
    public Media(String title, String description, String author, String subject, int copies, String genre, int releaseYear, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.copies = copies;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.comingSoon = comingSoon;
        this.currentBorrowerID = currentBorrowerID;
        this.waitListBorrowerIDs = waitListBorrowerIDs;
        this.ratings = ratings;
    }

    public LocalDate getDueDate(Media media, Borrower borrower) {
        for (int i = 0; i < currentBorrowerID.size(); i++) {
            if (media.currentBorrowerID.get(i).iD.equals(borrower.getID())) {
                return media.currentBorrowerID.get(i).dueDate;
            }
        }
        return null;
    }

    public void addRating(int stars, String comment) {
       this.ratings.add(new Ratings(stars,comment));
    }

    public void checkOutMedia(Media media, Borrower currentBorrower, int copies) {

        if ((this.copies - copies) >= 0) {
            if (currentBorrower.getBorrowLimit() < copies) {
                System.out.println("that's too many copies! You have been placed on the wait list");
                waitListBorrowerIDs.add(new iDandCopies(currentBorrower.getID(),copies,LocalDate.now()));
                return;
            }
            if (currentBorrower.getFines() > 0) {
                System.out.println("you have to pay a fine. Want to pay your fines?");
                String input = keyboard.nextLine();
                if (input.equals("yes")) {
                    System.out.println("your fines have been cleared. continuing with checkout");
                    currentBorrower.setFines(0);
                } else {
                    System.out.println("well,if you dont want to pay them, then you get no media");
                    return;
                }
            }
            if (currentBorrowerID == null)
                currentBorrowerID = new LinkedList<>();

            LocalDate today = LocalDate.now();

            currentBorrowerID.add(new iDandCopies(currentBorrower.getID(), copies, today.plusDays(media.getCheckoutLimit())));

            this.copies = this.copies - copies;
        }
        else{
            System.out.println("Not enough copies are in at the moment. you have been added to the wait list.");
            waitListBorrowerIDs.add(new iDandCopies(currentBorrower.getID(),copies,LocalDate.now()));
        }
        System.out.println("The check out date of this media is " + (LocalDate.now().plusDays(media.getCheckoutLimit())));

    }

    public abstract int getCheckoutLimit();

    public LinkedList<iDandCopies> getCurrentBorrowerID() {
        return currentBorrowerID;
    }


    public void checkInMedia(Media media, Long iD, int copies, LocalDate due) {
        iDandCopies found = new iDandCopies(iD, copies, due);
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


    public void assignFromWaitList(Media media) {
        if (media.waitListBorrowerIDs.peek() != null) {
            if (media.waitListBorrowerIDs.peek().getCopies() < this.copies)
            media.currentBorrowerID.add(media.waitListBorrowerIDs.pop());
            media.copies -= media.waitListBorrowerIDs.peek().getCopies();
        } else {
            media.copies += copies;
        }
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
        if (copies < 0) {
            System.out.println("Attempting to remove more copies than the Library contains, copies set to 0");
            this.copies = 0;
        } else {
            this.copies = copies;
        }
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


    //Accessor for title.
    public Boolean getAvailability() {
        return copies >= 1;
    }

    private Boolean isComingSoon(int releaseYear) {
        LocalDate today = LocalDate.now();
        return ((releaseYear - today.getYear()) < 1);

    }

    public String toStringList() {

        String current = ".0/0/" + LocalDate.now();

            if (!(currentBorrowerID.size() <= 0)) {
                current = "";
                for (int i = 0; i < currentBorrowerID.size(); i++) {

                    current += currentBorrowerID.pop().toString();
                }
            }
        String wait = ".0/0/" + LocalDate.now();

            if (!(waitListBorrowerIDs.size() <= 0)) {
                wait = "";
                for (int i = 0; i <= waitListBorrowerIDs.size(); i++) {

                    wait += waitListBorrowerIDs.pop().toString();
                }
            }
        String rating = ".0/0";
        if (ratings.peek() != null)
            if (!(ratings.size() <= 0)) {
                 rating = "";
                for (int i = 0; i <= ratings.size(); i++) {
                    rating += ratings.pop().toStringList();
                }
            }
        return title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear +  "," + comingSoon + "," + current + "," + wait+ "," + rating;
    }


    public void showRatings() {
        for (int i = 0; i<ratings.size();i++)
        System.out.println(this.ratings.get(i));
    }
}
