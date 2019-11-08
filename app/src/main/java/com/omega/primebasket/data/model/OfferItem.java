package com.omega.primebasket.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class OfferItem {

    private String tv1;
    private String tv2;
    private String tv3;
    private String id;
    private String image;

    public OfferItem(String tv1, String tv2, String tv3, String id, String image) {
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.id = id;
        this.image = image;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
