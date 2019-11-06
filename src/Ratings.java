public class Ratings {
    private int rating;
    private String comment;

    public Ratings(int rating, String comment) {
        /*
        attributes
         */
        this.rating = rating;
        this.comment = comment;
    }
     /*
     getter for get rating
      */
    public int getRating() {
        return rating;
    }
    /*
    setter for setRating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /*
    getter for getComment
     */
    public String getComment() {
        return comment;
    }
     /*
     setter for setComment
      */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    /*
    toString method to print objects as strings
     */
    public String toString() {
        return "rating: " + rating + " comment:" + comment;
    }
}
