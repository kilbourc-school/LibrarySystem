public class Magazine extends Media {
    int issue;
    int volume;
    int checkOutLimit = 21;

    Magazine (){
        super();
        setVolume();
        setIssue();
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
