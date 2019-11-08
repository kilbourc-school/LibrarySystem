import java.util.LinkedList;

public class Magazine extends Media {
    /*
    attributes
     */
    int volume;
    int issue;
    int checkOutLimit = 21;
   /*
   method to call setvolume, setissue, and super method
    */
    Magazine (){
        super();
        setVolume();
        setIssue();
    }
    /*
    paramaterized constructor & super
     */
    public Magazine(String title, String description, String author, String subject, int copies, String genre, int releaseYear, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings, int volume, int issue) {
        super(title, description, author, subject, copies, genre, releaseYear, comingSoon, currentBorrowerID, waitListBorrowerIDs, ratings);
        this.volume = volume;
        this.issue = issue;
    }

    @Override
    /*
    getter and setter for checkoutlimit and set issue
     */
    public int getCheckoutLimit() {
        return checkOutLimit;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public void setIssue() {
        System.out.print("Issue #: ");
        this.setIssue(keyboard.nextInt());
    }

    /*
    getter and setter for volume
     */
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setVolume() {
        System.out.print("Volume #: ");
        this.setVolume(keyboard.nextInt());
    }

    /**
     * .txt read in
     * @return
     */
    public String toStringList() {
        return "Magazine," + super.toStringList()+"," + volume + ',' + issue;
    }
    /**
     * object string override
     */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " Volume: " + volume + " Issue: " + issue + " copies: " + copies;
    }
}
