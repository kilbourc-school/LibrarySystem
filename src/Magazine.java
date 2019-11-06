import java.util.LinkedList;

public class Magazine extends Media {
    int issue;
    int volume;
    int checkOutLimit = 21;

    Magazine (){
        super();
        setVolume();
        setIssue();
    }
    public Magazine(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, int volume, int issue) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs);
        this.volume = volume;
        this.issue = issue;
    }

    @Override
    public int getCheckoutLimit() {
        return checkOutLimit;
    }

    public int getIssue() {
        return issue;
    }
    public void setIssue(){
        System.out.print("Issue #: ");
        this.setIssue(keyboard.nextInt());
    }
    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(){
        System.out.print("Volume #: ");
        this.setIssue(keyboard.nextInt());
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String toStringList() {
        return "Magazine," + super.toStringList() + "," + volume+','+issue;
    }
}