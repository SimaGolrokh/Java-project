package model;

public class EBook extends Book {
    private String downloadLink;

    public EBook(String title, String author, String ISBN, boolean isAvailable, String downloadLink) {
        super(title, author, ISBN, isAvailable);
        this.downloadLink = downloadLink;
    }
    public String getDownloadLink() {
        return downloadLink;
    }
    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
