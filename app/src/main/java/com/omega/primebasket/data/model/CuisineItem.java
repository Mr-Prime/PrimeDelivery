package com.omega.primebasket.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class CuisineItem {

    private String title;
    private int id;
    private String image;
    private String outlets;

    public CuisineItem(String title, int id, String image, String outlets) {
        this.title = title;
        this.id = id;
        this.image = image;
        this.outlets = outlets;
    }

    public String getOutlets() {
        return outlets;
    }

    public void setOutlets(String outlets) {
        this.outlets = outlets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
