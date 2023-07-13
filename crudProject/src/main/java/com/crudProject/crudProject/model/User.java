package com.crudProject.crudProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "researchtile", nullable = false)
    private String researchtile;

    @Column(name = "researchpaper")
    private String researchpaper;

    @Column(name = "paperlink")
    private String paperlink;

    public User(){

    }
    public User(String researchtile, String researchpaper, String paperlink) {
        super();
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
