import java.time.LocalDate;

public class iDandCopies {
    Long iD;
    int copies;
    LocalDate dueDate;
     /*
     paramaterized constructor
      */
    public iDandCopies(Long iD, int copies, LocalDate dueDate) {
        this.iD = iD;
        this.copies = copies;
        this.dueDate = dueDate;
    }
    /*
    getters and setters
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    /*
    prints objects as strings
     */
    public String toString() {
        return "." + iD + "/" + copies;
    }
}
