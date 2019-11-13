import java.time.LocalDate;

public class iDandCopies {
    Long iD;
    int copies;
    LocalDate dueDate;

    public iDandCopies(Long iD, int copies, LocalDate dueDate) {
        this.iD = iD;
        this.copies = copies;
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
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
    public String toString() {
        return "." + iD + "/" + copies + "/"+dueDate+",";
    }
}
