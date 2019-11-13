public class Ratings {
    private int rating;
    private String comment;

    public Ratings(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ratings: "+rating+" Comment:"+comment;
    }

    public String toStringList() {
        return "." + rating + "/" + comment+",";
    }
}
