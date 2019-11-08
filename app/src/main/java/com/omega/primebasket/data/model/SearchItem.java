package com.omega.primebasket.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class SearchItem {

    private String title_tv;
    private String style_tv;
    private String place_tv;
    private String filters;
    private String ratings_tv;
    private String time_tv;
    private String image;

    public SearchItem(String title_tv, String style_tv, String place_tv, String filters, String ratings_tv, String time_tv, String image) {
        this.title_tv = title_tv;
        this.style_tv = style_tv;
        this.place_tv = place_tv;
        this.filters = filters;
        this.ratings_tv = ratings_tv;
        this.time_tv = time_tv;
        this.image = image;
    }

    public String getTitle_tv() {
        return title_tv;
    }

    public void setTitle_tv(String title_tv) {
        this.title_tv = title_tv;
    }

    public String getStyle_tv() {
        return style_tv;
    }

    public void setStyle_tv(String style_tv) {
        this.style_tv = style_tv;
    }

    public String getPlace_tv() {
        return place_tv;
    }

    public void setPlace_tv(String place_tv) {
        this.place_tv = place_tv;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getRatings_tv() {
        return ratings_tv;
    }

    public void setRatings_tv(String ratings_tv) {
        this.ratings_tv = ratings_tv;
    }

    public String getTime_tv() {
        return time_tv;
    }

    public void setTime_tv(String time_tv) {
        this.time_tv = time_tv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
