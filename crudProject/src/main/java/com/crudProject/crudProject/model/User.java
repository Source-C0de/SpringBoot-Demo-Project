package com.crudProject.crudProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String researchtile;
    private String researchpaper;
    private String paperlink;

    public User(){

    }
    public User(String researchtile, String researchpaper, String paperlink) {
        this.researchtile = researchtile;
        this.researchpaper = researchpaper;
        this.paperlink = paperlink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getresearchtile() {
        return researchtile;
    }

    public void setresearchtile(String researchtile) {
        this.researchtile = researchtile;
    }

    public String getresearchpaper() {
        return researchpaper;
    }

    public void setresearchpaper(String researchpaper) {
        this.researchpaper = researchpaper;
    }

    public String getpaperlink() {
        return paperlink;
    }

    public void setpaperlink(String paperlink) {
        this.paperlink = paperlink;
    }
}
