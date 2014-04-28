package org.sfeirapp.model;

import android.media.Image;

/**
 * Created by tarekelchami on 28/04/14.
 */
public class Monument {

    private String nomMonument;
    private String lieuMonument;
    private Long longetude;
    private Long latitude;

    private String description;

    private Image photoMonument;

    public Monument() {
    }

    public String getNomMonument() {
        return nomMonument;
    }

    public void setNomMonument(String nomMonument) {
        this.nomMonument = nomMonument;
    }

    public String getLieuMonument() {
        return lieuMonument;
    }

    public void setLieuMonument(String lieuMonument) {
        this.lieuMonument = lieuMonument;
    }

    public Long getLongetude() {
        return longetude;
    }

    public void setLongetude(Long longetude) {
        this.longetude = longetude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getPhotoMonument() {
        return photoMonument;
    }

    public void setPhotoMonument(Image photoMonument) {
        this.photoMonument = photoMonument;
    }
}
