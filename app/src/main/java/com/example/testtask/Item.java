package com.example.testtask;

public class Item {

    private String imageID;
    private String imageTitle;
    private String imageURL;
    private String imageAuthorsName;
    private int imageLikes;

    public Item() {
    }

    public Item(String imageID, String imageTitle, String imageURL, String imageAuthorsName, int imageLikes) {
        this.imageID = imageID;
        this.imageTitle = imageTitle;
        this.imageURL = imageURL;
        this.imageAuthorsName = imageAuthorsName;
        this.imageLikes = imageLikes;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageAuthorsName() {
        return imageAuthorsName;
    }

    public void setImageAuthorsName(String imageAuthorsName) {
        this.imageAuthorsName = imageAuthorsName;
    }

    public int getImageLikes() {
        return imageLikes;
    }

    public void setImageLikes(int imageLikes) {
        this.imageLikes = imageLikes;
    }

}
